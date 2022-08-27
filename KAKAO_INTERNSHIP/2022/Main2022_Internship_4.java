    import java.util.*;

class Main2022_Internship_4 {
    static int INF = (int)1e9, intensity = (int)1e9, summit; // INF : 배열 초기화 값, 최소 등산코스 거리, 산봉우리 값
    static int[] d;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static Queue<Node> pq;

    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(6, new int[][]{{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}},
        new int[]{1, 3}, new int[]{5})));
        // [5, 3]

    }
    
    public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        d = new int[n+1];
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());

        for(int i=0; i<paths.length; i++) {
            int A = paths[i][0]; // from
            int B = paths[i][1]; // to
            int C = paths[i][2]; // distance

            graph.get(A).add(new Node(B, C));
        }

        for(int i=0; i<gates.length; i++) {
            for(int j=0; j<summits.length; j++) {
                int dis = dijkstra(gates[i], summits[j]) + dijkstra(summits[j], gates[i]);
                
                if (intensity > dis) {
                    intensity = dis;
                    summit = summits[j];
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = summit;
        answer[1] = intensity;
        return answer;
    }

    public static int dijkstra(int from, int to) {
        Arrays.fill(d, INF);
        pq = new PriorityQueue<>();
        pq.offer(new Node(from, 0));
        d[from] = 0;

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.index;
            int dis = node.distance;

            if (d[now] < dis) continue; // 현재 위치에 더 짧은 거리로 온 기록이 있다면 다른 노드 재탐색

            for(int i=0; i<graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).distance;

                if (d[graph.get(now).get(i).index] > cost) { // 기존보다 더 최단거리를 발견했다면
                    d[graph.get(now).get(i).index] = cost; // 최단 거리 갱신
                    pq.offer(new Node(graph.get(now).get(i).index, cost));
                }
            }
        }

        // System.out.println("d : " + Arrays.toString(d));

        return d[to]; // start에서 to로의 최단거리값을 리턴.
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

/*
    Q1 : 다익스트라 알고리즘에 대해 말해보라
*/ 