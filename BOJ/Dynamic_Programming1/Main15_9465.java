import java.io.*;
import java.util.*;

public class Main15_9465 {
    static int T, N;
    static int[][] sticker, dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            N = Integer.parseInt(br.readLine());
            sticker = new int[2][N+1];
            dp = new int[2][N+1];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int i=1;
            while(st.hasMoreTokens()) {
                sticker[0][i] = Integer.parseInt(st.nextToken());
                i++;
            }

            st = new StringTokenizer(br.readLine(), " ");
            i=1;
            while(st.hasMoreTokens()) {
                sticker[1][i] = Integer.parseInt(st.nextToken());
                i++;
            }

            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];

            int result = Math.max(dp[0][1], dp[1][1]);

            for(i=2; i<=N; i++) {
                for(int j=0; j<2; j++) {
                    if (j == 0) {
                        dp[j][i] = Math.max(dp[1][i-1], dp[1][i-2]) + sticker[j][i];
                    } else {
                        dp[j][i] = Math.max(dp[0][i-1], dp[0][i-2]) + sticker[j][i];
                    }

                    result = Math.max(result, dp[j][i]);
                }
            }

            sb.append(result + "\n");

            /*System.out.println("-------[sticker]------");
            for(i=0; i<2; i++) {
                System.out.println(Arrays.toString(sticker[i]));
            }
            System.out.println("-------[dp]------");
            for(i=0; i<2; i++) {
                System.out.println(Arrays.toString(dp[i]));
            }
            System.out.println("-------------------------------");*/
        }
        
        System.out.println(sb);

    }
    
}
