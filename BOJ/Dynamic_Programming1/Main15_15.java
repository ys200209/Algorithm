import java.util.*;

public class Main15_15 {
    static int N, result = -1000 * 100000;
    static int[] A;
    static Integer[] d;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        A = new int[N+1];
        d = new Integer[N+1];

        for(int i=1; i<=N; i++) {
            A[i] = scanner.nextInt();
        }

        TopDown(N);

        System.out.println(result);

    }

    public static int TopDown(int index) {
        if (index == 0) return 0;
        if (d[index] == null) {
            d[index] = Math.max(TopDown(index-1) + A[index], A[index]);
            result = Math.max(result, d[index]);
            return d[index];
        }
        return A[index];
    }
    
}
