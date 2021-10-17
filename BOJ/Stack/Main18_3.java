import java.util.*;

class Main18_3 {
    public static int T, result;
    public static String[] str;
    public static Stack<String> stack = new Stack<>();

    public static void main(String[] args) {

        // 백준 온라인 저지 스택(18)의 3번

        Scanner scanner = new Scanner(System.in);

        T = scanner.nextInt();

        for(int i=0; i<T; i++) {
            result = 0;
            stack.clear();
            str = scanner.next().split("");
            if (str.length % 2 != 0) {
                System.out.println("NO");
                continue;
            }
            
            boolean check = false;
            for(int j=0; j<str.length; j++) {
                stack.push(str[j]);
                if(stack.peek().equals("(")) {
                    result += 1;
                } else {
                    result -= 1;
                }

                if (result < 0) {
                    System.out.println("NO");
                    check = true;
                    break;
                }
            }
            
            if(!check) {
                if (result == 0) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
            check = false;
        }
    }
    
}
