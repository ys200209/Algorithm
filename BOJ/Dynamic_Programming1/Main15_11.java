import java.util.*;

public class Main15_11 {
    public static int N, result=1;
    public static int[] A, d;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        A = new int[N+1];
        d = new int[N+1];

        d[1] = 1;

        for(int i=1; i<=N; i++) {
            A[i] = scanner.nextInt();
        }

        for(int i=2; i<=N; i++) {
            for(int j=i-1; j>=1; j--) {
                if (A[j] < A[i]) {
                    d[i] = Math.max(d[i], d[j] + 1);
                }
            }
            if (d[i] == 0 ) {
                d[i] = 1;
            }
            result = Math.max(result, d[i]);
        }

        System.out.println(Arrays.toString(d));
        System.out.println(result);

    }
    
}