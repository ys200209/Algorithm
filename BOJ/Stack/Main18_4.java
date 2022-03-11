import java.util.*;
import java.io.*;

public class Main18_4 {
    static String S[];
    static Stack<String> stack;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            S = br.readLine().split("");
            stack = new Stack<>();

            if (S[0].equals(".") && S.length == 1) break;

            if (search()) sb.append("yes\n");
            else sb.append("no\n");

        }
        
        System.out.println(sb);
        
    }

    public static boolean search() {
        for(int i=0; i<S.length; i++) {
            if (S[i].equals("(") || S[i].equals("[")) stack.push(S[i]);
            else if (S[i].equals(")") || S[i].equals("]")) {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (S[i].equals(")") && !stack.peek().equals("(")) {
                        return false;
                    } else if (S[i].equals("]") && !stack.peek().equals("[")) {
                        return false;
                    } else {
                        stack.pop();
                    }
                }
            }
        }

        if (stack.isEmpty()) return true;
        else return false;
    }

}