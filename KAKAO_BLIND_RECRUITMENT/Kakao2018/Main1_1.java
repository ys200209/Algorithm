import java.util.*;

public class Main1_1 {
    public static void main(String[] args) {

        // System.out.println(Arrays.toString(solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28})));
        // ["#####","# # #", "### #", "# ##", "#####"]

        System.out.println(Arrays.toString(solution(1, new int[]{0}, new int[]{0})));
        // ["#####","# # #", "### #", "# ##", "#####"]

    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] str1 = new String[n];
        String[] str2 = new String[n];

        int[][] map = new int[n][n];

        for(int i=0; i<n; i++) {
            String line1="";
            String line2="";
            int number1 = arr1[i];
            int number2 = arr2[i];


            while(number1 != 0) {
                line1 += number1 % 2;
                number1 /= 2;
            }
            while(number2 != 0) {
                line2 += number2 % 2;
                number2 /= 2;
            }

            str1 = line1.split("");
            str2 = line2.split("");

            for(int j=n-str1.length; j<n; j++) { // 첫 번째 지도 채우기
                if (!str1[n-j-1].equals("")) { // 공백이 아닐 때만.
                    map[i][j] += Integer.parseInt(str1[n-j-1]);
                }
            }

            for(int j=n-str2.length; j<n; j++) { // 두 번째 지도 채우기
                if (!str2[n-j-1].equals("")) {// 공백이 아닐 때만.
                    map[i][j] += Integer.parseInt(str2[n-j-1]);
                }
            }
        }

        for(int i=0; i<n; i++) {
            String ans = "";
            for(int j=0; j<n; j++) {
                if (map[i][j] == 0) ans += " ";
                else ans += "#";
            }
            answer[i] = ans;
        }

        return answer;
    }
    
}