import java.util.*;
import java.io.*;

public class Main38_11660 {
    static int N, M;
    static int[][] board;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N+1][N+1];

        for(int i=1; i<=N; i++) {
            // Arrays.fill(board[i], 1);
            st = new StringTokenizer(br.readLine(), " ");
            int j=1;
            while(st.hasMoreTokens()) {
                board[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if (i == 1 && j != 1) { // 1행
                    board[1][j] = board[1][j-1] + board[1][j];
                } else if (i != 1 && j == 1) { // 1열
                    board[i][1] = board[i-1][1] + board[i][1];
                } else if (i != 1 && j != 1) { // 사이 값
                    board[i][j] = board[i-1][j] + board[i][j-1] + board[i][j] - board[i-1][j-1];
                }
            }
        }

        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            sb.append((board[x2][y2] - board[x1-1][y2] - board[x2][y1-1] + board[x1-1][y1-1]) + "\n");
        }

        System.out.println(sb);

    }

}