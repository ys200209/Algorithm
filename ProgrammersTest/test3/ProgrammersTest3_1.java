import java.util.*;

class ProgrammersTest3_1 {
    static int answer;

    public static void main(String[] args) {

        System.out.println(solution(2, 1, 20)); // 19
        // System.out.println(solution(3, 1, 20)); // 9

    }
    
    public static int solution(int a, int b, int n) {
        int answer = 0;

        while(n >= a) {
            int x = n / a; // 18
            int y = x * b; // 6

            n = n - (x*a) + y;
            answer += y;
        }


        return answer;
    }
    
}