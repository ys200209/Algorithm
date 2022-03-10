import java.util.*;
import java.io.*;

public class Main25_1916 {
    static int INF = (int)1e9;
    static int N, M;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int[] dp;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dp = new int[N+1];

        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph.get(A).add(new Node(B, C));
        }

        Arrays.fill(dp, INF);

        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int finish = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(start, finish));
    }

    public static int dijkstra(int start, int finish) {
        Queue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dp[start] = 0;

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.index;
            int dis = node.distance;

            if (dp[now] < dis) continue;

            for(int i=0; i<graph.get(now).size(); i++) {
                int cost = dp[now] + graph.get(now).get(i).distance;

                if (cost < dp[graph.get(now).get(i).index]) {
                    dp[graph.get(now).get(i).index] = cost;
                    pq.offer(new Node(graph.get(now).get(i).index, cost));
                }   
            }

        }

        return dp[finish];
    }

}

class Node implements Comparable<Node> {

    int index;
    int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node node) {
        return this.distance - node.distance;
    }

}