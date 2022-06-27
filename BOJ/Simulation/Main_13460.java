import java.util.*;
import java.io.*;

public class Main_13460 {
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1}; // 상, 하, 좌, 우
    static int N, M;
    static String[][] board;
    static boolean[][] visited;
    static Ball red, blue;
    static Queue<Balls> pq = new PriorityQueue<>();
    
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
                if (board[i][j].equals("R")) red = new Ball(i, j, "R", false);
                if (board[i][j].equals("B")) blue = new Ball(i, j, "B", false);
            }
        }

        BFS();


    }

    public static void BFS() {
        visited[red.x][red.y] = true;
        pq.offer(new Balls(red, blue, 0));

        if (!pq.isEmpty()) {
            Balls balls = pq.poll();
            Ball red = balls.red;
            Ball blue = balls.blue;
            int x = red.x;
            int y = red.y;

            for(int i=0; i<4; i++) {

                move(red, blue, i, "R");

                pq.offer(new Balls(red, blue, balls.count+1));
                


            }
        }
    }

    public static void move(Ball red, Ball blue, int i, String color) {
        if (color.equals("R")) {
            int nx = red.x;
            int ny = red.y;
            int count = 0;

            while(true) {
                nx += dx[i];
                ny += dy[i];
    
                if (isBreak(nx, ny, red)) {
                    red.x = nx - dx[i];
                    red.y = ny - dy[i];
                    break;
                }

                visited[nx][ny] = true;
    
                if (board[nx][ny].equals("B")) {
                    if (count == 0) { // 첫 충돌시에만 B로 이동하여 움직이도록
                        count++;
                        move(red, blue, i, "B");
                        nx -= dx[i];
                        ny -= dy[i];
                    } else {
                        red.x = nx - dx[i];
                        red.y = ny - dy[i];
                        break;
                    }
                }
            }
        } else {
            int nx = blue.x;
            int ny = blue.y;

            while(true) {
                nx += dx[i];
                ny += dy[i];

                if (isBreak(nx, ny, blue)) {
                    blue.x = nx - dx[i];
                    blue.y = ny - dy[i];
                    break;
                }
            }
        }
       
    }

    public static boolean isBreak(int nx, int ny, Ball ball) {
        if (nx < 0 || nx >= N || ny < 0 || ny >= M) return true;

        if (ball.color.equals("R") && visited[nx][ny]) return true; // 붉은 공이 지나갔었다면 중단

        if (board[nx][ny].equals("#")) return true;

        return false;
    }

    public static void move(int vector) {

    }

}

class Balls implements Comparable<Balls> {

    Ball red;
    Ball blue;
    int count;

    public Balls(Ball red, Ball blue, int count) {
        this.red = red;
        this.blue = blue;
        this.count = count;
    }

    @Override
    public int compareTo(Balls balls) {
        return this.count - balls.count;
    }

}

class Ball {

    int x;
    int y;
    String color;
    boolean isGoal;

    public Ball(int x, int y, String color, boolean isGoal) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.isGoal = isGoal;
    }

}

