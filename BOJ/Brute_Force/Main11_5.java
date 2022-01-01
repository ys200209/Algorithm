import java.util.*;

public class Main11_5 {
    public static int N, len=1;
    public static Queue<Integer> queue = new PriorityQueue<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        int number = 1;
        String[] term;

        if (N == 0) {
            System.out.println("666");
            return;
        }

        // 0 : 666
        /*
            1666 - 2666 - 3666 - 4666 - 5666 - 6660
            6661 - 6662 - 6663 - 6664 - 6665 - 6666
            6667 - 6668 - 6669 - 7666 - 8666 - 9666
        */

        queue.offer(6660);
        for(int i=1; i<=N; i++) {
            term = Integer.toString(i);
            
            // 10 : 10666 - 11666 - 12666- 13666 - 14666
            // 15666 - 16660
            // 10 : 16660
            
            for(int j=)
        }


    }
    
}
