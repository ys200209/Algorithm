import java.util.*;

class Main18_5 {
    public static int N, number, count=1, pop_count;
    public static Stack<Integer> stack = new Stack<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        // 백준 온라인 저지 스택(18)의 5번

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        stack.push(1);
        sb.append("+\n");

        for(int i=1; i<=N; i++) {
            number = scanner.nextInt();

            for(int j=count+1; j<=number; j++) {
                stack.push(j);
                count += 1;
                sb.append("+\n");
                continue;
            }
            
            pop_count = number;
            while(!stack.isEmpty() && stack.peek() >= number) {
                if (pop_count == stack.peek()) {
                    stack.pop();
                } else {
                    System.out.println("NO");
                    return;
                }
                pop_count -= 1;
                sb.append("-\n");
            }

        }

        System.out.println(sb);

    }
    
}