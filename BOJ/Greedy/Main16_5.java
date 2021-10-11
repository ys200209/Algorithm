import java.util.*;

class Main16_5 {
    public static int N;
    public static long load_sum=0;
    public static Queue<Integer> load_queue = new LinkedList<>();
    public static Queue<Integer> price_queue = new LinkedList<>();
    public static PriorityQueue<Long> result = new PriorityQueue<>();

    public static void main(String[] args) {

        // 백준 온라인 저지 Greedy(16)의 5번
        
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        for(int i=0; i<N-1; i++) { // load
            load_queue.offer(scanner.nextInt());
            load_sum += load_queue.peek();
        }

        for(int i=0; i<N; i++) { // oil_price
            price_queue.offer(scanner.nextInt());
        }

        

        System.out.println(BFS());

    }

    public static long BFS() {

        result.offer((long)(price_queue.peek() * load_queue.peek()));

        while(load_queue.size() != 1) {
            
            //   [2, 3, 1]
            // [5, 2, 4, 1]
            long now = result.poll();

            long price = price_queue.poll();

            long front = now;
            
            // now = price * load_queue.peek();
            load_sum -= load_queue.peek();

            long back = now + (price_queue.peek() * load_sum);

            System.out.println("front : " + front);
            System.out.println("back : " + back);

            if (front >= back) {
                result.offer(now + price_queue.peek() * load_queue.poll());
                System.out.println("result.offer");
                continue;
            }

            return front;
        }

        return result.poll();

    }
}