import java.util.*;

class Main23_2 {
    public static int N, M, x, y;
    public static int[][] map;
    public static boolean[] visited;
    public static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) {

        // 백준 온라인 저지 DFS/BFS(23)의 2번

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        map = new int[101][101];
        visited = new boolean[101];

        for(int i=0; i<M; i++) {
            x = scanner.nextInt();
            y = scanner.nextInt();

            map[x][y] = 1;
            map[y][x] = 1;
        }

        DFS(1);

        System.out.println(result.size());

    }

    public static void DFS(int i) {
        visited[i] = true;

        for(int j=1; j<=N; j++) {
            if (map[i][j] == 1 && visited[j] == false) {
                result.add(j);
                DFS(j);
            }
        }
    }
    
}
