
import java.util.*;

public class Programmers {
    static int INF = (int)1e9;
    static int[] dp;
    static Queue<Node> pq = new PriorityQueue<>();
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(3, 5))); // [3,1,2]
//        System.out.println(Arrays.toString(solution(3, 6))); // [3,2,1]
    }

    public static int solution(int N, int[][] road, int K) {
        int answer = 0;
        dp = new int[N+1];
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        for(int i=1; i<=N; i++) {
            if (dijkstra(1, i, K)) answer++;
        }

        return answer;
    }

    private static boolean dijkstra(int start, int end, int K) {
        pq.clear();
        Arrays.fill(dp, INF);
        dp[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node poll = pq.poll();
            int now = poll.to;
            int dis = poll.distance;

            if (dp[now] < dis) continue;

            for(int i=0; i<graph.get(now).size(); i++) {
                int cost = dp[now] + graph.get(now).get(i).distance;

                if (cost < dp[graph.get(now).get(i).to]) {
                    dp[graph.get(now).get(i).to] = cost;
                    pq.offer(new Node(graph.get(now).get(i).to, cost));
                }
            }
        }

        System.out.println(start + " -> " + end + " : " + dp[end]);

        if (dp[end] <= K) return true;
        else return false;
    }

    static class Node implements Comparable<Node> {
        int to;
        int distance;

        public Node(int to, int distance) {
            this.to = to;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node node) {
            return this.distance - node.distance;
        }

    }

}