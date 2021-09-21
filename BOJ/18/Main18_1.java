import java.util.*;

class Main18_1 {
    public static int N;
    public static String keyword;
    public static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {

        // 백준 온라인 저지 스택(18)의 1번
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        for(int i=0; i<N; i++) {
            keyword = scanner.next();
            if (keyword.equals("push")) {
                stack.push(scanner.nextInt());
                continue;
            } else if (keyword.equals("pop")) {
                if (!stack.isEmpty()) {
                    System.out.println(stack.pop());
                } else {
                    System.out.println("-1");
                }
                continue;
            } else if (keyword.equals("size")) {
                System.out.println(stack.size());
                continue;
            } else if (keyword.equals("empty")) {
                if (!stack.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println("1");
                }
                continue;
            } else {
                if (!stack.isEmpty()) {
                    System.out.println(stack.peek());
                } else {
                    System.out.println("-1");
                }
                continue;
            }
        }
    }
    
}
