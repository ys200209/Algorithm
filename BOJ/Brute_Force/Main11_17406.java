package BOJ.Brute_Force;

import java.io.*;
import java.util.*;

public class Main11_17406 {
    static int N, M, K, MIN=(int)1e9;
    static int[][] board;
    static List<Rotate> rotateList = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[N+1][M+1];
        visited = new boolean[K];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j=1;
            while(st.hasMoreTokens()) {
                board[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

        for(int i=1; i<=K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            rotateList.add(new Rotate(x, y, r));
        }

        DFS(board, 0);

        System.out.println(MIN);
    }

    private static void DFS(int[][] board, int count) {
        if (count == K) {
            MIN = Math.min(MIN, getScore(board));
//            print(board);
            return;
        }

//        int[][] tempBoard = copyArray(board);
//        print(board);

        for(int i=0; i<K; i++) {
            if (!visited[i]) {
                visited[i] = true;
//                print(board);
//                int[][] tempBoard = rotate(board, rotateList.get(i));
//                print(tempBoard);
//                print(board);
//                System.out.println("count : " + count + ", i : " + i);
                DFS(rotate(board, rotateList.get(i)), count+1);
                visited[i] = false;
//                System.out.println();
//                print(rotate(board, rotateList.get(i)));
//                return;
            }
        }

    }

    private static int getScore(int[][] board) {
        int minScore = (int)1e9;
        int score=0;

        for(int i=1; i<=N; i++) {
            score = 0;
            for(int j=1; j<=M; j++) {
                score += board[i][j];
            }
            minScore = Math.min(minScore, score);
        }

        return minScore;
    }

    private static void print(int[][] rotate) {
        for(int i=1; i<=N; i++) {
            System.out.println();
            for(int j=1; j<=M; j++) {
                System.out.print(rotate[i][j] + " ");
            }
        }
        System.out.println();
    }

    private static int[][] rotate(int[][] board, Rotate rotate) {
//        System.out.println("rotate");
        int[][] tempBoard = new int[N+1][M+1];

        int x1 = rotate.x - rotate.r;
        int x2 = rotate.x + rotate.r;
        int y1 = rotate.y - rotate.r;
        int y2 = rotate.y + rotate.r;

        for(int r=0; r<rotate.r; r++) {
            for(int i=0; i<(x2-r)-(x1+r); i++) {
                tempBoard[x1+i+r][y1+r] = board[x1+i+r+1][y1+r];
                tempBoard[x1+i+r+1][y2-r] = board[x1+i+r][y2-r];
//                System.out.println();
            }
        }

        for(int r=0; r<rotate.r; r++) {
            for(int i=0; i<(y2-r)-(y1+r); i++) {
                tempBoard[x1+r][y2-i-r] = board[x1+r][y2-i-r-1];
                tempBoard[x2-r][y2-i-r-1] = board[x2-r][y2-i-r];
            }
        }

//        if (tempBoard[rotate.x][rotate.y] == 0) tempBoard[rotate.x][rotate.y] = board[rotate.x][rotate.y]; // 중앙값 복사

        for(int i=1; i<=N; i++) { // 빈 공간 채우기
            for(int j=1; j<=M; j++) {
                if (tempBoard[i][j] == 0) tempBoard[i][j] = board[i][j];
            }
        }

        return tempBoard;
    }

    static class Rotate {
        int x;
        int y;
        int r;

        public Rotate(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }

}