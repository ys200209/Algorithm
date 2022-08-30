import java.util.*;
import java.io.*;

public class Main25_10282 {
    static int INF = (int)1e9;
    static int T, N, D, C;
    static ArrayList<ArrayList<Node>> graph;
    static Queue<Node> pq;
    static int[] d;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            d = new int[N+1];

            graph = new ArrayList<>();
            for(int i=0; i<=N; i++) graph.add(new ArrayList<>());

            for(int i=0; i<D; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                int S = Integer.parseInt(st.nextToken());

                graph.get(B).add(new Node(A, S));
            }
            Arrays.fill(d, INF);

            dijkstra(C);

            int count=0;
            int time=0;

            for(int i=1; i<=N; i++) {
                
            }

            System.out.println("d : " + Arrays.toString(d));
        }
        
        

    }

    public static void dijkstra(int start) {
        pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        d[start] = 0;

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.index;
            int dis = node.distance;

            if (d[now] < dis) continue;

            for(int i=0; i<graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).distance;

                if (d[graph.get(now).get(i).index] > cost) {
                    d[graph.get(now).get(i).index] = cost;
                    pq.offer(new Node(graph.get(now).get(i).index, cost));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {

        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node node) {
            return this.distance = node.distance;
        }
    }

}

