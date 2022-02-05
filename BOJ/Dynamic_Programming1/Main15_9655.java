import java.util.*;

public class Main15_9655 {
    static int N;
    static String result;
    static String[] dp;
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        dp = new String[N+1];

        dp[1] = "SK";
        dp[2] = "CY";
        dp[3] = "SK";
        
        for(int i=2; i<=N; i++) {
            dp[i] = dp[i-1].equals("SK") ? "CY" : "SK";
        }
        result = dp[N];

        System.out.println(Arrays.toString(dp));

        dp = new String[N+1];
        dp[1] = "SK";
        dp[2] = "CY";
        dp[3] = "SK";
        for(int i=4; i<=N; i++) {
            dp[i] = dp[i-3];
        }

        System.out.println(Arrays.toString(dp));
        System.out.println(dp[N]);
        
    }
}