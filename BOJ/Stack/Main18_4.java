import java.util.*;

public class Main18_4 {
    public static String result = "YES";
    public static String[] S;
    public static Stack<String> stack = new Stack<>();
    
    public static void main(String[] args) {

        // 백준 온라인 저지 스택(18)의 4번
        Scanner scanner = new Scanner(System.in);

        stack.clear();
        S = scanner.nextLine().split("");

        for(int i=0; i<S.length; i++) {
                if (S[i].equals(".")) {
                    break;
                }
                if (S[i].equals("(") || S[i].equals("[")) {
                    stack.push(S[i]);
                }
                if (S[i].equals(")")) {
                    if (!stack.isEmpty()) {
                        if (stack.peek().equals("(")) {
                            stack.pop();
                        } else {
                            result = "NO";
                            break;
                        }
                    } else {
                        result = "NO";
                        break;
                    }
                } else if (S[i].equals("]")) {
                    if (!stack.isEmpty()) {
                        if (stack.peek().equals("[")) {
                            stack.pop();
                        } else {
                            result = "NO";
                            break;
                        }
                    } else {
                        result = "NO";
                        break;
                    }
                }
            }
    
            System.out.println(result);
        
    }

}
