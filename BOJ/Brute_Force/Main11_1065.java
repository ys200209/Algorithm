import java.util.*;

public class Main11_1065 {
    static int N, d, count=0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        if (N < 100) {
            System.out.println(N);
            return;
        }

        count = 99;
        for(int i=100; i<=N; i++) {
            d = (Integer.toString(i).charAt(0) - '0') - (Integer.toString(i).charAt(1) - '0');
            
            if (d == (Integer.toString(i).charAt(1) - '0') - (Integer.toString(i).charAt(2) - '0')) {
                count++;
            }
        }

        System.out.println(count);

    }
    
}