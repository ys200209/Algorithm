import java.util.*;
import java.io.*;

public class Main15_1520 {
    static int N, M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map, d;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+2][M+2];
        d = new int[N+2][M+2];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int j=1;
            while(st.hasMoreTokens()) {
                map[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }
        
        d[1][1] = 1;

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                for(int k=0; k<4; k++) {
                    int nx = j + dx[k];
                    int ny = i + dy[k];

                    if (map[i][j] < map[ny][nx]) {
                        d[i][j] += d[ny][nx];
                    }
                }
            }
        }

        for(int i=0; i<=N; i++) {
            System.out.println(Arrays.toString(d[i]));
        }

        


    }
    
}
