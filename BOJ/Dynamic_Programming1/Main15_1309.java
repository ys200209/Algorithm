import java.util.*;

public class Main15_1309 {
    static int N, result=0;
    static int[] dp;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        dp = new int[N+1];

        dp[1] = 3; // 2 + 1
        dp[2] = 7; // 4 + 2 + 1
        dp[3] = 17; // 6 + 8 + 2 + 1
        dp[4] = 41; // 8 + 8 + 4 + 2 + 1


        for(int i=1; i<=N; i++) {

        }


    }
    
}
