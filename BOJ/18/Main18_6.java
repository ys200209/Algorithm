import java.util.*;

class Main18_6 {
    public static int N;
    public static int[] A;
    public static Stack<Integer> stack = new Stack<>(); // 실제 스택
    public static Stack<Integer> stack_A = new Stack<>(); // 수열 A를 담은 스택
    public static Stack<Integer> stack_B = new Stack<>(); // 임시 저장소
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        // 백준 온라인 저지 스택(18)의 6번

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        A = new int[N];

        for(int i=0; i<N; i++) {
            A[i] = scanner.nextInt(); // 수열 A = [3, 5, 2, 7]
        }

        for(int i=N-1; i>=0; i--) {
            stack_A.push(A[i]); // 수열을 스택 구조로 뒤에서부터 삽입
        }

        boolean push_check = false;
        for(int i=0; i<N; i++) {
            stack.push(stack_A.pop());
            while(!stack_A.isEmpty()) {
                if (stack.peek() < stack_A.peek()) {
                    sb.append(stack_A.peek() + " ");
                    
                    push_check = true;
                    break;
                } else {
                    stack_B.push(stack_A.pop());
                }
            }

            if (!push_check) {
                sb.append("-1 ");
            }
            push_check = false;

            while(!stack_B.isEmpty()) {
                stack_A.push(stack_B.pop());
            }


        }

        System.out.println(sb);

    }

}
