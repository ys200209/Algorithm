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
                if (P.charAt(i) - 'R' == 0) { // 명령어가 R이라면
                    isReverse = !isReverse;
                } else { // 명령어가 D라면
                    remove = -1;
                    if (isReverse) { // 현재 뒤집힌 상태로 빼야 한다면 (Stack)
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
                    } else { // 아니라면 (Queue)
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
                if (isReverse) { // 뒤집힌 경우 (Stack)
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
                } else { // 그렇지 않은 경우 (Queue)
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
