package BOJ.Brute_Force;

import java.io.IOException;
import java.util.*;

public class Main11_17825 {
    static int N, answer = 0;
    static Stack stack = new Stack();

    public static void main(String[] args) throws IOException {
        System.out.println(solution("[](){}")); // 3
//        System.out.println(solution("}]()[{")); // 2
    }

    public static int solution(String s) {
        String[] split = s.split("");
        N = split.length;
//        System.out.println("N = " + N);
//        if (checkString(split, 0)) answer++;

        for(int i=0; i<N; i++) {
            if (checkString(split, i)) answer++;
        }

        return answer;
    }

    private static boolean checkString(String[] split, int start) {
//        System.out.println("---------------");
        stack.clear();
        int index;

        for(int i=start; i<N+start; i++) {
            index = i >= N ? i-N : i;
//            System.out.println("index = " + index);
            if (split[index].equals("(") || split[index].equals("{") || split[index].equals("[")) stack.push(split[index]);
            else {
                if (!stack.isEmpty() && split[index].equals("}") && stack.peek().equals("{")) stack.pop();
                else if (!stack.isEmpty() && split[index].equals("]") && stack.peek().equals("[")) stack.pop();
                else if (!stack.isEmpty() && split[index].equals(")") && stack.peek().equals("(")) stack.pop();
                else return false;
            }
        }

        if (stack.isEmpty()) return true;
        else return false;
    }

}