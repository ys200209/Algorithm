import java.util.*;
import java.io.*;

public class Main28_2 {
    static int N;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static Queue<Integer> queue = new LinkedList<>();
    static int[] parents;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        parents = new int[N+1];

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

        System.out.println("----------------");
        for(int i=2; i<=N; i++) {
            System.out.println(parents[i]);
        }
    }

    public static void DFS(int start, int parent) {
        parents[start] = parent;
        
        for(int node : graph.get(start)) {
            if (node != parent) DFS(node, start);
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