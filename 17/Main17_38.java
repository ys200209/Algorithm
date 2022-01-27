import java.io.*;
import java.util.*;

public class Main17_38 {
    static int INF = (int) 1e9;
    static int N, M, result=0;
    static int[][] d;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
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
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            d[a][b] = 1;
        }

        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }

        for(int i=1; i<=N; i++) {
            System.out.println(Arrays.toString(d[i]));
        }

        for(int i=1; i<=N; i++) {
            int cnt=0;
            for(int j=1; j<=N; j++) {
                if (d[i][j] != INF || d[j][i] != INF) {
                    cnt++;
                }

                if (cnt == N) {
                    result++;
                }
            }
        }

        System.out.println(result);


    }
    
}