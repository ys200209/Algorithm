import java.util.*;
import java.io.*;

public class Main15_10942 {
    static int N, M;
    static int[] A;
    static boolean[][] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        dp = new boolean[N+1][N+1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int i=1;
        while(st.hasMoreTokens()) {
            A[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        Dynamic();

        M = Integer.parseInt(br.readLine());
        for(i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append((dp[start][end] ? "1" : "0") + "\n");
        }
        System.out.println(sb);
    }

    public static void Dynamic() {
        for(int i=1; i<=N; i++) dp[i][i] = true; // 한 글자 팰린드롬 true

        for(int i=1; i<=N-1; i++) if (A[i] == A[i+1]) dp[i][i+1] = true; // 두 글자 같은 팰린드롬 true

        for(int i=2; i<N; i++){ 
            for(int j=1; j<=N-i; j++){
                if(A[j] == A[j + i] && dp[j + 1][j + i - 1]) dp[j][j + i] = true;
            }
        }
    }

}