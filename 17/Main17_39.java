import java.io.*;
import java.util.*;

public class Main17_39 {
    static int INF = (int) 1e9;
    static int T, N;
    static ArrayList<ArrayList<Locate>> graph;
    static Queue<Locate> pq;
    static int[] d;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            N = Integer.parseInt(br.readLine());
            d = new int[N+1];
            graph = new ArrayList<ArrayList<Locate>>();
            pq = new PriorityQueue<>();

            for(int i=0; i<=N; i++) {
                graph.add(new ArrayList<Locate>());
            }

            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                graph.get(a).add(new Locate(b, c));
            }

            Arrays.fill(d, INF);

            sb.append(dijkstra(0));

        }

        System.out.println(sb);
        
    }

    public static int dijkstra(int start) {
        pq.offer(new Locate(start, 0));
        d[start] = 0;

        while(!pq.isEmpty()) {
            Locate locate = pq.poll();

            int now = locate.getIndex();
            int dis = locate.getDistance();

            if (d[now] > dis) continue;

            for(int i=0; i<graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();

                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Locate(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
        return d[N];
    }
    
}

class Locate implements Comparable<Locate> {

    private int index;
    private int distance;

    public Locate(int index, int distance) {
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
    public int compareTo(Locate l1) {
        return this.getDistance() - l1.getDistance();
    }

}