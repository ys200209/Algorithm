import java.util.*;
import java.io.*;

public class Main_2075 {
    static int N, result=0;
    static Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()) {
                pq.offer(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i=0; i<N; i++) {
            result = pq.poll();
        }
        System.out.println(result);
    }
}