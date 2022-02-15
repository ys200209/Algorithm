import java.util.*;
import java.io.*;

public class Main27_3 {
    static int N, lastIndex=1, longest=1;
    static int[] A, B, dp;
    static ArrayList<Integer> result = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        B = new int[N+1];
        dp = new int[N+1];

        int i=1;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()) {
            A[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        B[1] = A[1];
        Arrays.fill(dp, 1);
        dp[0] = 0;

        for(i=2; i<=N; i++) {
            lowerBound(i, A[i], 1, lastIndex);
        }

        System.out.println("B : " + Arrays.toString(B));
        System.out.println("dp : " + Arrays.toString(dp));
        /*System.out.println("lastIndex : " + lastIndex);
        System.out.println("longest : " + longest);*/

        sb.append(lastIndex + "\n");

        result.add(A[longest]);
        while(longest > 1) {
            longest--;
            if (lastIndex-1 == dp[longest]) {
                result.add(A[longest]);
                lastIndex -= 1;
            }
        }

        Collections.sort(result);
        for(int num : result) {
            sb.append(num + " ");
        }

        System.out.println(sb);

    }

    public static void lowerBound(int index, int num, int start, int end) {
        if (B[lastIndex] < num) {
            lastIndex++;
            B[lastIndex] = num;
            dp[index] = lastIndex;
            longest = index;
            return;
        }

        if (start > end) {
            B[start] = num;
            dp[index] = start;
            return;
        }

        int mid = (start+end)/2;
        
        if (B[mid] > num) {
            lowerBound(index, num, start, mid-1);
        } else if (B[mid] < num) {
            lowerBound(index, num, mid+1, end);
        } else {
            dp[index] = mid;
        }
    }
    
}