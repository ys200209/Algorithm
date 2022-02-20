import java.util.*;
import java.io.*;

public class Main28_2 {
    static int V, n, MAX=0;
    // static int[][] graph;
    static ArrayList<Node>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        V = Integer.parseInt(br.readLine());
        graph = new ArrayList[V+1];
        visited = new boolean[V+1];

        for(int i=0; i<=V; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=1; i<=V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            int start = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()) {
                
                int node = Integer.parseInt(st.nextToken());
                if (node == -1) break;
                int dis = Integer.parseInt(st.nextToken());

                graph[start].add(new Node(node, dis));
            }
        }

        /*for(int i=0; i<=V; i++) {
            System.out.println("\ni : " + i);
            for(int j=0; j<graph[i].size(); j++) {
                System.out.print(graph[i].get(j).index + " ");
            }
        }*/
        
        
        DFS(1, 0);
        visited = new boolean[V+1];

        DFS(n, 0);
        System.out.println(MAX);
    }

    public static void DFS(int v, int len) {
        if (len > MAX) {
            n = v;
            MAX = len;
        }
        
        visited[v] = true;

        for(Node node : graph[v]) {
            if (!visited[node.index]) {
                
                visited[node.index] = true;
                DFS(node.index, len + node.distance);
            }
        }
    }

}

class Node {

    int index;
    int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

}