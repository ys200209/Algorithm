package BOJ.Brute_Force;

import java.util.*;
import java.io.*;

public class Main11_9663 {
    static int N, result=0;
    static Queen[][] board;
    static List<Queen> list = new ArrayList<>();
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new Queen[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                board[i][j] = new Queen(i, j);
            }
        }

        DFS(0);

        System.out.println(result);

    }

    private static void DFS(int count) {
        if (count == N) {
            result++;
//            print();
            return;
        }

        for(int i=count; i<count+1; i++) {
            for(int j=0; j<N; j++) {
                if (!visited[i][j]) {
                    if (checkQueen(i, j)) {
                        visited[i][j] = true;
                        list.add(board[i][j]);
                        DFS(count+1);
                        list.remove(board[i][j]);
                        visited[i][j] = false;
                    }
                }
            }
        }
    }

    private static boolean checkQueen(int row, int column) {

        for (Queen queen : list) {
            int x = queen.x;
            int y = queen.y;

            int xDiff = Math.abs(row - x);
            int yDiff = Math.abs(column - y);

            if (xDiff == 0 || yDiff == 0 || xDiff == yDiff) {
                return false;
            }
        }

        return true;
    }

    static class Queen {
        int x;
        int y;

        public Queen(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}