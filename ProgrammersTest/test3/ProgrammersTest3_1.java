import java.util.*;

class ProgrammersTest3_1 {

    public static void main(String[] args) {

        System.out.println(solution(2, 1, 20)); // 19

    }
    
    public static int solution(int a, int b, int n) {
        int answer = 0;

        while(n / a > 0) {
            int x = n / a;
            int y = x * b;
            answer += y;
            n %= a;
            n += y;
        }

        return answer;
    }
    
}