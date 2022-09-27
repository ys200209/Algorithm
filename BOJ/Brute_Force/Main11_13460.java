package BOJ.Brute_Force;

import java.io.*;
import java.util.*;

public class Main11_13460 {
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};
    static int N, M, result=(int)1e9;
    static String[][] board;
    static Queue<Game> pq = new PriorityQueue<>();
//    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new String[N][M];
//        visited = new boolean[N][M];

        RED red = null;
        BLUE blue = null;

        for(int i=0; i<N; i++) {
            board[i] = br.readLine().split("");

            for(int j=0; j<M; j++) {
                if (board[i][j].equals("R")) {
                    red = new RED(i, j, false);
                    board[i][j] = ".";
                } else if (board[i][j].equals("B")) {
                    blue = new BLUE(i, j, false);
                    board[i][j] = ".";
                }
            }
        }

        /*


6 7
#######
####B##
#...#O#
#.R.###
#...###
#######

7 7
#######
#..B#R#
#.#####
#.....#
#####.#
#O....#
#######

3 5
#####
#ORB#
#####


        */

//        visited[red.x][red.y] = true;
        Game game = new Game(red, blue, 0);
        pq.offer(game);
//        System.out.println("------------Basic------------");
//        PRINT(game);

        BFS();

        System.out.println(result == (int)1e9 || result > 10 ? -1 : result);
    }

    private static void BFS() {
        while(!pq.isEmpty()) {
            Game game = pq.poll();

            for(int i=0; i<4; i++) {
                Game copyGame = copyGame(game);
                Ball red = copyGame.red;
                Ball blue = copyGame.blue;
                int rx = red.x;
                int ry = red.y;
                int bx = blue.x;
                int by = blue.y;

//                System.out.println("(" + rx + ", " + ry + "), (" + bx + ", " + by + ")");

                if ((i == 0 && rx <= bx) || (i == 1 && rx > bx) || (i == 2 && ry <= by) || (i == 3 && ry > by)) {
                    move(i, red, blue);
                    move(i, blue, red);
                } else {
                    move(i, blue, red);
                    move(i, red, blue);
                }
//                System.out.println("i = " + i);
//                System.out.println("game.count = " + (game.count+1));
//                PRINT(copyGame);

                if (red.isGoal || blue.isGoal) {
                    if (blue.isGoal) continue;
                    else {
                        result = copyGame.count+1;
                        return;
                    }
                }

                /*if (red.isGoal && !blue.isGoal) {
                    result = copyGame.count+1;
                    return;
                } else if (red.isGoal && blue.isGoal) continue;*/

                if (copyGame.count+1 == 10) continue;

//                if (visited[red.x][red.y]) continue;

//                visited[red.x][red.y] = true;

//                if (rx == red.x && ry == red.y) continue; // 더 이상 구슬이 움직이지 않을 때

                copyGame.count += 1;
                pq.offer(copyGame);
//
//                System.out.println("red.isGoal = " + red.isGoal);
//                System.out.println("blue.isGoal = " + blue.isGoal);

//                break;
            }
        }
    }

    private static Game copyGame(Game game) {
        return new Game(new RED(game.red.x, game.red.y, game.red.isGoal), new BLUE(game.blue.x, game.blue.y, game.blue.isGoal), game.count);
    }

    private static void move(int vector, Ball ball, Ball anoBall) { // (방향, 움직일 공, 다른 공(another Ball))
//        System.out.println("Main11_13460.move : " + vector);
        int x = ball.x;
        int y = ball.y;
        int nx = x;
        int ny = y;

//        if (ball.isGoal) return;

        while(true) {
            nx += dx[vector];
            ny += dy[vector];

            if (board[nx][ny].equals("#")) break;

            if (board[nx][ny].equals("O")) ball.isGoal = true;

            if (anoBall.x == nx && anoBall.y == ny) break;

            x += dx[vector];
            y += dy[vector];
            if (!board[nx][ny].equals(".")) break;
        }
        ball.x = x;
        ball.y = y;
    }

    private static void PRINT(Game game) {
        String[][] temp = new String[N][M];

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                temp[i][j] = board[i][j];
            }
        }

        Ball red = game.red;
        Ball blue = game.blue;
        temp[red.x][red.y] = "R";
        temp[blue.x][blue.y] = "B";

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                System.out.print(temp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }

    static abstract class Ball {
        int x;
        int y;
        boolean isGoal;

        public Ball(int x, int y, boolean isGoal) {
            this.x = x;
            this.y = y;
            this.isGoal = isGoal;
        }
    }

    static class Game implements Comparable<Game> {
        Ball red;
        Ball blue;
        int count;

        public Game(Ball red, Ball blue, int count) {
            this.red = red;
            this.blue = blue;
            this.count = count;
        }

        @Override
        public int compareTo(Game o) {
            return this.count - o.count;
        }
    }

    static class RED extends Ball{
        public RED(int x, int y, boolean isGoal) {
            super(x, y, isGoal);
        }
    }

    static class BLUE extends Ball{
        public BLUE(int x, int y, boolean isGoal) {
            super(x, y, isGoal);
        }
    }

}