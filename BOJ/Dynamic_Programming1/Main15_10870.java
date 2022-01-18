import java.util.*;

public class Main15_10870 {
    static int N;
    static int[] d;
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        d = new int[21];

        d[0] = 0;
        d[1] = 1;

        for(int i=2; i<21; i++) {
            d[i] = d[i-2] + d[i-1];
        }

        System.out.println(d[N]);

    }
}
