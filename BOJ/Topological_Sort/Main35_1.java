import java.util.*;
import java.io.*;

public class Main35_1 {
    static int N, M;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] degree;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        degree = new int[N+1];
        visited = new boolean[N+1];

        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
            degree[B] += 1;
        }

        for(int i=1; i<=N; i++) {
            if (degree[i] == 0 && !visited[i]) DFS(i);
        }

        System.out.println(sb);
    }

    public static void DFS(int node) {
        sb.append(node + " ");
        visited[node] = true;

        for(int n : graph.get(node)) {
            degree[n]--;

            if (degree[n] == 0) DFS(n);
        }
    }
}