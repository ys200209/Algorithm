import java.util.*;
import java.io.*;

public class Main16_2012 {
    static int N, result=0;
    static boolean[] visited;
    static Queue<Integer> pq1 = new PriorityQueue<>(); // 실제
    static Queue<Integer> pq2 = new PriorityQueue<>(); // 예상

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++) {
            int num = Integer.parseInt(br.readLine());
            
            if (!visited[i]) pq1.offer(i);

            if (!visited[num]) {
                visited[num] = true;
                pq1.remove(num);
            } else {
                pq2.offer(num);
            }
        }

        while(!pq1.isEmpty()) {
            result += Math.abs(pq2.poll() - pq1.poll());
        }
        System.out.println(result);
    }

}