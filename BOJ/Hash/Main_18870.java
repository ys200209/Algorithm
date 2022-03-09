import java.util.*;
import java.io.*;

public class Main_18870 {
    static int N;
    static Queue<Integer> queue = new LinkedList<>();
    static Queue<Integer> pq = new PriorityQueue<>();
    static Map<Integer, Integer> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            queue.offer(num);
            pq.offer(num);
        }

        int i=0;
        while(!pq.isEmpty()) {
            int num = pq.poll();
            if (map.get(num) == null) {
                map.put(num, i);
                i++;
            }
        }

        while(!queue.isEmpty()) {
            sb.append(map.get(queue.poll()) + " ");
        }
        System.out.println(sb);
    }
}