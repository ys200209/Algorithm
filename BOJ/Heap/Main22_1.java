import java.util.*;

public class Main22_1 {
    public static Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
    public static StringBuilder sb = new StringBuilder();
    public static int N, x;

    public static void main(String[] args) {

        // 백준 온라인 저지 우선순위 큐(22)의 1번
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        for(int i=0; i<N; i++) {
            x = scanner.nextInt();
            if (x == 0) {
                if (queue.isEmpty()) {
                    sb.append("0\n");
                } else {
                    sb.append(queue.poll()+"\n");
                }
            } else {
                queue.offer(x);
            }
        }

        System.out.println(sb);

    }
    
}