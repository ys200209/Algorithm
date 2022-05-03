import java.util.*;
import java.io.*;

public class Main23_13460 {
    static RED red;
    static BLUE blue;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M, result=-1;
    static String[][] board;
    static boolean[][] visited;
    static Queue<Game> queue = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new String[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            board[i] = br.readLine().split("");
            for(int j=0; j<M; j++) {
                if (board[i][j].equals("R")) red = new RED(i, j, false);

                if (board[i][j].equals("B")) blue = new BLUE(i, j, false);
            }
        }

        System.out.println("[MOVE before]");
        System.out.println("RED : (" + red.x + ", " + red.y + ")");
        System.out.println("BLUE : (" + blue.x + ", " + blue.y + ")");

        BFS(red, blue);

    }

    public static void BFS(RED red, BLUE blue) {
        queue.offer(new Game(red, blue));
        visited[red.x][red.y] = true;

        while(!queue.isEmpty()) {
            Game game = queue.poll();
            RED redBall = game.redBall;
            BLUE blueBall = game.blueBall;

            int rx = redBall.x;
            int ry = redBall.y;
            int bx = blueBall.x;
            int by = blueBall.y;

            for(int i=0; i<4; i++) {
                int nrx = rx + dx[i];
                int nry = ry + dy[i];

                if (nrx < 0 || nrx >= N || nry < 0 || nry >= M) continue;

                if (visited[nrx][nry]) continue;

                if (board[nrx][nry].equals("#")) continue; // ?? ?? ???? ?? 

                Game g;
                if (board[nrx][nry].equals("B")) { // BLUE ??? ?????
                    g = MOVE(redBall, blueBall, i, false);
                } else {
                    g = MOVE(redBall, blueBall, i, true);
                }
                
                if (g == null) System.out.println("return Null::");
                else {
                    System.out.println("[MOVE after] - " + i);
                    System.out.println("RED : (" + g.redBall.x + ", " + g.redBall.y + ")");
                    System.out.println("BLUE : (" + g.blueBall.x + ", " + g.blueBall.y + ")");
                    System.out.println();
                }
                

            }

            break;

        }

    }

    public static Game MOVE(RED redBall, BLUE blueBall, int vector, boolean firstRED) {
        int nrx = redBall.x + dx[vector];
        int nry = redBall.y + dy[vector];
        int nbx = blueBall.x + dx[vector];
        int nby = blueBall.y + dy[vector];

        if (firstRED) { // ???? ?? ??? ??. (???? ?? ??? ???? ???? ???.)
            while(true) {
                if (!board[nrx][nry].equals(".") && !board[nrx][nry].equals("O") &&
                    !board[nbx][nby].equals(".") && !board[nbx][nby].equals("O")) break;

                if (visited[nrx][nry]) return null;
                    
                
                    if (nrx >= 0 || nrx < N || nry >= 0 || nry < M) { // ?? ?? ?? ? ??
                        if (board[nrx][nry].equals("O")) redBall.isPass = true;

                        if (board[nrx][nry].equals(".") && board[nrx][nry].equals("O")) {
                            redBall.x = nrx;
                            redBall.y = nry;
                            nrx += dx[vector];
                            nry += dy[vector];
                        }
                        

                        if (nbx >= 0 || nbx < N || nby >= 0 || nby < M) {
                            if (board[nbx][nby].equals("O")) blueBall.isPass = true;
                            blueBall.x = nbx;
                            blueBall.y = nby;
                            nbx += dx[vector];
                            nby += dy[vector];
                        }
                        
                    }

            }
        } else {
            while(true) {
                
            }
        }
    
        redBall.x -= dx[vector];
        redBall.y -= dx[vector];
        blueBall.x -= dx[vector];
        blueBall.y -= dx[vector];

        return new Game(redBall, blueBall);
    }

}

class Game {
    RED redBall;
    BLUE blueBall;

    public Game(RED redBall, BLUE blueBall) {
        this.redBall = redBall;
        this.blueBall = blueBall;
    }
}

class RED {
    int x;
    int y;
    boolean isPass;

    public RED(int x, int y, boolean isPass) {
        this.x = x;
        this.y = y;
        this.isPass = isPass;
    }
}

class BLUE {
    int x;
    int y;
    boolean isPass;

    public BLUE(int x, int y, boolean isPass) {
        this.x = x;
        this.y = y;
        this.isPass = isPass;
    }
}