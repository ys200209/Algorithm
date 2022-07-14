import java.util.*;
import java.io.*;

public class Main_14503 {
    static int[] dx = {-1, 0, 1, 0}; // 북, 동, 남, 서
    static int[] dy = {0, 1, 0, -1};
    static int N, M, result=0;
    static int[][] board;
    static Robot rb;
    static boolean[][] visited;
    static boolean isBreak = false;
    
    public static void main(String[] args) throws IOException {

        init();

        logic();

        System.out.println(result);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];

        st = new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        rb = new Robot(R, C, D);

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j=0;
            while(st.hasMoreTokens()) {
                board[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }
    }

    public static void logic() {
        while(true) {
            clean(); // 현재 위치를 청소한다.
            
            if (search()) { // 청소할 곳을 찾지 못했다면
                int x = rb.x;
                int y = rb.y;
                int d = rb.d;

                int nx = x + dx[(d+2)%4];
                int ny = y + dy[(d+2)%4]; // 뒤 쪽 좌표

                if (board[nx][ny] == 1) break; // 바로 뒤 쪽이 벽이라면 작동을 멈춘다.
                else { // 그렇지 않다면 한 칸 후진한다.
                    rb.x = nx;
                    rb.y = ny;
                }
            }
        }
    }

    public static void clean() {
        if (!visited[rb.x][rb.y]) {
            visited[rb.x][rb.y] = true;
            result++;
        }
    }

    public static boolean search() {
        int x = rb.x;
        int y = rb.y;
        int d = rb.d;
        for(int i=0; i<4; i++) {
            d = (d - 1 + 4) % 4;
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

            if (!visited[nx][ny] && board[nx][ny] == 0) { // 아직 청소하지 않은 빈 공간
                rb.d = d; // 회전한 후
                rb.x = nx; // 한 칸 전진
                rb.y = ny;
                return false;
            }
        }

        return true;
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