import java.util.*;
import java.io.*;

public class Main15_2294 {
    static int N, K;
    static int[] A, dp;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N+1];
        dp = new int[K+1];

        for(int i=1; i<=N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        // Arrays.sort(A);
        Arrays.fill(dp, (int)1e9);

        dp[0] = 0;

        for(int i=N; i>0; i--) {
            for(int j=A[i]; j<=K; j++) {
                dp[j] = Math.min(dp[j], dp[j-A[i]] + 1);
            }
            /**/System.out.println("[" + A[i] + "]");
            System.out.println(Arrays.toString(dp));
        }
        
        if (dp[K] == (int)1e9) System.out.println("-1");
        else System.out.println(dp[K]);

    }

}