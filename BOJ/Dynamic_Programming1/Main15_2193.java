import java.util.*;

public class Main15_2193 {
    static int N;
    static long[] d;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        d = new long[91];

        d[1] = 1; // 1
        d[2] = 1; // 10
        d[3] = 2;
        d[4] = 3;
        d[5] = 5; // 10000, 10001, 10010, 10100, 10101
        d[6] = 8; // 100000, 100001, 100010, 100100, 101000, 100101, 101001, 101010
        

        for(int i=3; i<=N; i++) {
            d[i] = d[i-2] + d[i-1];
        }

        System.out.println(Arrays.toString(d));
        System.out.println(d[N]);


    }
    
}
