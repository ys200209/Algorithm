import java.util.*;
import java.io.*;

public class Main16_3109 {
    static int[] dx = {-1, 0, 1};
    static int R, C, result=0;
    static String[][] map;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new String[R][C];

        for(int i=0; i<R; i++) {
            map[i] = br.readLine().split("");
        }
        
        for(int i=0; i<R; i++) {
            if (DFS(i, 0)) result++;
        }

        System.out.println(result);

    }

    public static boolean DFS(int x, int y) {
        if (y == C-1) return true;
        
        for(int i=0; i<3; i++) {
            int nx = x + dx[i];
            int ny = y + 1;

            if (nx < 0 || nx >= R || ny >= C) continue;

            if (map[nx][ny].equals("x")) continue;

            map[nx][ny] = "x";
            if (DFS(nx, ny)) return true;

        }
        return false;
    }
}