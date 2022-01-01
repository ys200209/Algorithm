import java.util.*;

public class Main15_11 {
    static int N, result;
    static int[] A, d;
 
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        A = new int[N+1];
        d = new int[N+1];

        for(int i=1; i<=N; i++) {
            A[i] = scanner.nextInt();
            d[i] = 1;
        }
        

        if (N == 1) {
            System.out.println("1");
            return;
        }

        for(int i=1; i<=N; i++) {
            for(int j=i+1; j<=N; j++) {
                if (A[i] < A[j] && d[j] < d[i]+1) {
                    d[j] = d[i]+1;
                } 
            }

        }

        System.out.println(Arrays.toString(d));

    }

}