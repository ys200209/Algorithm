package DFS_BFS;

import java.util.*;

public class Main1 {
    public static int N, M, V, x, y;
    public static int[][] map;
    public static boolean[] visited;


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();
        V = scanner.nextInt();

        map = new int[1001][1001];
        visited = new boolean[1001];

        for(int i=0; i<M; i++) {
            x = scanner.nextInt();
            y = scanner.nextInt();
            map[x][y] = 1;
            map[y][x] = 1;
        }

        DFS(V);

        visited = new boolean[1001];
        System.out.println();

        BFS();

    }

    public static void DFS(int i) {
        visited[i] = true;
        System.out.print(i + " ");

        for(int j=1; j<=N; j++) {
            if (map[i][j] == 1 && visited[j] == false) {
                DFS(j);
            }
        }
    }

    public static void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(V);
        visited[V] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();
            System.out.print(node + " ");

            for(int j=1; j<=N; j++) {
                if (map[node][j] == 1 && visited[j] == false) {
                    queue.offer(j);
                    visited[j] = true;
                }
            }

        }

    }

}
