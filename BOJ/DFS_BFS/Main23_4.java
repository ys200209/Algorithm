import java.util.*;

class Main23_4 {
    public static int T, M, N, K, X, Y, result=0;
    public static int[][] map;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) {

        // 백준 온라인 저지 DFS/BFS(23)의 4번

        Scanner scanner = new Scanner(System.in);

        T = scanner.nextInt();

        while(T > 0) {
            M = scanner.nextInt();
            N = scanner.nextInt();
            K = scanner.nextInt(); // 배추의 위치
            map = new int[M][N];
            result = 0;

            for(int i=0; i<K; i++) {
                X = scanner.nextInt();
                Y = scanner.nextInt();
                map[X][Y] = 1;
            }

            for(int i=0; i<M; i++) {
                for(int j=0; j<N; j++) {
                    if (DFS(i, j)) {
                        result += 1;
                    }
                }
            }
            sb.append(result + "\n");
            T--;
        }

        System.out.println(sb);
    }

    public static boolean DFS(int x, int y) {
        if (x < 0 || y < 0 || x >= M || y >= N) {
            return false;
        }

        if (map[x][y] == 1) {
            map[x][y] = 0;
            DFS(x-1, y);
            DFS(x+1, y);
            DFS(x, y-1);
            DFS(x, y+1);
            return true;
        }

        return false;
    }
}
