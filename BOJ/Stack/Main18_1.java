import java.util.*;

class Main18_1 {
    public static int N;
    public static String keyword;
    public static Stack<Integer> stack = new Stack<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        // 백준 온라인 저지 스택(18)의 1번
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        for(int i=0; i<N; i++) {
            keyword = scanner.next();
            switch(keyword) {
                case "push":
                    stack.push(scanner.nextInt());
                    break;

                case "pop":
                    if (!stack.isEmpty()) {
                        sb.append(stack.pop()+"\n");
                    } else {
                        sb.append("-1\n");
                    }
                    break;

                case "size":
                    sb.append(stack.size()+"\n");
                    break;

                case "empty":
                    if (!stack.isEmpty()) {
                        sb.append("0\n");
                    } else {
                        sb.append("1\n");
                    }
                    break;

                case "top":
                    if (!stack.isEmpty()) {
                        sb.append(stack.peek()+"\n");
                    } else {
                        sb.append("-1\n");
                    }
                    break;
            }
        }
    }
    
}
