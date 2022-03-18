import java.util.*;
import java.io.*;

public class Main11_14503 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1}; // 북, 동, 남, 서 (차례대로 오른쪽으로 회전)
    static int N, M, r, c, vector, result=0;
    static Robot robot;
    static int[][] map;
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        vector = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j=0;
            while(st.hasMoreTokens()) {
                map[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

        robot = new Robot(r, c);

        Search();

        for(int i=0; i<N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println("result : " + result);
    }

    public static void Search() {
        
        int x = robot.x;
        int y = robot.y;
        int count=0;
        visited[x][y] = true;
        result++;

        while(true) {
            if (count == 4) {
                System.out.println("count = 4");
                int nv = vector <= 1 ? 2-vector : vector-2;
                int nnx = robot.x + dx[nv];
                int nny = robot.y + dy[nv];
                
                if (map[nnx][nny] == 1) {
                    System.out.println("nnx : " + nnx + ", nny : " + nny + " vector : " + nv + ", return;");
                    return;
                }

                robot.x = nnx;
                robot.y = nny;
                count=0;
                System.out.println("(back) robot x : " + robot.x + ", robot y : " + robot.y);
                continue;
            }
            vector = vector == 0 ? 3 : vector-1;
            int nx = robot.x + dx[vector];
            int ny = robot.y + dy[vector];

            System.out.println("nx : " + nx + ", ny : " + ny);

            if (visited[nx][ny]) {
                count++;
                continue;
            }

            if (map[nx][ny] == 1) {
                count++;
                System.out.println("map["+nx+"]["+ny+"] : " + map[nx][ny] + ", vector : " + vector);
                continue;
            }
            
            visited[nx][ny] = true;
            robot.x = nx;
            robot.y = ny;
            count = 0;
            result++;
            map[nx][ny] = result;

            System.out.println("robot x : " + robot.x + ", robot y : " + robot.y);

        }
    }

}

class Robot {

    int x;
    int y;

    public Robot(int x, int y) {
        this.x = x;
        this.y = y;
    }

}