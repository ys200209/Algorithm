import java.util.*;
import java.io.*;

public class Main16_1461 {
    static int N, M, result1=(int)1e9, result2=(int)1e9;
    static Queue<Integer> pq1 = new PriorityQueue<>();
    static Queue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());
            pq1.offer(n);
            pq2.offer(n);
        }

        




    }

}
