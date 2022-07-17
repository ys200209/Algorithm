import java.util.*;
import java.io.*;

public class Main_9663 {
    static int[] dx = {-1, -1, 1, 1};
    static int[] dy = {-1, 1, -1, 1};
    static int N, result=0;
    static int[][] board;
    static boolean[] row, column, diagonal1, diagonal2;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        row = new boolean[N];
        column = new boolean[N];
        diagonal1 = new boolean[N*2];
        diagonal2 = new boolean[N*2];

        DFS(0, 0);

        

        System.out.println("result : " + result);
    }

    public static void DFS(int index, int count) {
        if (count == N) {
            result++;
            // System.out.println("--------------------------");
            // for(int i=0; i<N; i++) {
            //     System.out.println(Arrays.toString(board[i]));
            // }
            // System.out.println("--------------------------");
            return;
        }

        // for(int i=index1; i<N; i++) {
        //     for(int j=index2; j<N; j++) {
        //         if (!row[i] && !column[j]) {
        //             if (j-i < 0) {
        //                 if (!diagonal2[j+(N-i)]) {
        //                     row[i] = true;
        //                     column[j] = true;
        //                     diagonal2[j+(N-i)] = true;
        //                     DFS(i, count+1);
        //                     diagonal2[j+(N-i)] = false;
        //                     column[j] = false;
        //                     row[i] = false;
        //                 }
        //             } else {
        //                 if (!diagonal1[j-i]) {
        //                     row[i] = true;
        //                     column[j] = true;
        //                     diagonal1[j-i] = true;
        //                     DFS(i, count+1);
        //                     diagonal1[j-i] = false;
        //                     column[j] = false;
        //                     row[i] = false;
        //                 }
                        
        //             }
        //         }
        //     }
        // }

        for(int i=index; i<N; i++) {
            if (row[i]) continue;

            for(int j=0; j<N; j++) {
                if (column[j]) continue;

                if (checkDiagonal(i, j)) {
                    row[i] = true;
                    column[j] = true;
                    board[i][j] = -1;
                    DFS(i, count+1);
                    board[i][j] = 0;
                    column[j] = false;
                    row[i] = false;
                }
            }
        }

    }

    public static boolean checkDiagonal(int x, int y) {
        for(int i=0; i<4; i++) {
            int nx = x;
            int ny = y;

            while(true) {
                nx += dx[i];
                ny += dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) break;

                if (board[nx][ny] == -1) return false;
            }
        }

        return true;
    }

}
