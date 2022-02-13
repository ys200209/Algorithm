import java.util.*;
import java.io.*;

public class Main28_2 {
    static int V, MAX=0, d=0;
    static ArrayList<Node> graph = new ArrayList<Node>();
    static Queue<Integer> queue = new LinkedList<>();
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        V = Integer.parseInt(br.readLine());
        graph = new int[V+1][V+1];

        for(int i=0; i<=V; i++) {
            //graph.add(new ArrayList<>());
        }

        for(int i=1; i<=V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            st.nextToken();

            while(true) {
                int node = Integer.parseInt(st.nextToken());
                if (node == -1) break;
                int distance = Integer.parseInt(st.nextToken());

                graph.get(i).add(new Node(node, distance));
                // 1 (2)-> 3 (3)-> 4 (4)-> 2 -> 3
            }
        }
        
        visited = new boolean[N];
        DFS(1, 0); // (node, dis);

        for(Node n1 : graph) {
            // System.out.println
        }

        System.out.println("MAX : " + MAX);
        
    }
    

    public static void DFS(int node, int dis) {
        if (dis > MAX) {
            MAX = dis;
            return;
        }

        for(int i=1; i<=V; i++) {
            if (!visited[node][i]) {
                visited[node][i] = true;
                DFS()
                visited[node][i] = false;
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

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }

}