import java.util.*;
import java.io.*;

public class Main28_1 {
    static int N;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] parents;
    static Queue<Integer> queue = new LinkedList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList<ArrayList<Integer>>();
        parents = new int[N+1];
        visited = new boolean[N+1];

        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=1; i<=N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        DFS(1, 0);

        System.out.println(Arrays.toString(parents));

    }

    public static void DFS(int node, int parent) {
        parents[node] = parent;

        visited[node] = true;

        for(int num : graph.get(node)) {
            if (num != node && !visited[num]) {
                parents[num] = node;
                DFS(num, node);
            }
        }

    }

}
