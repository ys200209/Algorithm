import java.util.*;
import java.io.*;

public class Main25_11779 {
    static Node result;
    static int INF = (int)1e9;
    static int N, M;
    static int[] dp;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static Queue<Node> pq = new PriorityQueue<>();
    static StringBuilder sb = new StringBuilder();
    
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

            graph.get(A).add(new Node(B, C, 1, ""));
        }

        Arrays.fill(dp, INF);
        result = new Node(-1, (int)1e9, -1, "");
        st = new StringTokenizer(br.readLine(), " ");
        dijkstra(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        System.out.println(result.distance + "\n" + result.count + "\n" + result.load);
        
    }

    public static void dijkstra(int start, int end) {
        dp[start] = 0;
        pq.offer(new Node(start, 0, 1, Integer.toString(start) + " "));

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.index;
            int dis = node.distance;

            if (dp[now] < dis) continue;

            if (now == end) {
                result = result.distance > dis ? node : result;
            }

            for(int i=0; i<graph.get(now).size(); i++) {
                int cost = dp[now] + graph.get(now).get(i).distance;

                int index = graph.get(now).get(i).index;
                if (cost < dp[index]) {
                    dp[index] = cost;
                    pq.offer(new Node(index, cost, node.count+1, node.load + Integer.toString(index) + " "));
                }
            }
        }
    }
}

class Node implements Comparable<Node> {

    int index;
    int distance;
    int count;
    String load;

    public Node(int index, int distance, int count, String load) {
        this.index = index;
        this.distance = distance;
        this.count = count;
        this.load = load;
    }

    @Override
    public int compareTo(Node node) {
        return this.distance - node.distance;
    }

}