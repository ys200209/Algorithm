import java.util.*;
import java.io.*;

public class Main27_4 {
    static String str1, str2;
    //static int[][] dp;
    static String[][] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str1 = br.readLine();
        str2 = br.readLine();
        //dp = new int[str1.length()+1][str2.length()+1];
        dp = new String[str1.length()+1][str2.length()+1];
        for(int i=0; i<dp.length; i++) {
            Arrays.fill(dp[i], "");
        }
        

        for(int i=1; i<=str1.length(); i++) {
            for(int j=1; j<=str2.length(); j++) {
                if (str1.substring(i-1, i).equals(str2.substring(j-1, j))) {
                    // dp[i][j] = dp[i-1][j-1] + 1;
                    dp[i][j] = dp[i-1][j-1] + str1.substring(i-1, i);
                } else {
                    // dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    dp[i][j] = dp[i-1][j].length() > dp[i][j-1].length() ? dp[i-1][j] : dp[i][j-1];
                }
            }
        }

        /*for(int i=0; i<=str1.length(); i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println("---------------------");
        for(int i=0; i<=str1.length(); i++) {
            System.out.println(Arrays.toString(dp[i]));
        }*/

        sb.append(dp[str1.length()][str2.length()].length() + "\n");
        sb.append(dp[str1.length()][str2.length()]);

        System.out.println(sb);
    }


}