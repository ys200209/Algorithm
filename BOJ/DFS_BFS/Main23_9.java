import java.io.*;
import java.util.*;

public class Main23_9 {
    static int width, height, result=(int)1e9;
    static String[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        map = new String[width][height]; 
        visited = new boolean[width][height]; 

        for(int i=0; i<width; i++) {
            map[i] = br.readLine().split("");
        }

        DFS(0, 0, 0, 1);
        
        if (result > width * height) result = -1;

        System.out.println(result);

    }

    public static void DFS(int x, int y, int wall_break, int count) {

        if (visited[x][y]) return;

        if (x == width-1 && y == height-1) {
            result = Math.min(result, count);
            return;
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        
        for(int i=0; i<4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx < 0 || nx >= width || ny < 0 || ny >= height) continue;

            if ("0".equals(map[nx][ny])) {
                visited[x][y] = true;
                count += 1;
                DFS(nx, ny, wall_break, count);
                count -= 1;
                visited[x][y] = false;
            }
            else if ("1".equals(map[nx][ny])) {
                if (wall_break == 0) {
                    visited[x][y] = true;
                    wall_break += 1;
                    count += 1;
                    DFS(nx, ny, wall_break, count);
                    wall_break -= 1;
                    count -= 1;
                    visited[x][y] = false;
                }  
            } 
        }
        
    }
    
}
