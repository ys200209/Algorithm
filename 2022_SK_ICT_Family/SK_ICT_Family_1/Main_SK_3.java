import java.util.*;
import java.io.*;

public class Main_SK_3 {
    static int MOD = 10000019;
    static long MAX=0; 
    static int N, M;
    static long[][] dp;
    
    public static void main(String[] args) throws IOException {
        
        //System.out.println(solution(2, 2, new int[][]{{1,1}, {2,2}})); // 12
        //System.out.println(solution(10, 10, new int[][]{{5,5}})); // % 10000 = 9436
        System.out.println(solution(51, 37, new int[][]{{17,19}})); // 12

    }

    public static int solution(int width, int height, int[][] diagonals) {
        N = height;
        M = width;
        
        for(int i=0; i<diagonals.length; i++) {
            dp = new long[N+2][M+2];
            dp[height][1] = 1;

            count(diagonals[i]);

            for(int j=0; j<dp.length; j++) {
                System.out.println(Arrays.toString(dp[j]));
            }
            MAX = Math.max(MAX, dp[0][dp[0].length-1]);
        }

        return (int)MAX;
    }

    public static void count(int[] dia) { // 몇 번째 대각선을 이용할 지.
        System.out.println("dia : [" + dia[0] + ", " + dia[1] + "]");
        for(int i=N+1; i>=0; i--) {
            for(int j=1; j<dp[i].length; j++) {
                if (i == dp.length - dia[1] - 2 && j == dia[0]) { // 대각선의 위쪽
                    dp[i][j] = dp[dp.length - dia[1] - 1][j] * 2 + dp[i][j-1];
                } else if (i == dp.length - dia[1] - 1 && j == dia[0] + 1) { // 대각선의 오른쪽
                    dp[i][j] = dp[i][j-1] * 2 + dp[i+1][j];
                } else {
                    long num = dp[i+1][j] + dp[i][j-1];
                    dp[i][j] += num > MOD ? num % MOD : num;
                }
                
            }
        }
    }
}