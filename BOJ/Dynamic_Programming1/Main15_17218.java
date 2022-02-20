import java.util.*;
import java.io.*;

public class Main15_17218 {
    static String s1, s2;
    static String[][] dp;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s1 = br.readLine();
        s2 = br.readLine();
        dp = new String[s1.length()+1][s2.length()+1];

        for(int i=0; i<dp.length; i++) {
            Arrays.fill(dp[i], "");
        }

        for(int i=1; i<=s1.length(); i++) {
            for(int j=1; j<=s2.length(); j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + s1.substring(i-1, i);
                } else {
                    dp[i][j] = dp[i-1][j].length() > dp[i][j-1].length() ? dp[i-1][j] : dp[i][j-1];
                }
            }
        }

        for(int i=0; i<dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        


    }


}