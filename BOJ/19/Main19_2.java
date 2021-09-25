import java.util.*;

class Main19_2 {
    public static int N, result;
    public static Deque<Integer> dq = new ArrayDeque<>();
    
    public static void main(String[] args) {

        // 백준 온라인 저지 큐, 덱(19)의 2번

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        for(int i=N; i>0; i--) {
            dq.offer(i);
        }

        while(dq.size() != 1) {
            dq.removeLast();
            dq.offerFirst(dq.pollLast());
        }

        System.out.println(dq.poll());

    }

}
