import java.util.*;
import java.io.*;

public class Main16_16435 {
    static int N, L;
    static Queue<Integer> pq = new PriorityQueue<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()) {
            pq.offer(Integer.parseInt(st.nextToken()));
        }

        while(!pq.isEmpty()) {
            L = pq.poll() <= L ? L+1 : L;
        }

        System.out.println(L);
    }

}
