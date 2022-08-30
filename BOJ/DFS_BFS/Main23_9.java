import java.util.*;
import java.io.*;

public class Main23_9 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M, result=-1;
    static int[][] board;
    static boolean[][][] visited;
    static Queue<Position> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M][2]; // (x, y) ��ǥ�� �μ� �������� �ƴ���

        for(int i=0; i<N; i++) {
            String[] str = br.readLine().split("");
            for(int j=0; j<M; j++) {
                board[i][j] = Integer.parseInt(str[j]);
            }
        }

        if (N == 1 && M == 1) {
            System.out.println("1");
            return;
        }

        BFS(0, 0);

        System.out.println(result);
    }

    public static void BFS(int row, int column) {
        queue.offer(new Position(row, column, 1, 0));
        visited[row][column][0] = true;
        // visited[x][y][0] : (x, y) ��ǥ�� ���� ���� �μ��� ���� ä �湮��
        // visited[x][y][1] : (x, y) ��ǥ�� ���� �μ� ä �湮��

        while(!queue.isEmpty()) {
            Position p = queue.poll();
            int x = p.x;
            int y = p.y;

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >=M ) continue;

                if (visited[nx][ny][p.isBreak]) continue; // �̹� �湮�ߴ� ���̶�� Ž�� �ߴ�

                if (nx == N-1 && ny == M-1) {
                    result = p.count + 1;
                    return;
                }

                if (board[nx][ny] == 0) {
                    visited[nx][ny][p.isBreak] = true;
                    queue.offer(new Position(nx, ny, p.count+1, p.isBreak));
                } else {
                    if (p.isBreak == 0) { // ���� �������� ���� �ѹ��� ���� �μ����� ���ٸ�
                        if (visited[nx][ny][1]) continue; // �̹� �湮�ߴ� ���̶�� Ž�� �ߴ�

                        visited[nx][ny][1] = true;
                        queue.offer(new Position(nx, ny, p.count+1, 1));
                    }
                }

            }

        }


    }

    static class Position {

        int x;
        int y;
        int count;
        int isBreak;

        public Position(int x, int y, int count, int isBreak) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.isBreak = isBreak;
        }

    }

}

