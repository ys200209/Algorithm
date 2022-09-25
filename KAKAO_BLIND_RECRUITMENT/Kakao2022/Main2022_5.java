
import java.util.*;
import java.io.*;

public class Main2022_5 {
    static int N, MAX=0;
    static int[] infos;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static Queue<Node> pq = new PriorityQueue<>();
    
    public static void main(String[] args) throws IOException {
        
        //System.out.println(solution(new int[]{0,0,1,1,1,0,1,0,1,0,1,1}, 
        //new int[][]{{0,1}, {1,2}, {1,4}, {0,8}, {8,7}, {9,10}, {9,11}, {4,3}, {6,5}, {4,6}, {8,9}})); // 5

        System.out.println(solution(new int[]{0,1,0,1,1,0,1,0,0,1,0}, 
        new int[][]{{0,1}, {0,2}, {1,3}, {1,4}, {2,5}, {2,6}, {3,7}, {4,8}, {6,9}, {9,10}})); // 5

    }

    public static int solution(int[] info, int[][] edges) {
        N = info.length;

        for(int i=0; i<info.length; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++) {
            int A = edges[i][0];
            int B = edges[i][1];

            graph.get(A).add(B);
            graph.get(B).add(A);
        }

        boolean[] v = new boolean[N];
        v[0] = true;
        int[] infos = new int[info.length];
        int i=0;
        for(int n : info) {
            infos[i] = n;
            i++;
        }
        infos[0] = -1;
        pq.offer(new Node(0, 1, 0, v, infos));

        BFS(0);

        return MAX;
    }

    public static void BFS(int start) {
        

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.now;
            boolean[] visited = node.visited;

            if (node.sheep <= node.wolf) continue;

            MAX = Math.max(MAX, node.sheep);

            for(int n : graph.get(now)) {
                if (!visited[n]) {
                    int[] info = setInfo(node.info);
                    if (node.info[n] == 0) {
                        info[n] = -1;
                        pq.offer(new Node(n, node.sheep+1, node.wolf, new boolean[N], info));
                    } else if (node.info[n] == 1) {
                        info[n] = -1;
                        pq.offer(new Node(n, node.sheep, node.wolf+1, new boolean[N], info));
                    } else {
                        visited[n] = true;
                        pq.offer(new Node(n, node.sheep, node.wolf, visited, info));
                    }
                }
            }
        }

    }

    public static int[] setInfo(int[] inf) {
        int[] info = new int[inf.length];
        for(int i=0; i<inf.length; i++) {
            info[i] = inf[i];
        }
        return info;
    }

    static class Node implements Comparable<Node> {

        int now;
        int sheep;
        int wolf;
        boolean[] visited;
        int[] info;

        public Node(int now, int sheep, int wolf, boolean[] visited, int[] info) {
            this.now = now;
            this.sheep = sheep;
            this.wolf = wolf;
            this.visited = visited;
            this.info = info;
        }

        @Override
        public int compareTo(Node node) {
            return node.sheep - this.sheep;
        }

    }
}

