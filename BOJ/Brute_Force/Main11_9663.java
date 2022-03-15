import java.util.*;
import java.io.*;

public class Main11_9663 {
    static int[] dx = {-1, -1, 1, 1};
    static int[] dy = {-1, 1, -1, 1};
    static int N, result = 0;
    static boolean[] row, column;
    static boolean[][] m;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        row = new boolean[N];
        column = new boolean[N];
        m = new boolean[N][N];

        //checkM(4, 4, true);

        DFS(0, m);

        /*for(int i=0; i<N; i++) {
            System.out.println(Arrays.toString(m[i]));
        }*/
        System.out.println(result);
    }

    public static void DFS(int count, boolean[][] visited) {
        if (row[count]) return;

        for(int j=0; j<N; j++) {
            if (column[j]) continue;

            if (!visited[count][j]) { 
                if (count == N-1) {
                    result++;
                    return;
                }
                row[count] = true;
                column[j] = true;
                boolean[][] temp = checkM(count, j, visited);
                DFS(count+1, temp);
                row[count] = false;
                column[j] = false;
            }
        }

    }

    public static boolean[][] checkM(int x, int y, boolean[][] visited) {
        // System.out.println("x : " + x + ", y : " + y + ", check : " + check);
        
        boolean[][] t = new boolean[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                t[i][j] = visited[i][j];
            }
        }


        t[x][y] = true;

        for(int i=0; i<4; i++) {
            int nx = x;
            int ny = y;
            while(true) {
                nx += dx[i];
                ny += dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) break;

                t[nx][ny] = true;
            }
        }

        return t;
    }
}