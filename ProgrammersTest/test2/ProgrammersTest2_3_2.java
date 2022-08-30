package ProgrammersTest.test2;

import java.util.*;

class ProgrammersTest2_3_2 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static Queue<Integer> queue = new LinkedList<>();
    static int[] d;
    static boolean[] visited;

    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(3, new int[][]{{1, 2}, {2, 3}}, new int[]{2, 3}, 1))); // [1, 2]

    }
    
    public static int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];

        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());

        d = new int[n+1];
        visited = new boolean[n+1];
        Arrays.fill(d, (int)1e9);

        for(int i=0; i<roads.length; i++) {
            graph.get(roads[i][0]).add(roads[i][1]);
            graph.get(roads[i][1]).add(roads[i][0]);
        }

        d[destination] = 0;
        BFS(destination);

        for(int i=0; i<sources.length; i++) {
            answer[i] = d[sources[i]] == (int)1e9 ? -1 : d[sources[i]];
        }

        System.out.println(Arrays.toString(d));

        return answer;
    }

    public static void BFS(int destination) {
        queue.offer(destination);
        
        while(!queue.isEmpty()) {
            int distance = 0;
            int size = queue.size();

            for(int i=0; i<size; i++) {
                int start = queue.poll();
                if (visited[start]) break;
                visited[start] = true;

                for (int now : graph.get(start)) {
                    if (distance + 1 < d[now]) {
                        d[now] = distance + 1;
                        queue.offer(now);
                    }
                }
            }
            
            distance++;
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

