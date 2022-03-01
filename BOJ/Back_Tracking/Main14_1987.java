import java.util.*;
import java.io.*;

public class Main14_1987 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int R, C, result=0;
    static String[][] board;
    static Queue<Move> queue = new PriorityQueue<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new String[R][C];

        for(int i=0; i<R; i++) {
            board[i] = br.readLine().split("");
        }

        BFS(0, 0);

        System.out.println(result);
    }

    public static void BFS(int row, int column) {
        queue.offer(new Move(row, column, board[row][column]));

        while(!queue.isEmpty()) {
            Move move = queue.poll();
            int x = move.x;
            int y = move.y;
            result = Math.max(result, move.str.length());

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;

                if (move.str.contains(board[nx][ny])) continue;

                queue.offer(new Move(nx, ny, move.str + board[nx][ny]));
            }
        }
    }
}

class Move implements Comparable<Move> {

    int x;
    int y;
    String str;

    public Move(int x, int y, String str) {
        this.x = x;
        this.y = y;
        this.str = str;
    }

    @Override
    public int compareTo(Move move) {
        return move.str.length() - this.str.length();
    }

}