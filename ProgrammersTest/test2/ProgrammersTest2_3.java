package ProgrammersTest.test2;

import java.util.*;

class ProgrammersTest2_3 {
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static Queue<Node> pq = new PriorityQueue<>();
    static int[] d;
     static boolean[] visited;

    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(3, new int[][]{{1, 2}, {2, 3}}, new int[]{2, 3}, 1))); // [1, 2]

    }
    
    public static int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];

        d = new int[n+1];
        // visited = new boolean[n+1];

        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<roads.length; i++) {
            int start = roads[i][0];
            int end = roads[i][1];

            graph.get(start).add(new Node(end, 1));
            graph.get(end).add(new Node(start, 1));
        }

        dijkstra(destination);

        for(int i=0; i<sources.length; i++) {
            answer[i] = d[sources[i]] == (int)1e9 ? -1 : d[sources[i]];
        }

        return answer;
    }

    public static void dijkstra(int start) {
        Arrays.fill(d, (int)1e9);
        d[start] = 0;
        pq.offer(new Node(start, 0));
        // visited[start] = true;

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int index = node.index;
            int dis = node.distance;

            if (visited[index]) continue;
            visited[index] = true;

            if (d[index] < dis) continue;

            for(int i=0; i<graph.get(index).size(); i++) {
                int cost = d[index] + graph.get(index).get(i).distance;

                if (d[graph.get(index).get(i).index] > cost) {
                    d[graph.get(index).get(i).index] = cost;
                    pq.offer(new Node(graph.get(index).get(i).index, cost));
                }
            }
            
        }

        // System.out.println(start + " - " + end + " : " + Arrays.toString(d));
        // return d[end] == (int)1e9 ? -1 : d[end];
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

