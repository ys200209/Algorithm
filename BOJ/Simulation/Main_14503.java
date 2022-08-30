import java.util.*;
import java.io.*;

public class Main_14503 {
    static int[] dx = {-1, 0, 1, 0}; // ��, ��, ��, ��
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
            clean(); // ���� ��ġ�� û���Ѵ�.
            
            if (search()) { // û���� ���� ã�� ���ߴٸ�
                int x = rb.x;
                int y = rb.y;
                int d = rb.d;

                int nx = x + dx[(d+2)%4];
                int ny = y + dy[(d+2)%4]; // �� �� ��ǥ

                if (board[nx][ny] == 1) break; // �ٷ� �� ���� ���̶�� �۵��� �����.
                else { // �׷��� �ʴٸ� �� ĭ �����Ѵ�.
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

            if (!visited[nx][ny] && board[nx][ny] == 0) { // ���� û������ ���� �� ����
                rb.d = d; // ȸ���� ��
                rb.x = nx; // �� ĭ ����
                rb.y = ny;
                return false;
            }
        }

        return true;
    }

    static class Robot {

        int x;
        int y;
        int d;

        public Robot(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }

    }

}

