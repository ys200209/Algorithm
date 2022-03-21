import java.util.*;
import java.io.*;

public class Main_1655 {
    static int N;
    static Queue<Integer> frontPQ = new PriorityQueue<>(Collections.reverseOrder());
    static Queue<Integer> backPQ = new PriorityQueue<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            if (i % 2 == 0) backPQ.offer(Integer.parseInt(br.readLine()));
            else frontPQ.offer(Integer.parseInt(br.readLine()));

            if (!frontPQ.isEmpty()) {
                if (frontPQ.peek() > backPQ.peek()) {
                    backPQ.offer(frontPQ.poll());
                    frontPQ.offer(backPQ.poll());
                }
            }

            if (i % 2 == 0) sb.append(backPQ.peek() + "\n");
            else sb.append(frontPQ.peek() + "\n");
        }
        System.out.println(sb);
    }

}
