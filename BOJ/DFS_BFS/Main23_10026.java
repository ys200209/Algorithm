import java.util.*;
import java.io.*;

public class Main23_10026 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N, des=0, notDes=0;
    static String[][] board;
    static StringBuilder sb = new StringBuilder();
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new String[N][N];
        
        for(int i=0; i<N; i++) {
            board[i] = br.readLine().split("");
        }

        visited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if (!visited[i][j]) {
                    See(i, j, board[i][j], false);
                    notDes++;
                }
            }
        }

        visited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if (!visited[i][j]) {
                    See(i, j, board[i][j], true);
                    des++;
                }
            }
        }

        System.out.println(notDes + " " + des);
    }

    public static void See(int x, int y, String color, boolean isDesease) {
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

            if (visited[nx][ny]) continue;

            if (isDesease) { // 적록색약이 존재한다면
                if (color.equals("R") || color.equals("G")) { // 지금 본 색깔이 빨강 또는 초록이라면
                    if (board[nx][ny].equals("R") || board[nx][ny].equals("G")) { // 빨강 초록을 구별하지 않음
                        See(nx, ny, color, isDesease);
                    }
                } else {
                    if (board[nx][ny].equals(color)) { // 현재 봤던 색깔만 구별할 수 있음
                        See(nx, ny, color, isDesease);
                    }
                }
            } else { // 적록색약이 없다면
                if (board[nx][ny].equals(color)) { // 현재 봤던 색깔만 구별할 수 있음
                    See(nx, ny, color, isDesease);
                }
            }
        }
    }
}