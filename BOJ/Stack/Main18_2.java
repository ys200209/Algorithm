import java.util.*;

class Main18_2 {
    public static int K, N, result = 0;
    public static Stack<Integer> stack = new Stack<>();
    
    public static void main(String[] args) {

        // 백준 온라인 저지 스택(18)의 2번
        Scanner scanner = new Scanner(System.in);

        K = scanner.nextInt();

        for(int i=0; i<K; i++) {
            N = scanner.nextInt();
            if (N != 0) {
                stack.push(N);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }

        while(!stack.isEmpty()) {
            result += stack.pop();
        }

        System.out.println("result = " + result);
    }

}
