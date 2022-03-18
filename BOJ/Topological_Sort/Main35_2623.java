import java.util.*;
import java.io.*;

public class Main35_2623 {
    static int N, M, number=1;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] list;
    static Queue<Integer> queue = new PriorityQueue<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new int[N+1];
        
        for(int i=0; i<=N; i++) graph.add(new ArrayList<>()); 

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int count = Integer.parseInt(st.nextToken());
            int A=0;

            if (count >= 1) A = Integer.parseInt(st.nextToken());

            for(int j=0; j<count-1; j++) {
                int B = Integer.parseInt(st.nextToken());

                graph.get(A).add(B);
                list[B]++;
                A = B;
            }
        }

        for(int i=1; i<=N; i++) {
            if (list[i] == 0) {
                queue.offer(i);
                sb.append(i + "\n");
                number++;
            }
        }

        while(!queue.isEmpty()) {
            int num = queue.poll();

            for(int n : graph.get(num)) {
                list[n]--;

                if (list[n] == 0) {
                    queue.offer(n);
                    sb.append(n + "\n");
                    number++;
                }
            }
        }
        if (number == N+1) System.out.println(sb);
        else System.out.println("0");
    }
}