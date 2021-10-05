import java.util.*;

class Main23_3 {
    public static int N, M, result = 0;
    public static String str;
    public static int[][] map;

    public static void main(String[] args) {
        
        // 백준 온라인 저지 DFS/BFS(23)의 3번

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        map = new int[N][M];

        for(int i=0; i<N; i++) {
            str = scanner.next();
            for(int j=0; j<M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(DFS(i, j)) {
                    result += 1;
                }
            }
        }

        System.out.println(result);

    }

    public static boolean DFS(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y>= M) {
            return false;
        }

        if (map[x][y] == 0) {
            map[x][y] = 1;
            DFS(x-1, y);
            DFS(x+1, y);
            DFS(x, y-1);
            DFS(x, y+1);
            return true;
        }

        return false;
    }

}
