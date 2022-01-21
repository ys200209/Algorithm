import java.io.*;
import java.util.*;

public class Main21_7 {
    static int N, num, result=0;
    static int[] A, dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int i=0;
        while(st.hasMoreTokens()) {
            A[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
            i++;
        }

        for(i=0; i<N; i++) {
            binarySearch(i, A[i], 0, i);
        }
    }

    public static binarySearch(int now, int target, int front, int back) {
        if (front > back) return;

        int mid = (front+back) / 2;

        if (A[mid] > target) {
            dp[now] = Math.max(dp[now], dp[mid] + 1);
            binarySearch(now, mid+1, back);
        } 
    }
}