
import java.util.*;

public class Programmers {
    static Stack<String> stack = new Stack<>();
    static String u="", v="", answer="";

    public static void main(String[] args) {
//        System.out.println(solution("(()())()")); // "(()())()"
//        System.out.println(solution(")(")); // "()"
        System.out.println(solution("()))((()"	)); // "()(())()"
    }

    public static String solution(String p) {
        answer += step1(p); // Step.1
        return answer;
    }

    private static String step1(String p) {
        if (p.isEmpty()) return p;
        else return step2(p); // Step.2
    }

    private static String step2(String p) {
        String[] split = p.split("");
        int left=0, right=0;

        for(int i=0; i<split.length; i++) {
            if (split[i].equals("(")) left++;
            else right++;

            if (left == right) {
                u = p.substring(0, i+1);
                v = p.substring(i+1, split.length);
                break;
            }
        }

        // u가 올바른 괄호 문자열이라면
        if (step3(u)) return u + step1(v); // u를 반환 (answer에 더함) + 다시 v를 1단계부터 실행함
        else return step4(u, v); // 아니라면 4단계로 진행함
    }

    private static boolean step3(String u) {
        stack.clear();

        for (String s : u.split("")) {
            if (s.equals("(")) stack.push(u);
            else {
                if (stack.isEmpty()) return false;
                else if (stack.peek().equals("(")) stack.pop();
            }
        }
        return true;
    }

    private static String step4(String u, String v) {
        String newAnswer = "("; // 4-1
        newAnswer += step1(v); // 4-2
        newAnswer += ")"; // 4-3

        if (u.length() <= 2) return newAnswer; // 4-5

        for (String s : u.substring(1, u.length() - 1).split("")) { // 4-4
            if (s.equals("(")) newAnswer += ")";
            else newAnswer += "(";
        }
        return newAnswer; // 4-5
    }


}
