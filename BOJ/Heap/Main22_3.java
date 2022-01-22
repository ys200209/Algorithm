import java.util.*;

public class Main22_3 {
    static int N, x;
    static Queue<Integer> plusQueue = new PriorityQueue<>();
    static Queue<Integer> minusQueue = new PriorityQueue<>(Collections.reverseOrder());
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        for(int i=0; i<N; i++) {
            x = scanner.nextInt();

            if (x < 0) {
                minusQueue.offer(x);
            } else if (x > 0) {
                plusQueue.offer(x);
            } else {
                if (minusQueue.isEmpty() && plusQueue.isEmpty()) {
                    sb.append("0\n");
                } else if (minusQueue.isEmpty() && !plusQueue.isEmpty()) {
                    sb.append(plusQueue.poll() + "\n");
                } else if (!minusQueue.isEmpty() && plusQueue.isEmpty()) {
                    sb.append(minusQueue.poll() + "\n");
                } else {
                    if ((minusQueue.peek()*-1) < plusQueue.peek() || (minusQueue.peek()*-1) == plusQueue.peek()) {
                        sb.append(minusQueue.poll() + "\n");
                    } else if ((minusQueue.peek()*-1) > plusQueue.peek()) {
                        sb.append(plusQueue.poll() + "\n");
                    }
                }
            }
        }

        // System.out.println("----------[result]----------");
        System.out.println(sb);

    }
    
}