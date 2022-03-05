import java.util.*;
import java.io.*;

public class Main16_5430 {
    static int T, N;
    static String P;
    static Queue<Integer> queue;
    static Stack<Integer> stack;
    static Map<Integer, Integer> map;
    static ArrayList<Integer> list = new ArrayList<>();
    static boolean isReverse;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            queue = new LinkedList<>();
            stack = new Stack<>();
            map = new HashMap<>();
            isReverse = false;

            P = br.readLine();
            N = Integer.parseInt(br.readLine());
            String X = br.readLine();
            String[] arr = X.substring(1, X.length()-1).split(",");
            if (arr[0].equals("")) {
                sb.append("error\n");
                continue;
            }
            for(String num : arr) {
                int number = Integer.parseInt(num);
                queue.offer(number);
                stack.push(number);
                map.put(number, map.getOrDefault(number, 0) + 1);
            }

            int remove = 0;
            for(int i=0; i<P.length(); i++) {
                if (P.charAt(i) - 'R' == 0) { // ��ɾ R�̶��
                    isReverse = !isReverse;
                } else { // ��ɾ D���
                    remove = -1;
                    if (isReverse) { // ���� ������ ���·� ���� �Ѵٸ� (Stack)
                        while(!stack.isEmpty()) {
                            if (map.get(stack.peek()) == null) {
                                stack.pop();
                                continue;
                            }

                            remove = stack.pop();
                            if (map.get(remove) == 1) map.remove(remove);
                            else map.put(remove, map.get(remove) - 1);
                            break;
                        }
                    } else { // �ƴ϶�� (Queue)
                        while(!queue.isEmpty()) {
                            if (map.get(queue.peek()) == null) {
                                queue.poll();
                                continue;
                            }

                            remove = queue.poll();
                            if (map.get(remove) == 1) map.remove(remove);
                            else map.put(remove, map.get(remove) - 1);
                            break;
                        }
                    }
                    if (remove == -1) {
                        sb.append("error\n");
                        break;
                    }
                }
            }
            if (remove != -1) {
                if (isReverse) { // ������ ��� (Stack)
                    while(!stack.isEmpty()) {
                        if (map.get(stack.peek()) == null) {
                            stack.pop();
                            continue;
                        }
                        remove = stack.pop();
                        if (map.get(remove) == 1) map.remove(remove);
                        else map.put(remove, map.get(remove) - 1);
                        list.add(remove);
                    }
                } else { // �׷��� ���� ��� (Queue)
                    while(!queue.isEmpty()) {
                        if (map.get(queue.peek()) == null) {
                            queue.poll();
                            continue;
                        }
                        remove = queue.poll();
                        if (map.get(remove) == 1) map.remove(remove);
                        else map.put(remove, map.get(remove) - 1);
                        list.add(remove);
                    }
                }
                if (list.isEmpty()) sb.append("[]\n");
                else {
                    sb.append("[" + list.get(0));
                    for(int i=1; i<list.size(); i++) {
                        sb.append("," + list.get(i));
                    }
                    sb.append("]\n");
                }
                list.clear();
            }
        }
        System.out.println(sb);
    }

}
