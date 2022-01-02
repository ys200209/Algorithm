import java.util.*;

class Main12_8 {
    static int sum=0;
    static String S;
    static Queue<String> queue = new PriorityQueue<>();
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        S = scanner.next();

        for(int i=0; i<S.length(); i++) {
            if (S.charAt(i) - '0' <= 9) {
                sum += S.charAt(i) - '0';
            } else {
                queue.offer(S.substring(i, i+1));
            }
        }
        
        while(!queue.isEmpty()) {
            System.out.print(queue.poll());
        }

        System.out.println(sum);

    }

}