import java.io.*;
import java.util.*;

public class Main23_9 {
    static int N, M, result;
    static int[][] temp;
    static String[][] map;
    static Queue<Move> queue = new LinkedList<>();
 
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();
        map = new String[N][M];
        temp = new int[N][M];

        for(int i=0; i<N; i++) {
            map[i] = scanner.next().split("");
            for(int j=0; j<M; j++) {
                temp[i][j] = 0;
            }
        }

        temp[0][0] = 1;

        if (N == 1 && M == 1) {
            System.out.println("1");
            return;
        }

        queue.offer(new Move(0, 0, 0));

        int result = BFS();

        for(int i=0; i<N; i++) {
            System.out.println(Arrays.toString(temp[i]));
        }

        System.out.println(result);
    }
    
    public static int BFS() {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while(!queue.isEmpty()) {
            Move move = queue.poll();
            int x = move.getX();
            int y = move.getY();

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                // if (temp[nx][ny] >= temp[x][y]) continue;

                if (map[nx][ny].equals("1")) {
                    if (move.getWallBreak() == 1) continue;
                    else {
                        queue.offer(new Move(nx, ny, 1));
                    }
                } else {
                    queue.offer(new Move(nx, ny, move.getWallBreak()));
                }
                temp[nx][ny] = temp[x][y] + 1;

                if (temp[N-1][M-1] != 0) {
                    return temp[N-1][M-1];
                }
            }
        }
        return -1;
    }
}

class Move {

    private int x;
    private int y;
    private int wallBreak;

    public Move(int x, int y, int wallBreak) {
        this.x = x;
        this.y = y;
        this.wallBreak = wallBreak;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWallBreak() {
        return wallBreak;
    }

}