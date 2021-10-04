import java.util.*;


class Mian23_1 {
    public static int N, M, V, x, y;
    public static String result;
    public static int[][] map;
    public static boolean[] visited;
    public static Queue<Integer> queue = new LinkedList<>();


    public static void main(String[] args) {

        // 백준 온라인 저지 DFS/BFS(23)의 1번
        
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt(); // 정점의 개수
        M = scanner.nextInt(); // 간선의 개수
        V = scanner.nextInt(); // 시작 정점

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
        queue.offer(V);
        visited[V] = true;
        System.out.print(V + " ");
        
        while(!queue.isEmpty()) {
            int temp = queue.poll();

            for(int j=1; j<=N; j++) {
                if (map[temp][j] == 1 && visited[j] == false) {
                    visited[j] = true;
                    queue.offer(j);
                    System.out.print(j + " ");
                }
            }
        }

    }

}