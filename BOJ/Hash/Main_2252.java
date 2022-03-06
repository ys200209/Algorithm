import java.util.*;
import java.io.*;

public class Main_2252 {
    static int N, M;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] count;
    static Queue<Integer> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        count = new int[N+1];
        
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            graph.get(A).add(B);
            count[B] += 1;
        }

        for(int i=1; i<=N; i++) {
            if (count[i] == 0) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            int num = queue.poll();

            if (count[num] == 0) sb.append(num + " ");

            for(int n : graph.get(num)) {
                count[n] -= 1;

                if (count[n] == 0) queue.offer(n);
            }
        }

        System.out.println(sb);

    }

}
