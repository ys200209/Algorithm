package BOJ.Back_Tracking;

import java.util.*;
import java.io.*;

public class Main14_12100 {
    static int[] dx = {1, 0, -1, 0}; // ��, ��, ��, ��
    static int[] dy = {0, 1, 0, -1};
    static int N, max=0;
    static Queue<Game> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j=0;
            while(st.hasMoreTokens()) {
                board[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, board[i][j]);
                j++;
            }
        }

        queue.offer(new Game(board, 0, max));
        BFS();
    }

    public static void BFS() {

        while(!queue.isEmpty()) {
            Game game = queue.poll();

            for(int i=0; i<4; i++) {
                if (i == 0) Up();
                else if (i == 1) Right();
                else if (i == 2) Down();
                else Left();
            }

        }

    }

    private static void Left() {
    }

    private static void Down() {

    }

    private static void Right() {

    }

    public static void Up() {
        
    }

    static class Game {

        int[][] board;
        int moveCount;
        int max;

        public Game(int[][] board, int moveCount, int max) {
            this.board = board;
            this.moveCount = moveCount;
            this.max = max;
        }
    }

}

