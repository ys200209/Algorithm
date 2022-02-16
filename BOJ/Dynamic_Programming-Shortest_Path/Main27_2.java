import java.util.*;
import java.io.*;

public class Main27_2 {
    static int N, index, MAX=0;
    static int[] A, dp;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> list = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        dp = new int[N+1];

        int i=1;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()) {
            A[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        Arrays.fill(dp, 1);
        dp[0] = 0;

        for(i=1; i<=N; i++) {
            for(int j=i+1; j<=N; j++) {
                if (A[i] < A[j]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
            
            if (MAX < dp[i]) {
                MAX = dp[i];
                index = i;
            }
        }

        // System.out.println(Arrays.toString(dp));
        
        sb.append(MAX + "\n");
        list.add(A[index]);
        
        while(index > 1) {
            index--;
            if (MAX-1 == dp[index]) {
                list.add(A[index]);
                MAX = dp[index];
            }
        }

        Collections.sort(list);
        for(int num : list) {
            sb.append(num + " ");
        }
        System.out.println(sb);

    }

}