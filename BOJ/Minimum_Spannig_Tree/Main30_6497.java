import java.util.*;
import java.io.*;

public class Main30_6497 {
    static int N, M, MAX, result;
    static int[] parents;
    static Queue<Node> pq;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str;
        while((str = br.readLine()) != null) {
            N = Integer.parseInt(str.split(" ")[0]);
            M = Integer.parseInt(str.split(" ")[1]);
            
            if (N == 0 && M == 0) break;

            parents = new int[N];
            pq = new PriorityQueue<>();
            MAX=0;
            result=0;

            for(int i=0; i<N; i++) parents[i] = i;

            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                int Z = Integer.parseInt(st.nextToken());
    
                pq.offer(new Node(X, Y, Z));
                pq.offer(new Node(Y, X, Z));
                MAX += Z;
            }

            while(!pq.isEmpty()) {
                Node node = pq.poll();
                int A = node.from;
                int B = node.to;
    
                if (!union(A, B)) result += node.distance;
            }
            sb.append((MAX - result) + "\n");
        }
        System.out.println(sb);
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
            return this.distance - node.distance;
        }

    }

}

