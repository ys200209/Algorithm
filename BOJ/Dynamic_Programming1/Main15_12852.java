import java.io.*;
import java.util.*;

public class Main15_12852 {
    static int N;
    static int[] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];

        dp[1] = 0;

        for(int i=2; i<=N; i++) {

            dp[i] = dp[i-1] + 1;
            
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i/3] + 1);
            } 
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            }
        }

        int num = N;
        sb.append(num + " ");
        for(int i=0; i<dp[N]; i++) {
            if (num % 3 == 0 && dp[num/3] < dp[num-1]) {
                if (dp[num/3] < dp[num/2]) {
                    num /= 3;
                    sb.append(num + " ");
                } else {
                    num /= 2;
                    sb.append(num + " ");
                }
            } else if (num % 2 == 0 && dp[num/2] < dp[num-1]) {
                if (dp[num/3] < dp[num/2]) {
                    num /= 3;
                    sb.append(num + " ");
                } else {
                    num /= 2;
                    sb.append(num + " ");
                }
            } else {
                num -= 1;
                sb.append(num + " ");
            }
        }

        System.out.println(dp[N]);
        System.out.println(sb);

    }
    
}