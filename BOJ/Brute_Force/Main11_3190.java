import java.util.*;
import java.io.*;

public class Main11_3190 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0}; // [©Л, го, аб, ╩С] [B, B-D, B-D, R]
    static int N, K, L, vector=0, time=0;
    static int[][] map;
    static Snake snake;
    static Queue<Snake> snakeQueue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        StringTokenizer st;

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            map[R][C] = 1;
        }

        map[1][1] = 2;
        snake = new Snake(1, 1);
        snakeQueue.offer(snake);

        L = Integer.parseInt(br.readLine());
        for(int i=0; i<L; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int X = Integer.parseInt(st.nextToken());
            String Y = st.nextToken();

            if (!MOVE(snake, X, vector)) {
                System.out.println(time);
                return;
            }

            if (Y.equals("D")) vector = vector == 3 ? 0 : vector+1;
            else vector = vector == 0 ? 3 : vector-1;
        }

        MOVE(snake, 101, vector);

        System.out.println(time);

    }

    public static boolean MOVE(Snake s, int count, int vec) {
        int nx = s.x;
        int ny = s.y;
        while(count > time) {
            time++;

            nx += dx[vec];
            ny += dy[vec];

            if (nx < 1 || nx > N || ny < 1 || ny > N) return false;

            if (map[nx][ny] == 2) return false;

            if (map[nx][ny] == 1) {
                map[nx][ny] = 2;
                snake = new Snake(nx, ny);
                snakeQueue.offer(snake);
            } else {
                map[nx][ny] = 2;
                snake = new Snake(nx, ny);
                snakeQueue.offer(snake);
                Snake sk = snakeQueue.poll();
                map[sk.x][sk.y] = 0;
            }
            
        }
        return true;
    }

}

class Snake {

    int x;
    int y;

    public Snake(int x, int y) {
        this.x = x;
        this.y = y;
    }

}