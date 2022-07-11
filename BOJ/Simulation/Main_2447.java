import java.util.*;
import java.io.*;

public class Main_2447 {
    static int N;
    static String[][] board;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new String[N][N];
        for(int i=0; i<N; i++) {
            Arrays.fill(board[i], " ");
        }

        recursive(0, 0, N, false);

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void recursive(int x, int y, int step, boolean isMid) {
        if (step == 1) {
            board[x][y] = "*";
            return;
        }

        step /= 3;
        for(int i=0; i<step*3; i+=step) {
            for(int j=0; j<step*3; j+=step) {

                if (i == step && j == step) continue;

                recursive(x+i, y+j, step, isMid);
            }
        }
    }

}
