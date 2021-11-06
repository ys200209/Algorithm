package DFS_BFS;

import java.util.*;

public class Main2 {
    public static int answer;
    public static boolean[] visited;
    public static int N;
    public static int[][] map;

    public static void main(String[] args) {
        // 네트워크
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}})); // 2
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}})); // 1

    }

    public static int solution(int n, int[][] computers) {
        map = computers;
        answer = 0;
        visited = new boolean[n];
        N = n;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if (map[i][j] == 1 && visited[i] == false) {
                    BFS(i);
                    answer++;
                }
            }
        }

        return answer;
    }
    
    public static void BFS(int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visited[i] = true;

        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(int j=0; j<N; j++) {
                if (map[node][j] == 1 && visited[j] == false) {
                    queue.offer(j);
                    visited[j] = true;
                }
            }
        }

    }
    
}
