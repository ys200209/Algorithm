import java.util.*;
import java.io.*;

public class Main15_17626 {
    static int N, result=0;
    static Integer[] dp;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new Integer[N+1];

        dp[0] = 0;
        for(int i=1; i<=Math.sqrt(N); i++) {
            dp[i*i] = 1;
        }

        for(int i=2; i<=N; i++) {
            int j = (int)Math.sqrt(i);
            if (dp[i] == null) dp[i] = Math.min(dp[i-1]+1, dp[j*j] + dp[i - j*j]);
            else dp[i] = Math.min(dp[i], Math.min(dp[i-1]+1, dp[j*j] + dp[i - j*j]));
            
        }

        System.out.println(Arrays.toString(dp));

        System.out.println(dp[N]);


    }

    public static int TopDown(int number) {
        if (number == 1) return 1;

        int index = (int)Math.sqrt(number);
        if (dp[number] != null) return dp[number] = Math.min(dp[number], TopDown(index*index) + TopDown(number - (index*index)));
        
        return dp[number] = TopDown(index*index) + TopDown(number - (index*index));
    }

}
