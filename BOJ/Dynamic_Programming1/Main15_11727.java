import java.util.*;

public class Main15_11727 {
    static int N;
    static int[] d;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        d = new int[1001];

        d[1] = 1;
        d[2] = 3;

        for(int i=3; i<=N; i++) {
            d[i] = (d[i-2]*2 + d[i-1]) % 10007;
        }

        System.out.println(d[N]);
    }
}
