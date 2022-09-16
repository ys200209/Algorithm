package BOJ.Brute_Force;

import java.io.*;
import java.util.Stack;

public class Main11_1062 {
    static Stack<String> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
//        System.out.println(solution("baabaa")); // 1
        System.out.println(solution("cdcd")); // 1
//        System.out.println(solution(new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}})); // 120

    }

    public static int solution(String s) {
        String[] split = s.split("");

        for(int i=1; i< split.length; i++) {
            if (stack.isEmpty()) {
                stack.push(split[i]);
            } else {
                if (stack.peek().equals(split[i])) stack.pop();
                else stack.push(split[i]);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }

    private static boolean isRemove() {
        boolean isRemove = false;



        return isRemove;
    }

}