import java.util.*;
import java.io.*;

public class Main15_11 {
    static int N;
    static int[][] A;
    static int[] dp;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N+1][2];
        dp = new int[N+1];

        StringTokenizer st;
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(A, new Comparator<int[]>() {

            @Override
            public int compare(int[] arr1, int[] arr2) {
                return arr1[0] - arr2[0];
            }
        });
        
        for(int i=1; i<=N; i++) {
            dp[i] = 1;

            for(int j=1; j<i; j++) {
                if (A[i][1] > A[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            System.out.println("i : " + i + ", " + Arrays.toString(dp));
        }

    }


}