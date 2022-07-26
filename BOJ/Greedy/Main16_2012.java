import java.util.*;
import java.io.*;

public class Main16_2012 {
    static int N, count=0;
    static boolean[] visited;
    static Queue<Integer> n1 = new PriorityQueue<>(); // 예상 석차
    static Queue<Integer> n2 = new PriorityQueue<>(); // 실제 석차
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        for(int i=1; i<=N; i++) {
            int number = Integer.parseInt(br.readLine());
            
            if (!visited[i]) n2.offer(i);

            if (!visited[number]) {
                visited[number] = true;
                if (n2.contains(number)) n2.remove(number);
                continue;
            } else n1.offer(number);
        }

        getCount();

        System.out.println(count);
    }

    public static void getCount() {
        while(!n1.isEmpty()) {
            count += Math.abs(n1.poll() - n2.poll());
        }
    }

}
