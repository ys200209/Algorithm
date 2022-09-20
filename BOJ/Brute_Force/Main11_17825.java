package BOJ.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main11_17825 {

    public static void main(String[] args) throws IOException {

        System.out.println(solution(4)); // 5
//        System.out.println(solution(3)); // 3


    }

    public static long solution(int n) {
        int[] dp = new int[n+1];

        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(Arrays.toString(dp));

        return dp[n];
    }

}