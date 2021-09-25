import java.util.*;

class Main19_1 {
    public static int N;
    public static String command;
    public static LinkedList<Integer> queue = new LinkedList<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        // 백준 온라인 저지 큐, 덱(19)의 1번

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        for(int i=0; i<N; i++) {
            command = scanner.next();

            if (command.equals("push")) {
                queue.offer(scanner.nextInt());
                continue;
            } else if (command.equals("pop")) {
                if (queue.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(queue.poll()+"\n");
                }
                continue;
            } else if (command.equals("size")) {
                sb.append(queue.size() + "\n");
                continue;
            } else if (command.equals("empty")) {
                if (queue.isEmpty()) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
                continue;
            } else if (command.equals("front")) {
                if (queue.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(queue.peek()+"\n");
                }
                continue;
            } else { // back
                if (queue.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(queue.peekLast()+"\n");
                }
                continue;
            }
        }

        System.out.println(sb);

    }
    
}
