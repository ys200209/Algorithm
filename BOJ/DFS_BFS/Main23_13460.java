import java.util.*;
import java.io.*;

public class Main23_13460 {
    static RED redBall;
    static BLUE blueBall;
    static int[] PASS = new int[2];
    static int[] dx = {-1, 1, 0, 0}; // ╩С, го, аб, ©Л
    static int[] dy = {0, 0, -1, 1};
    static int N, M, result=0;
    static String[][] board;
    static Queue<Point> queue = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new String[N][M];

        for(int i=0; i<N; i++) {
            board[i] = br.readLine().split("");
            for(int j=0; j<M; j++) {
                if (board[i][j].equals("R")) redBall = new RED("R", i, j, new boolean[N][M], false);

                if (board[i][j].equals("B")) blueBall = new BLUE("B", i, j, new boolean[N][M], false);

                if (board[i][j].equals("O")) {
                    PASS[0] = i;
                    PASS[1] = j;
                }
            }
        }

        queue.offer(new Point(board, redBall, blueBall, 0));
        result = BFS();

        System.out.println("result : " + result);
        
    }

    public static int BFS() {

        while(!queue.isEmpty()) {
            Point point = queue.poll();
            int rx = point.redBall.x;
            int ry = point.redBall.y;
            int bx = point.blueBall.x;
            int by = point.blueBall.y;

            if (point.count > 10) continue;

            for(int i=0; i<4; i++) {
                int nx = rx + dx[i];
                int ny = ry + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if (point.redBall.visited[nx][ny]) continue;
                
                point = MOVE(point, "R", i);

                if (point != null) {
                    if (point.redBall.visited[PASS[0]][PASS[1]]) {
                        if (point.blueBall.visited[PASS[0]][PASS[1]]) return -1;
                        else return point.count;
                    }

                    queue.offer(new Point(point.board, point.redBall, point.blueBall, point.count+1));
                }
            }   
        }

        return -1;
    }

    public static Point MOVE(Point point, String color, int vector) {

        if (color.equals("R")) {
            int nx = point.redBall.x + dx[vector];
            int ny = point.redBall.y + dy[vector];

            int blueCount = 0;
            while(true) {
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) return point;

                if (point.board[nx][ny].equals("#")) return point;

                if (point.redBall.visited[nx][ny]) return null;

                if (point.board[nx][ny].equals("B")) {
                    if (blueCount == 1) return point;
                    MOVE(point, "B", vector);
                    blueCount++;
                    continue;
                }

                point.redBall.visited[nx][ny] = true;
                point.board[nx - dx[vector]][ny - dy[vector]] = ".";
                point.board[nx][ny] = "R";
                nx += dx[vector];
                ny += dy[vector];
            }

        } else {
            int nx = point.blueBall.x + dx[vector];
            int ny = point.blueBall.y + dy[vector];

            while(true) {
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) return point;

                if (point.board[nx][ny].equals("#")) return point;

                point.blueBall.visited[nx][ny] = true;
                point.board[nx - dx[vector]][ny - dy[vector]] = ".";
                point.board[nx][ny] = "B";
                nx += dx[vector];
                ny += dx[vector];
            }
        }
    }

}

class Point {

    String[][] board;
    RED redBall;
    BLUE blueBall;
    int count;

    public Point(String[][] board, RED redBall, BLUE blueBall, int count) {
        this.board = board;
        this.redBall = redBall;
        this.blueBall = blueBall;
        this.count = count;
    }

}

class RED {

    String color;
    int x;
    int y;
    boolean[][] visited; 
    boolean isPass;

    public RED(String color, int x, int y, boolean[][] visited, boolean isPass) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.visited = visited;
        this.isPass = isPass;
    }
}

class BLUE {

    String color;
    int x;
    int y;
    boolean[][] visited;
    boolean isPass;

    public BLUE(String color, int x, int y, boolean[][] visited, boolean isPass) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.visited = visited;
        this.isPass = isPass;
    }

}