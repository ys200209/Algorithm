import java.util.*;
import java.io.*;

public class Main30_1647 {
    static StringBuilder sb = new StringBuilder();
    static int N, M, result=0;
    static int[] parents;
    static Node[] nodes;
    static Queue<Node> pq = new PriorityQueue<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parents = new int[N+1];
        nodes = new Node[N+1];

        for(int i=0; i<=N; i++) parents[i] = i;

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            
            pq.offer(new Node(A, B, C));
        }

        while(!pq.isEmpty()) {
            Node node = pq.poll();

            int A = node.from;
            int B = node.to;

            if (union(A, B)) {
                result += node.distance;
            }

        }

        System.out.println("result : " + result);
    }

    public static boolean union(int A, int B) {
        int rootA = find(A);
        int rootB = find(B);

        if (rootA == rootB) return true;

        if (rootA < rootB) parents[rootB] = rootA;
        else parents[rootA] = rootB;
        return false;
    }

    public static int find(int root) {
        if (root == parents[root]) return root;

        return parents[root] = find(parents[root]);
    }

    static class Node implements Comparable<Node> {

        int from;
        int to;
        int distance;

        public Node(int from, int to, int distance) {
            this.from = from;
            this.to = to;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node node) {
            return this.distance = node.distance;
        }

    }
}

