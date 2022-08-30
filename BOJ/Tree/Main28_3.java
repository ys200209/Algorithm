import java.util.*;
import java.io.*;

public class Main28_3 {
    static int N, node, MAX=0;
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];

        for(int i=0; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=1; i<=N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            
            graph[start].add(new Node(end, dis));
            graph[end].add(new Node(start, dis));
        }

        visited = new boolean[N+1];
        DFS(1, 0);

        visited = new boolean[N+1];
        DFS(node, 0);
        
        System.out.println(MAX);

    }

    public static void DFS(int v, int len) {
        if (len > MAX) {
            node = v;
            MAX = len;
        }

        visited[v] = true;

        for(Node n : graph[v]) {
            if (!visited[n.index]) {
                visited[n.index] = true;
                DFS(n.index, len + n.distance);
            }
        }

    }

    static class Node {

        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

    }
}

