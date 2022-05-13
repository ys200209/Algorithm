import java.util.*;

class MainBlind2021_4 {
    static int INF = (int)1e9;
    static int minIndex=0, minCost=(int)1e9;
    static int[] d;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static Queue<Node> pq;

    public static void main(String[] args) {

        System.out.println(solution(6, 4, 6, 2, 
        new int[][]{{4,1,10}, {3,5,24}, {5,6,2}, {3,1,41}, {5,1,24}, {4,6,50}, {2,4,66}, {2,3,22}, {1,6,25}}));
        // 82

    }
    
    public static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = (int)1e9;

        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        d = new int[n+1];
        
        for(int i=0; i<fares.length; i++) {
            int A = fares[i][0];
            int B = fares[i][1];
            int C = fares[i][2];

            graph.get(A).add(new Node(B, C));
            graph.get(B).add(new Node(A, C));
        }
        

        // 각자 타고가는 경우
        dijkstra(s); // s에서부터 모든 노드까지의 최단거리를 담음
        answer = d[a] + d[b]; // s에서 a로, b로의 거리를 구함

        System.out.println("d : " + Arrays.toString(d));
        System.out.println("minIdx : " + minIndex + ", minCost : " + minCost);

        // 같이 타는 경우
        int t = (int)1e9;
        for(int i=1; i<=n; i++) {
            if (i == s) continue; // 제자리 이동금지
            
            dijkstra(s); 
            int min = d[i]; // s에서 i까지 같이 가고

            if (min >= t) continue; // 최소비용 이상이면 중단

            dijkstra(i);
            min += (d[a] + d[b]); // i에서 각자 집으로 가는 것
            
            if (min < 0) continue; // 비용이 음수가 나오면 안됨
            
            t = Math.min(t, min);
        }


        return Math.min(answer, t);
    }

    public static void dijkstra(int start) {
        pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        Arrays.fill(d, INF);
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