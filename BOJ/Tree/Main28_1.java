import java.util.*;
import java.io.*;

public class Main28_1 {
    static int N;
    static int[] roots;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        roots = new int[N+1];

        DFS(1, 0);
        
        for(int i=2; i<=N; i++) {
            sb.append(roots[i] + "\n");
        }

        System.out.println(sb);

    }

    public static void DFS(int start, int root) {
        roots[start] = root;

        for(int item : graph.get(start)) {
            if (item != root) DFS(item, start);
               
        }
    }

}
