import java.util.*;

public class Main15_9251 {
    static String[] str1, str2;
    static String[][] dp;
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        str1 = scanner.next().split("");
        str2 = scanner.next().split("");

        dp = new String[str1.length+1][str2.length+1];

        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[i].length; j++) {
                dp[i][j] = "";
            }
        }

        for(int i=1; i<=str1.length; i++) {
            for(int j=1; j<=str2.length; j++) {
                if (str1[i-1].equals(str2[j-1])) {
                    dp[i][j] = dp[i-1][j-1] + str2[j-1];
                } else {
                    dp[i][j] = dp[i-1][j].length() > dp[i][j-1].length() ? dp[i-1][j] : dp[i][j-1];
                }
            }
        }

        for(int i=0; i<=dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

    }
}
