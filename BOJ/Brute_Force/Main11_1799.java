package BOJ.Brute_Force;

import java.io.*;
import java.util.*;

public class Main11_1799 {
    static int[] dx = {-1, -1, 1, 1};
    static int[] dy = {-1, 1, -1, 1};
    static int N, result=0;
    static Bishop[][] board;
    static List<Bishop> bishopList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        board = new Bishop[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j=0;
            while(st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num == 1 ? new Bishop(i, j) : null;
                j++;
            }
        }

        DFS(0, 0, 0);

        System.out.println(result);
    }

    private static void DFS(int row, int column, int count) {
        result = Math.max(result, count);

        for(int i=row; i<N; i++) {
            for(int j= i==row ? column : 0; j<N; j++) {
                if (board[i][j] != null && checkBishop(board[i][j])) {

                    bishopList.add(board[i][j]);
                    DFS(i, j+1, count+1);
                    bishopList.remove(board[i][j]);
                }
            }
        }
    }

    private static boolean checkBishop(Bishop bishop) {
        int x = bishop.x;
        int y = bishop.y;

        for (Bishop bs : bishopList) {
            if (Math.abs(bs.x - x) == Math.abs(bs.y - y)) return false;
        }

        return true;
    }

    static class Bishop {
        int x;
        int y;

        public Bishop(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}