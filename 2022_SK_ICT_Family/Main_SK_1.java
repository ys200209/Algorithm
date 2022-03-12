import java.util.*;
import java.io.*;

public class Main_SK_1 {
    
    
    public static void main(String[] args) throws IOException {

        System.out.println(solution(4578, new int[]{1, 4, 99, 35, 50, 1000})); // 2308

    }

    public static int solution(int money, int[] costs) {
        int answer = 0;

        int[] arr = new int[]{1, 5, 10, 50, 100, 500};

        while(money != 0) {
            
            for(int i=5; i>=0; i--) {
                int MIN = (int)1e9;
                if (money >= arr[i]) {
                    int A = (money / arr[i] * arr[i]);
                    for(int j=0; j<=i; j++) {
                        MIN = Math.min(MIN, A / arr[j] * costs[j]);
                    }
                    money %= arr[i];
                    answer += MIN;
                }
            }
        }

        return answer;
    }

}
