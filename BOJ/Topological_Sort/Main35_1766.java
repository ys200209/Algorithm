import java.util.*;
import java.io.*;

public class Main35_1766 {
    static int N, M;
    static int[] list;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static Queue<Integer> pq = new PriorityQueue<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new int[N+1];
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
            list[B]++;
        }
        
        for(int i=1; i<=N; i++) {
            if (list[i] == 0) pq.offer(i);
        }

        while(!pq.isEmpty()) {
            int num = pq.poll();
            sb.append(num + " ");

            for(int n : graph.get(num)) {
                if (list[n] > 0) {
                    pq.offer(n);
                    list[n]--;
                }
            }
        }

        System.out.println(sb);
    }
}