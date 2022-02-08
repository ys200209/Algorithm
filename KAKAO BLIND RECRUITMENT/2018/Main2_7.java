import java.util.*;

public class Main2_7 {

    public static void main(String[] args) {

        // System.out.println(solution(2, 4, 2, 1)); // "0111"
        System.out.println(solution(16, 16, 2, 1)); // "02468ACE11111111"
        // System.out.println(solution(16, 16, 2, 2)); // "13579BDF01234567"

    }

    public static String solution(int n, int t, int m, int p) {
        String answer = "";
        System.out.println("--------------------------------");
        int now = 1;
        int number = 0;
        String str;
        
        while(answer.length() < t) {
            str = "";
            int num = number;
            if (num == 0) {
                str = "0";
                System.out.println("number : " + number + ", str : " + str + ", now : " + now);
                now = (now + str.length()-1) % m + 1;
                number++;
                answer += "0";
                continue;
            }
            else {
                while(num != 0) {
                    str += num % n;
                    num /= n;
                }
            }

            System.out.println("number : " + number + ", str : " + str + ", now : " + now);

            if (now + str.length() < p + m) { // 각 사람이 문자를 하나씩 말해도 아직도 자기 차례가 아니라면
                // System.out.println("true");
                now = (now + str.length()-1) % m + 1;
            } else { 
                int temp = p + m - now > m ? (p+m-now)%m : (p+m-now);
                answer += str.substring(temp-1, temp);
                now = (now + str.length()-1) % m + 1;
                // System.out.println("answer : " + answer);
            }
            number++;
        }

        
        return answer;
    }
    
}
