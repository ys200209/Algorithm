import java.util.*;
import java.io.*;

public class Main25_3 {
    static int INF = (int) 1e9;
    static int T, n, m, t, s, g, h, result;
    static int[] dp;
    static Queue<City> pq = new PriorityQueue<>();
    static ArrayList<ArrayList<City>> graph;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for(int c=0; c<T; c++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken()); // 교차로 개수
            m = Integer.parseInt(st.nextToken()); // 도로의 개수
            t = Integer.parseInt(st.nextToken()); // 목적지 후보의 개수
            dp = new int[n+1]; // 2001

            st = new StringTokenizer(br.readLine(), " ");
            s = Integer.parseInt(st.nextToken()); // 출발지
            g = Integer.parseInt(st.nextToken()); // 필수 교차로 1
            h = Integer.parseInt(st.nextToken()); // 필수 교차로 2

            graph = new ArrayList<ArrayList<City>>();

            for(int i=0; i<=n; i++) {
                graph.add(new ArrayList<City>());
            }

            for(int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                
                graph.get(a).add(new City(b, d));
                graph.get(b).add(new City(a, d));
            }

            Queue<Integer> queue = new PriorityQueue<>();
            for(int i=0; i<t; i++) {
                result = (int) 1e9;
                int node = Integer.parseInt(br.readLine());

                result = Math.min(dijkstra(s, g) + dijkstra(g, h) + dijkstra(h, node), 
                    dijkstra(s, h) + dijkstra(h, g) + dijkstra(g, node));
                
                if (result <= dijkstra(s, node)) queue.offer(node);
            }

            while(!queue.isEmpty()) {
                sb.append(queue.poll() + " ");
            }
            sb.append("\n");
        
        }

        System.out.println(sb);

    }

    public static int dijkstra(int start, int end) {
        Arrays.fill(dp, INF);

        pq.offer(new City(start, 0));
        dp[start] = 0;

        while(!pq.isEmpty()) {
            City city = pq.poll();
            
            int now = city.getIndex();
            int dis = city.getDistance();

            if (dp[now] < dis) continue;

            for(int i=0; i<graph.get(now).size(); i++) {
                int cost = dp[now] + graph.get(now).get(i).getDistance();

                if (cost < dp[graph.get(now).get(i).getIndex()]) {
                    dp[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new City(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }

        int distance = dp[end];

        if (distance == INF) return 1001; // 가중치의 범위가 1000까지이므로.
        else return distance;
    }
    
}

class City implements Comparable<City> {

    private int index;
    private int distance;

    public City(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(City c1) {
        return this.getDistance() - c1.getDistance();
    }

}