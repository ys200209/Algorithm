import java.util.*;
import java.io.*;

public class Main15_1520 {
    static int N, M;
    static int[][] map, dp;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        dp = new int[N+1][M+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j=1;
            while(st.hasMoreTokens()) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
                j++;
            }
        }

        System.out.println(DFS(1, 1));
        
    }

    public static int DFS(int row, int column) {
        if (row == N && column == M) return 1;

        if (dp[row][column] != -1) return dp[row][column];

        dp[row][column] = 0;
        for(int i=0; i<4; i++) {
            int nx = row + dx[i];
            int ny = column + dy[i];

            if (nx < 1 || nx > N || ny < 1 || ny > M) continue;
            
            if (map[row][column] > map[nx][ny]) {
                dp[row][column] += DFS(nx, ny);
            }
        }

        return dp[row][column];
    }
    
}

/*
4 5
50 45 37 32 30
35 50 40 20 25
30 30 25 17 28
27 24 22 15 10
= 3
*/