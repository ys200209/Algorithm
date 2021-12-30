import java.util.*;

class Main11_3 {
    static int answer = (int)1e9;
    static String S, str;

    public static void main(String[] args) {

        /*
            0과 1로만 이루어진 문자열 S가 있다. 이 문자열 S에 있는 모든 숫자를 전부 같게 만들려고 할 때,
            연속된 하나 이상의 숫자를 잡고 모두 뒤집는 것이다. 뒤집는 것은 1을 0으로, 0을 1로 바꾸는 것을 의미한다.
            ex) s = 0001100에서 0을 1로 뒤집으려면 1111100 으로 한번, 1111111로 두번 뒤집으면 된다.
            그러나 처음부터 0000000으로 한번만에 뒤집을 수도 있다.
            최소 횟수를 출력하시오.

        */

        Scanner scanner = new Scanner(System.in);

        S = scanner.nextLine();

        zeroToOne();
        oneToZero();

        System.out.println(answer);

    }

    public static void zeroToOne() {
        int result = 0;
        for(int i=1; i<S.length(); i++) {
            if (S.charAt(i-1) == S.charAt(i)) continue;
            else if (S.charAt(i-1)-'0' == 0 && S.charAt(i)-'0' == 1) {
                result += 1;
            }
        }

        if (S.charAt(S.length()-1) == 0) result += 1; 

        answer = Math.min(answer, result);
    }

    public static void oneToZero() {
        int result = 0;
        for(int i=1; i<S.length(); i++) {
            if (S.charAt(i-1) == S.charAt(i)) continue;
            else if ((S.charAt(i-1)-'0' == 1) && S.charAt(i)-'0' == 0) {
                result += 1;
            }
        }

        if (S.charAt(S.length()-1) == 1) result += 1; 

        answer = Math.min(answer, result);
    }

}
