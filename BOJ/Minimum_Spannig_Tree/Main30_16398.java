import java.util.*;
import java.io.*;

public class Main30_16398 {
    static int N, result=0;
    static Queue<Node> pq = new PriorityQueue<>();
    static int[] parents;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        parents = new int[N+1];

        for(int i=1; i<=N; i++) {
            parents[i] = i;
        }
        
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j=1;
            while(st.hasMoreTokens()) {
                int dis = Integer.parseInt(st.nextToken());
                if (i == j) {
                    j++;
                    continue;
                }
                pq.offer(new Node(i, j, dis));
                j++;
            }
        }

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int A = node.start;
            int B = node.end;

            if (!union(A, B)) result += node.distance;
        }

        System.out.println(result);
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

        int start;
        int end;
        int distance;

        public Node(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node node) {
            return this.distance - node.distance;
        }

    }
}

