import java.util.*;

public class Main11_2 {
    public static int N, result=0;
    public static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        result = BFS();
        
        System.out.println("result : " + result);
    }

    public static int BFS() {
        queue.offer(1);

        while(!queue.isEmpty()) {
            int result = queue.poll();

            if (result >= N) return 0;

            String str = Integer.toString(result);
            int n=0;

            for(int i=0; i<str.length(); i++) {
                n += str.charAt(i)-'0';
            }

            if (N == result+n) return result;

            queue.offer(result+1);
        }

        return 0;
    }
    
}
