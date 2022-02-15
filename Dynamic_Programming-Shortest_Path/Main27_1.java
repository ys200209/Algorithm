import java.util.*;
import java.io.*;

public class Main27_1 {
    static int X;
    static int[] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        X = Integer.parseInt(br.readLine());
        dp = new int[X+1];

        dp[1] = 0;

        for(int i=2; i<=X; i++) {
            dp[i] = dp[i-1] + 1;

            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);

            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
            
        }

        sb.append(dp[X] + "\n");

        while(X >= 1) {
            sb.append(X + " ");

            int Y = dp[X]-1;
            if (X % 3 == 0 && X % 2 == 0) {
                X = Y >= Math.min(dp[X/3], dp[X/2]) ? (dp[X/3] > dp[X/2] ? X/2 : X/3) : X-1;
            } else if (X % 3 == 0) {
                X = Y >= dp[X/3] ? X/3 : X-1;
            } else if (X % 2 == 0) {
                X = Y >= dp[X/2] ? X/2 : X-1;
            } else {
                X -= 1;
            }


            
        }

        // System.out.println(Arrays.toString(dp));

        // sb.append("1");
        System.out.println(sb);

    }
}