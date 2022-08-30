import java.util.*;
import java.io.*;

public class Main30_4386 {
    static int N;
    static double result=0;
    static int[] parents;
    static Node[] nodes;
    static Queue<Node> pq = new PriorityQueue<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        nodes = new Node[N];
        parents = new int[N+1];

        for(int i=1; i<=N; i++) parents[i] = i;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            double A = Double.parseDouble(st.nextToken());
            double B = Double.parseDouble(st.nextToken());

            for(int j=0; j<i; j++) {
                pq.offer(new Node(i, j, Math.sqrt(Math.pow(nodes[j].from - A, 2) + Math.pow(nodes[j].to - B, 2))));
            }

            nodes[i] = new Node(A, B, 0);
        }

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int A = (int)node.from;
            int B = (int)node.to;

            if(!union(A, B)) result += node.distance;
        }

        
        System.out.println(String.format("%.2f", result));
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
        if (parents[root] == root) return root;

        return parents[root] = find(parents[root]);
    }

    static class Node implements Comparable<Node> {

        double from;
        double to;
        double distance;

        public Node(double from, double to, double distance) {
            this.from = from;
            this.to = to;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node node) {
            return (int) (this.distance - node.distance);
        }

    }

    static class Star {

        int x;
        int y;

        public Star (int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

}
