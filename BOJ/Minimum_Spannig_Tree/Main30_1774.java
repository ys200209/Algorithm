import java.util.*;
import java.io.*;

public class Main30_1774 {
    static double result=0;
    static int N, M;
    static Node[] nodes;
    static int[] parents;
    static Queue<Node> pq = new PriorityQueue<>();
    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N+1];
        nodes = new Node[N+1];

        for(int i=1; i<=N; i++) parents[i] = i;

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            for(int j=1; j<i; j++) {
                pq.offer(new Node(i, j, Math.sqrt(Math.pow(nodes[j].x - X, 2) + Math.pow(nodes[j].y - Y, 2))));
            }

            nodes[i] = new Node(X, Y, 0);
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            union(X, Y); // 왜 미리 그어놓은 선은 result 추가 안하냐
        }

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int A = node.x;
            int B = node.y;

            if (!union(A, B)) result += node.distance;
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

}

class Node implements Comparable<Node> {

    int x;
    int y;
    double distance;

    public Node(int x, int y, double distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    @Override public int compareTo(Node node) { 
        if (this.distance > node.distance) return 1; 
        else return -1; 
    }
}