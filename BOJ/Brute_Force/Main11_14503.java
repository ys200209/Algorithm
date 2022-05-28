import java.util.*;
import java.io.*;

public class Main11_14503 {
    static int[] dx = {1, 0, -1, 0}; // [ºÏ, µ¿, ³², ¼­] ( 0-1-2-3 )
    static int[] dy = {0, 1, 0, -1};
    static int N, M, count=0;
    static int[][] room;
    static Robot rb;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        rb = new Robot(r, c, d);

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[r][c] = true;
        DFS();

        System.out.println("count : " + count);
    }

    public static void DFS() {
        clean();

        if (first()) DFS();
    }

    public static void clean() {
        visited[rb.x][rb.y] = true;
        count += 1;
    }

    public static boolean first() {
        for(int i=1; i<=4; i++) {
            int vector = rb.vector - i < 0 ? rb.vector - i + 4 : rb.vector - i;

            int nx = rb.x + dx[vector];
            int ny = rb.y + dy[vector];

            if (room[nx][ny] == 1) continue;

            if (!visited[nx][ny]) {
                rb.x = nx;
                rb.y = ny;
                rb.vector = vector;
                return true;
            }
        }

        if (!second()) return false;
        else return true;
    }

    public static boolean second() {
        int vector = rb.vector - 2 < 2 ? rb.vector + 2 : rb.vector - 2;

        int nx = rb.x + dx[vector];
        int ny = rb.y + dy[vector];

        if (room[nx][ny] == 1) return false;
        else {
            rb.x = nx;
            rb.y = ny;
            return true;
        }
    }
}

class Robot {

    int x;
    int y;
    int vector;

    public Robot(int x, int y, int vector) {
        this.x = x;
        this.y = y;
        this.vector = vector;
    }
}