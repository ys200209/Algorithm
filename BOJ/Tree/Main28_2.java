import java.util.*;
import java.io.*;

public class Main28_2 {
    static int V, MAX=0, d=0, node;
    static ArrayList<Node>[] graph;
    static Queue<Integer> queue = new LinkedList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        V = Integer.parseInt(br.readLine());
        graph = new ArrayList[V+1];

        for(int i=0; i<=V; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=1; i<=V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            st.nextToken();

            while(true) {
                int node = Integer.parseInt(st.nextToken());
                if (node == -1) break;
                int distance = Integer.parseInt(st.nextToken());

                graph[i].add(new Node(node, distance));
                // 1 (2)-> 3 (3)-> 4 (4)-> 2 -> 3
            }
        }
        
        visited = new boolean[V+1];
        DFS(1, 0); // (1, dis);
        System.out.println("(1) MAX : " + MAX);

        visited = new boolean[V+1];
        DFS(node, 0); // (node, dis);
        System.out.println("(2) MAX : " + MAX);

        
    }

    public static void DFS(int point, int dis) {
        if (dis > MAX) {
            MAX = dis;
            node = point;
        }

        visited[point] = true;

        for(Node n : graph[point]) {
            if (!visited[n.getIndex()]) {
                visited[n.getIndex()] = true;
                DFS(n.getIndex(), n.getDistance() + dis);
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