import java.util.*;

public class Main15_15 {
    static int N;
    static int[] A, d;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        A = new int[N+1];
        d = new int[N+1];

        for(int i=1; i<=N; i++) {
            A[i] = scanner.nextInt();
        }

        d[1] = A[1];

        for(int i=1; i<=N; i++) {
            for(int j=i+1; j<=N; j++) {
                d[j] = Math.max(d[j], d[j-1]+A[j]);
            }
        }

        System.out.println("A = " + Arrays.toString(A));
        System.out.println("d = " + Arrays.toString(d));


    }
    
}
