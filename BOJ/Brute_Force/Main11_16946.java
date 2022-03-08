import java.util.*;
import java.io.*;

public class Main11_16946 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N, M, count;
    static int[][] map, result;
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        result = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            String[] str = br.readLine().split("");
            for(int j=0; j<M; j++) {
                if (str[j].equals("1")) {
                    map[i][j] = -1;
                    result[i][j] = -1;
                }
                else {
                    map[i][j] = 0;
                    result[i][j] = 0;
                }
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                count = 1;
                if (map[i][j] == -1) {
                    visited = new boolean[N][M];
                    DFS(i, j);
                    result[i][j] = count;
                } else result[i][j] = 0;
                sb.append(result[i][j]);
            }
            sb.append("\n");
        }

        //System.out.println("-------------------");
        System.out.println(sb);
        
    }

    public static void DFS(int x, int y) {

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

            if (visited[nx][ny]) continue;

            if (map[nx][ny] == -1) continue;

            visited[nx][ny] = true;
            count++;
            DFS(nx, ny);
            // visited[nx][ny] = false;
        }


    }

}