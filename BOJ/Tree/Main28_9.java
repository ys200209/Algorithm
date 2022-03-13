import java.util.*;
import java.io.*;

public class Main28_9 {
    static int N;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] parent;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        visited = new boolean[N+1];

        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
            graph.get(B).add(A);
        }

        findRoot(1);
        
        for(int i=2; i<=N; i++) {
            sb.append(parent[i] + "\n");
        }
        System.out.println("-----------------------");
        System.out.println(sb);

    }

    public static void findRoot(int root) {
        visited[root] = true;

        for(int node : graph.get(root)) {
            if (!visited[node]) {
                parent[node] = root;
                findRoot(node);
            }
        }

    }
    


}
