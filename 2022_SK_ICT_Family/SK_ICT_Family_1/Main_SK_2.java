import java.util.*;
import java.io.*;

public class Main_SK_2 {
    
    
    public static void main(String[] args) throws IOException {

        //System.out.println(solution(5, true));
        //System.out.println(solution(6, false));
        // System.out.println(solution(10, true));
        System.out.println(solution(19, true));

    }

    public static int[][] solution(int n, boolean clockwise) {
        int[][] answer = new int[n][n];
        int number = 1;

        if (clockwise) { // 시계 방향
            int count=0;
            while(answer[n/2][n/2] == 0) {
                count++;

                answer[count-1][count-1] = number;
                for(int i=count-1; i<n-count; i++) {
                    answer[count-1][i] = number;
                    answer[i][n-count] = number;
                    answer[n-count][n-i-1] = number;
                    answer[n-i-1][count-1] = number;
                    
                    number++;
                }
            }
        } else {
            int count=0;
            while(answer[n/2][n/2] == 0 && count != 50) {
                count++;

                answer[count-1][count-1] = number;
                for(int i=count-1; i<n-count; i++) {
                    answer[i][count-1] = number;
                    answer[n-count][i] = number;
                    answer[n-i-1][n-count] = number;
                    answer[count-1][n-i-1] = number;
                    
                    number++;
                }
            }
        }

        for(int i=0; i<n; i++) {
            System.out.println(Arrays.toString(answer[i]));
        }

        return answer;
    }

}
