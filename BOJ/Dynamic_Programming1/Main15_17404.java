import java.util.*;
import java.io.*;

public class Main15_17404 {
    static int N, result=(int)1e9;
    static int[][] color, dp;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        color = new int[N+1][3];
        dp = new int[N+1][3];

        StringTokenizer st;
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            color[i][0] = Integer.parseInt(st.nextToken());
            color[i][1] = Integer.parseInt(st.nextToken());
            color[i][2] = Integer.parseInt(st.nextToken());
        }

        if (N == 1) {
            System.out.println(Math.min(dp[1][0], Math.min(dp[1][1], dp[1][2])));
        }

        houseFillColor("R");
        houseFillColor("G");
        houseFillColor("B");
        
        System.out.println(result);
    }

    public static void houseFillColor(String c) {
        dp = new int[N+1][3];
        dp[1][0] = (int)1e9;
        dp[1][1] = (int)1e9;
        dp[1][2] = (int)1e9;

        if (c.equals("R")) {
            dp[1][0] = color[1][0];
        } else if (c.equals("G")) {
            dp[1][1] = color[1][1];
        } else {
            dp[1][2] = color[1][2];
        }

        for(int i=2; i<=N; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + color[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + color[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + color[i][2];
        }

        if (c.equals("R")) {
            result = Math.min(result, Math.min(dp[N][1], dp[N][2]));
        } else if (c.equals("G")) {
            result = Math.min(result, Math.min(dp[N][0], dp[N][2]));
        } else {
            result = Math.min(result, Math.min(dp[N][0], dp[N][1]));
        }

        /*System.out.println("color : " + c);
        for(int i=0; i<=N; i++) {
            System.out.println("i : " + i + ", " + Arrays.toString(dp[i]));
        }*/
    }

}
