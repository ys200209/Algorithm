import java.util.*;
import java.io.*;

public class Main_13975 {
    static int T, K;
    static Queue<Long> pq;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            pq = new PriorityQueue<>();
            int sum = 0;
            K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");

            while(st.hasMoreTokens()) {
                pq.offer(Long.parseLong(st.nextToken()));
            }

            while(pq.size() > 1) {
                long num = pq.poll() + pq.poll();
                pq.offer(num);
                sum += num;
            }
            sb.append(sum + "\n");
        }
        System.out.println(sb);
    }
}