import java.util.*;

public class Main15_10 {
    public static int N, result;
    public static int[] list, d;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        list = new int[N+1];
        d = new int[N+1];

        for(int i=1; i<=N; i++) {
            list[i] = scanner.nextInt();
        }

        d[1] = list[1];
        if (N > 1) {
            d[2] = list[1] + list[2];
        }

        for(int i=3; i<=N; i++) {
            d[i] = Math.max((Math.max(d[i-3] + list[i-1], d[i-2]) + list[i]), d[i-1]);
        }

        // System.out.println("list = " + Arrays.toString(list));

        // System.out.println("d = " + Arrays.toString(d));

        result = d[0];
        for(int i=1; i<=N; i++) {
            result = Math.max(result, d[i]);
        }

        System.out.println(result);

    }
    
}
