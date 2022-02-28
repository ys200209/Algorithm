import java.util.*;
import java.io.*;

public class Main16_15903 {
    static int N, M, result=0;
    static Queue<Integer> pq = new PriorityQueue<>();
    
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()) {
            pq.offer(Integer.parseInt(st.nextToken()));
        }

        for(int i=0; i<M; i++) {
            int sum = pq.poll() + pq.poll();
            pq.offer(sum);
            pq.offer(sum);
        }

        while(!pq.isEmpty()) {
            result += pq.poll();
        }

        System.out.println(result);

    }

}
