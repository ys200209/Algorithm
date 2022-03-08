import java.util.*;
import java.io.*;
import java.math.*;

public class Main15_11444 {
    static long[] dp;
    
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //BigDecimal N = new BigDecimal(br.readLine());

        long N = Long.parseLong(br.readLine());
        dp = new long[50];
        System.out.println(N);

        dp[0] = 0;
        dp[1] = 1;

        Divide(0, N);

        

        System.out.println(Arrays.toString(dp));

        

    }

    public static void Divide(int start, long size) {
        if (size == 3) {
            fibo(start, size);
            return;
        }

        size /= 3;

        for(int i=0; i<start/size; i++) {
            Divide(start+i, size);
        }

    }

    public static void fibo(int start, long size) {
        dp[start] = dp[start-1] + dp[start-2];
    }

}
