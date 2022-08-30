import java.util.*;
import java.io.*;

public class Main25_1238 {
    static int INF = (int)1e9;
    static int N, M, X, result=0;
    static int[] dp;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static Queue<Node> pq = new PriorityQueue<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<Node>());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph.get(A).add(new Node(B, C));
        }
        
        for(int i=1; i<=N; i++) {
            if (i != X) {
                result = Math.max(result, dijkstra(i, X) + dijkstra(X, i));
            }
        }
        System.out.println(result);
    }

    public static int dijkstra(int start, int end) {
        dp = new int[N+1];
        Arrays.fill(dp, INF);

        dp[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.index;
            int dis = node.distance;

            if (dp[now] < dis) continue;

            for(int i=0; i<graph.get(now).size(); i++) {
                int cost = dp[now] + graph.get(now).get(i).distance;

                if (dp[graph.get(now).get(i).index] > cost) {
                    dp[graph.get(now).get(i).index] = cost;
                    pq.offer(new Node(graph.get(now).get(i).index, cost));
                }
            }
        }
        return dp[end];
    }

    static class Node implements Comparable<Node> {

        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node n1) {
            return this.distance - n1.distance;
        }

    }

}

