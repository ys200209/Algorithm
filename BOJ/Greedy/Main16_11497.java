import java.util.*;
import java.io.*;

public class Main16_11497 {
    static int T, N;
    static int[] list;
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> pq;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            pq = new PriorityQueue<>();

            N = Integer.parseInt(br.readLine());
            list = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()) {
                pq.offer(Integer.parseInt(st.nextToken()));
            }

            int index=0;
            while(!pq.isEmpty()) {
                list[index] = pq.poll();
                if (!pq.isEmpty()) list[N-index-1] = pq.poll();
                index++;
            }
            
            int max = 0;
            for(int i=0; i<N; i++) {
                if (i == N-1) max = Math.max(max, Math.abs(list[N-1] - list[0]));
                else max = Math.max(max, Math.abs(list[i] - list[i+1]));
            }
            sb.append(max + "\n");
        }
        System.out.println(sb);
    }

}