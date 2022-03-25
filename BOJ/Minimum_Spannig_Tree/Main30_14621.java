import java.util.*;
import java.io.*;

public class Main30_14621 {
    static int N, M, result = 0;
    static String[] nodes;
    static int[] parents;
    static Queue<Node> pq = new PriorityQueue<>();
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nodes = new String[N+1];
        parents = new int[N+1];
        visited = new boolean[N+1];

        for(int i=0; i<=N; i++) parents[i] = i;

        st = new StringTokenizer(br.readLine(), " ");
        int i=1;
        while(st.hasMoreTokens()) {
            nodes[i] = st.nextToken();
            i++;
        }

        // System.out.println("nodes : " + Arrays.toString(nodes));

        for(i=0; i<M; i++) {
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

            if (nodes[A].equals(nodes[B])) continue; // 같은 성별의 대학교라면 길을 잇지 않는다.

            // System.out.println("A : " + A + ", nodes[A] : " + nodes[A]);
            // System.out.println("B : " + B + ", nodes[B] : " + nodes[B]);

            if (!union(A, B)) {
                result += node.distance;
                // System.out.println(A + " - " + B + " : " + node.distance);
                visited[A] = true;
                visited[B] = true;
            }
        }
        
        for(i=1; i<=N; i++) {
            if (!visited[i]) {
                System.out.println(-1);
                return;
            }
        }

        // System.out.println(Arrays.toString(parents));
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

}

class Node implements Comparable<Node> {

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