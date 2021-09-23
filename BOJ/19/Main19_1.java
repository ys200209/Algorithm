import java.util.*;

class Main19_1 {
    public static int N, last;
    public static String command;
    public static Queue<Integer> queue = new LinkedList<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        // 백준 온라인 저지 큐, 덱(19)의 1번

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        for(int i=0; i<N; i++) {
            command = scanner.next();

            switch(command) {
                case "push":
                    last = scanner.nextInt();
                    queue.offer(last);
                    break;

                case "pop":
                    if (queue.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(queue.poll()+"\n");
                    }
                    break;

                case "size":
                    sb.append(queue.size() + "\n");
                    break;
                
                case "empty":
                    if (queue.isEmpty()) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                    break;

                case "front":
                    if (queue.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(queue.peek()+"\n");
                    }
                    break;

                case "back":
                    if (queue.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(last+"\n");
                    }
                    break;
            }
        }

        System.out.println(sb);

    }
    
}
