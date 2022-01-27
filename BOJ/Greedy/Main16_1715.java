import java.util.*;
import java.io.*;

public class Main16_1715 {
    static int N, now, result=0;
    static Queue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        if (pq.size() == 1) {
            System.out.println("0");
            return;
        }

        while(true) {
            now = pq.poll() + pq.poll();
            result += now;

            if (pq.isEmpty()) {
                System.out.println(result);
                return;
            }
            pq.offer(now);
        }

    }

}