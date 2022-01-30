import java.util.*;

public class Main16_1789 {
    static long N, S;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        S = scanner.nextLong();
        long sum = 0;
        N = 0;
        while(sum <= S) {
            N++;
            sum += N;
        }

        System.out.println(N-1);

    }
    
}