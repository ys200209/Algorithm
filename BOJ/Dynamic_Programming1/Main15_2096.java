import java.util.*;
import java.io.*;

public class Main15_2096 {
    static int N;
    static int[][] A;
    static Score[][] dp;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        A = new int[N][3];
        dp = new Score[N][3];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j=0;
            while(st.hasMoreTokens()) {
                A[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

        for(int i=0; i<3; i++) {
            dp[0][i] = new Score(A[0][i], A[0][i]);
        }

        for(int i=1; i<N; i++) {
            for(int j=0; j<3; j++) {
                if (j == 0) {
                    int MAX = Math.max(dp[i-1][j].MAX, dp[i-1][j+1].MAX) + A[i][j];
                    int MIN = Math.min(dp[i-1][j].MIN, dp[i-1][j+1].MIN) + A[i][j];
                    dp[i][j] = new Score(MAX, MIN);
                } else if (j == 1) {
                    int MAX = Math.max(dp[i-1][j].MAX, Math.max(dp[i-1][j-1].MAX, dp[i-1][j+1].MAX)) + A[i][j];
                    int MIN = Math.min(dp[i-1][j].MIN, Math.min(dp[i-1][j-1].MIN, dp[i-1][j+1].MIN)) + A[i][j];
                    dp[i][j] = new Score(MAX, MIN);
                } else {
                    int MAX = Math.max(dp[i-1][j].MAX, dp[i-1][j-1].MAX) + A[i][j];
                    int MIN = Math.min(dp[i-1][j].MIN, dp[i-1][j-1].MIN) + A[i][j];
                    dp[i][j] = new Score(MAX, MIN);
                }
            }
        }
        
        int MAX = 0;
        int MIN = (int)1e9;
        for(int i=0; i<3; i++) {
            MAX = Math.max(MAX, dp[N-1][i].MAX);
            MIN = Math.min(MIN, dp[N-1][i].MIN);
        }

        System.out.println(MAX + " " + MIN);

    }

}

class Score {

    int MAX;
    int MIN;

    public Score(int MAX, int MIN) {
        this.MAX = MAX;
        this.MIN = MIN;
    }

}