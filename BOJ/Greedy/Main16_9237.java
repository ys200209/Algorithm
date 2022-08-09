import java.util.*;
import java.io.*;

public class Main16_9237 {
    static int N;
    static Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        int i=0;
        while(st.hasMoreTokens()) {
            pq.offer(Integer.parseInt(st.nextToken()));
        }

        int result = 0;
        for(i=1; i<=N; i++) {
            result = Math.max(result, pq.poll() + i);
        }
        System.out.println(result + 1);
    }
}
