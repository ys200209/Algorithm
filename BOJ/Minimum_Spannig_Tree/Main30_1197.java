import java.util.*;
import java.io.*;

public class Main30_1197 {
    static int V, E, result=0;
    static Node[] nodes;
    static int[] parents;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parents = new int[V+1];
        nodes = new Node[E];

        for(int i=0; i<=V; i++) parents[i] = i;

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            nodes[i] = new Node(A, B, C);
        }
        
        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return n1.distance - n2.distance;
            }
        });

        for(int i=0; i<E; i++) {
            Node node = nodes[i];
            int A = node.from;
            int B = node.to;

            int rootA = find(A);
            int rootB = find(B);

            if (rootA == rootB) continue;

            if (rootA > rootB) parents[rootA] = rootB;
            else parents[rootB] = rootA;

            result += node.distance;
        }
        System.out.println(result);
    }

    public static int find(int root) {
        if (parents[root] == root) return root;

        return parents[root] = find(parents[root]);
    }

    static class Node {

        int from;
        int to;
        int distance;

        public Node(int from, int to, int distance) {
            this.from = from;
            this.to = to;
            this.distance = distance;
        }

    }
}

