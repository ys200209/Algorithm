import java.util.*;
import java.io.*;

public class Main22_7662 {
    static int T, K;
    static Queue<Long> pq;
    static Queue<Long> reversePQ;
    static Map<Long, Integer> map;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            K = Integer.parseInt(br.readLine());
            pq = new PriorityQueue<>();
            reversePQ = new PriorityQueue<>(Collections.reverseOrder());
            map = new HashMap<>();

            for(int k=0; k<K; k++) {
                String[] command = br.readLine().split(" ");
                if (command[0].equals("I")) {
                    long num = Long.parseLong(command[1]);
                    pq.offer(num);
                    reversePQ.offer(num);
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else { // "D"
                    if (command[1].equals("-1")) {
                        while(!pq.isEmpty()) {
                            long num = pq.poll();
                            if (map.get(num) == null) continue;

                            if (map.get(num) == 1) map.remove(num);
                            else map.put(num, map.get(num)-1);
                            break;
                        }
                    } else { // 1
                        while (!reversePQ.isEmpty()) {
                            long num = reversePQ.poll();
                            if (map.get(num) == null) continue;

                            if (map.get(num) == 1) map.remove(num);
                            else map.put(num, map.get(num)-1);
                            break;
                        }
                    }

                }
            }
            if (map.isEmpty()) sb.append("EMPTY\n");
            else {
                long MIN=0;
                while(!pq.isEmpty()) {
                    long num = pq.poll();
                    if (map.get(num) == null) continue;

                    if (map.get(num) == 1) map.remove(num);
                    else map.put(num, map.get(num)-1);
                    MIN = num;
                    break;
                }

                long MAX = MIN;
                while(!reversePQ.isEmpty()) {
                    long num = reversePQ.poll();
                    if (map.get(num) == null) continue;

                    if (map.get(num) == 1) map.remove(num);
                    else map.put(num, map.get(num)-1);
                    MAX = num;
                    break;
                }
                sb.append(MAX + " " + MIN + "\n");
            }
        }
        System.out.println(sb);
    }
}