import java.util.*;
import java.io.*;

public class Main8_6 {
    static int T, K, N;
    static int[][] apart;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            K = Integer.parseInt(br.readLine());
            N = Integer.parseInt(br.readLine());

            apart = new int[15][15];

            for(int i=1; i<=N; i++) {
                apart[0][i] = i;
            }

            for(int i=1; i<=K; i++) {
                for(int j=1; j<=N; j++) {
                    apart[i][j] = apart[i-1][j] + apart[i][j-1];
                }
            }

            sb.append(apart[K][N] + "\n");
            
        }

        System.out.println(sb);

    }

}