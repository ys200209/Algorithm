import java.util.*;
import java.io.*;

public class Main17_37 {
    static int INF = (int) 1e9;
    static int N, M;
    static int[][] d;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        d = new int[N+1][N+1];

        for(int i=1; i<=N; i++) {
            Arrays.fill(d[i], INF);
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if (i == j) d[i][j] = 0;
            }
        }

        for(int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            d[a][b] = Math.min(d[a][b], c);
        }
        
        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if (d[i][j] == INF) sb.append("0 ");
                else sb.append(d[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
    
    
}
