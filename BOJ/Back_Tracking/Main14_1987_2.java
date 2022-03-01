import java.util.*;
import java.io.*;

public class Main14_1987_2 {
    static String str = "";
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int R, C, result=0;
    static String[][] board;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new String[R][C];

        for(int i=0; i<R; i++) {
            board[i] = br.readLine().split("");
        }

        DFS(0, 0);

        System.out.println(result);
    }

    public static void DFS(int x, int y) {
        str += board[x][y];

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;

            if (str.contains(board[nx][ny])) continue;

            DFS(nx, ny);

        }

        result = Math.max(result, str.length());

        str = str.substring(0, str.length()-1);
    }
}