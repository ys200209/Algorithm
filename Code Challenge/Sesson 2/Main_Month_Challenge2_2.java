import java.util.*;

class Main_Month_Challenge2_2 {
    
    public static void main(String[] args) {

        System.out.println(solution(13, 17)); // 43

    }

    public static int solution(int left, int right) {
        int answer = 0;

        for(int i=left; i<=right; i++) {
            if (i == 1) {
                answer -= 1;
                continue;
            }

            int count = 2; // 1引 切奄 切重

            for(int j=2; j<i; j++) {
                if (i % j == 0) count++;
            }

            if (count % 2 == 0) answer += i;
            else answer -= i;
        }


        return answer;
    }

}