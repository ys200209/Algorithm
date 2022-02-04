import java.util.*;
import java.io.*;

public class Main15_1890 {
    static int N;
    static long[][] map, dp;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new long[N+1][N+1];
        dp = new long[N+1][N+1];

        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int j=1;
            while(st.hasMoreTokens()) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
                j++;
            }
        }

        /*for(int i=0; i<=N; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }*/

        System.out.println(DFS(1, 1));

    }

    public static long DFS(int x, int y) {
        if (x == N && y == N) return 1;

        if (dp[x][y] != -1) return dp[x][y];

        dp[x][y] = 0;
        for(int i=0; i<2; i++) {
            int nx = x + (dx[i] * (int) map[x][y]);
            int ny = y + (dy[i] * (int) map[x][y]);

            if (nx < 1 || nx > N || ny < 1 || ny > N) continue;
            
            dp[x][y] += DFS(nx, ny);

        }

        return dp[x][y];
    }

}