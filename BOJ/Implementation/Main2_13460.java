package BOJ.Implementation;

import java.io.*;
import java.util.*;

public class Main2_13460 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N, M;
    static String[][] board;
    static Queue<Game> pq = new PriorityQueue<>();
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new String[N][M];
        visited = new boolean[N][M];

        RED red = null;
        BLUE blue = null;
        for(int i=0; i<N; i++) {
            board[i] = br.readLine().split("");

            for(int j=0; j<M; j++) {
                if (board[i][j].equals("R")) {
                    red = new RED(i, j, false);
                    board[i][j] = ".";
                }
                else if (board[i][j].equals("B")) {
                    blue = new BLUE(i, j, false);
                    board[i][j] = ".";
                }
            }
        }

        pq.offer(new Game(red, blue, 0));

        /*for(int i=0; i<N; i++) {
            System.out.println(Arrays.toString(board[i]));
        }*/

        int result = BFS();

        System.out.println(result);
    }

    private static int BFS() {

        while(!pq.isEmpty()) {
            Game game = pq.poll();
            RED red = game.red;
            BLUE blue = game.blue;

//            System.out.println("game.count : " + game.count);

            for(int i=0; i<4; i++) {
                RED tempRed = new RED(red.x, red.y, red.isGoal);
                BLUE tempBlue = new BLUE(blue.x, blue.y, blue.isGoal);
                move(tempRed, tempRed, tempBlue, i);
//                move(tempBlue, tempRed, tempBlue, i);

                if (tempRed.isGoal && !tempBlue.isGoal) return game.count+1;
                else if (tempRed.isGoal && tempBlue.isGoal) continue;
                else if (!tempRed.isGoal && tempBlue.isGoal) continue;
                else {
                    if (game.count == 10) continue;

                    pq.offer(new Game(tempRed, tempBlue, game.count+1));
                }
            }
        }

        return -1;
    }

    private static void move(Ball ball, RED red, BLUE blue, int vector) {
        int x = 0;
        int y = 0;
        if (ball instanceof RED) {
            x = red.x;
            y = red.y;
        } else {
            x = blue.x;
            y = blue.y;
        }

//        System.out.println("instanceof : " + ball.getClass());
//        System.out.println("x : " + x + ", y : " + y);
        while(true) {
//            System.out.println("board["+(x+dx[vector])+"]["+(y+dy[vector])+"] = " );
            if(board[x+dx[vector]][y+dy[vector]].equals("#")) {
//                System.out.println("inner #");
                if (ball instanceof RED) {
//                    board[red.x][red.y] = ".";
                    red.x = x;
                    red.y = y;
//                    board[red.x][red.y] = "R";
                    move(blue, red, blue, vector);
                } else {
//                    board[blue.x][blue.y] = ".";
                    blue.x = x;
                    blue.y = y;
//                    board[blue.x][blue.y] = "B";
                }
                break;
            } else if (board[x+dx[vector]][y+dy[vector]].equals("O")) {
                if (ball instanceof RED) {
//                    board[red.x][red.y] = ".";
                    red.x = -1;
                    red.y = -1;
                    red.isGoal = true;
                    move(blue, red, blue, vector);
                } else {
//                    board[blue.x][blue.y] = ".";
                    blue.x = -1;
                    blue.y = -1;
                    blue.isGoal = true;
                }
                break;
            } else if (ball instanceof RED && (blue.x == x+dx[vector]) && (blue.y == y+dy[vector])) {
                move(blue, red, blue, vector);
                if ((blue.x == x+dx[vector]) && (blue.y == y+dy[vector])) break;
                continue;
            } else if (ball instanceof BLUE && (red.x == x+dx[vector]) && (red.y == y+dy[vector])) {
//                board[blue.x][blue.y] = ".";
                blue.x = x;
                blue.y = y;
//                board[blue.x][blue.y] = "B";
                break;
            }
            x += dx[vector];
            y += dy[vector];
        }
    }

    interface Ball { }

    static class Game implements Comparable<Game> {

        RED red;
        BLUE blue;
        int count;

        public Game(RED red, BLUE blue, int count) {
            this.red = red;
            this.blue = blue;
            this.count = count;
        }

        @Override
        public int compareTo(Game game) {
            return this.count - game.count;
        }
    }

    static class RED implements Ball {
        int x;
        int y;
        boolean isGoal;

        public RED(int x, int y, boolean isGoal) {
            this.x = x;
            this.y = y;
            this.isGoal = isGoal;
        }
    }

    static class BLUE implements Ball {
        int x;
        int y;
        boolean isGoal;

        public BLUE(int x, int y, boolean isGoal) {
            this.x = x;
            this.y = y;
            this.isGoal = isGoal;
        }
    }

}

