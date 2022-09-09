package BOJ.Back_Tracking;

import java.io.*;
import java.util.*;

public class Main14_17086 {
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int N, M, result=0;
    static int[][] board;
    static boolean[][] visited = new boolean[N][M];
    static Queue<Position> pq = new PriorityQueue<>();
    static List<Position> sharks = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j = 0;
            while (st.hasMoreTokens()) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) sharks.add(new Position(i, j));
                j++;
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if (board[i][j] == 0) {
                    int min = (int)1e9;
                    for (Position shark : sharks) {
                        int row = Math.abs(shark.x - i);
                        int column = Math.abs(shark.y - j);

                        int m1 = Math.max(row, column);
                        int m2 = Math.min(row, column);
                        min = Math.min(min, m1 - m2);
                    }
                    System.out.println("min = " + min);
                    result = Math.max(result, min);
                }
            }
        }
        System.out.println("result = " + result);
    }

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}