import java.util.*;
import java.io.*;

public class Main_14503 {
    static int[] dx = {-1, 0, 1, 0}; // 북, 동, 남, 서 (시계방향)
    static int[] dy = {0, 1, 0, -1};
    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static int count=0;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];

        st = new StringTokenizer(br.readLine(), " ");
        Robot robot = new Robot(
            Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())
        );

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j=0;
            while(st.hasMoreTokens()) {
                board[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

        DFS(robot);

        System.out.println("--------------------");

        for(int i=0; i<N; i++) {
            System.out.println(Arrays.toString(board[i]));
        }

        System.out.println(count);
    }

    public static void DFS (Robot robot) {

        // System.out.println("(" + robot.x + ", " + robot.y + ") : " + robot.d);

        int x = robot.x;
        int y = robot.y;
        int d = robot.d;

        visited[x][y] = true;
        count++;
        board[x][y] = count;

        for(int i=1; i<= 4; i++) {
            int nd = (d - i + 4) % 4;
            int nx = x + dx[nd];
            int ny = y + dy[nd];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

            if (!visited[nx][ny] && board[nx][ny] == 0) {
                DFS(new Robot(nx, ny, nd));
            }
        }

        // int nd = (d + 2) % 4;
        // int nx = x + dx[nd];
        // int ny = y + dy[nd];
        // if (board[nx][ny] == 0) {
        //     DFS(new Robot(nx, ny, d));
        // }

    }

}

class Robot {

    int x;
    int y;
    int d;

    public Robot(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }

}