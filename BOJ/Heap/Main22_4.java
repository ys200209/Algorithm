import java.util.*;

public class Main22_4 {
    public static Queue<Integer> frontQueue = new PriorityQueue<>(Collections.reverseOrder());
    public static Queue<Integer> backQueue = new PriorityQueue<>();
    public static int N, x, mid=(int)1e9;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) {

        // ���� �¶��� ���� �켱���� ť(22)�� 4��
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        for(int i=0; i<N; i++) {
            x = scanner.nextInt();

            if (mid > x) {
                if (frontQueue.size() - backQueue.size() == 1) backQueue.offer(frontQueue.poll());

                if (!frontQueue.isEmpty() && frontQueue.peek() > x) backQueue.offer(frontQueue.poll());

                frontQueue.offer(x);
            } else { // ���������� ũ�ų� ���� ���̶�� backQueue�� ����
                backQueue.offer(x);
                if (backQueue.size() - frontQueue.size() >= 1) {
                    frontQueue.offer(backQueue.poll());
                }
            }

            mid = x;

            sb.append(frontQueue.peek() + "\n");

            System.out.println("front.size() : " + frontQueue.size() + ", back.size() : " + backQueue.size());

        }

        System.out.println("---------[result]---------");
        System.out.println(sb);

    }
}