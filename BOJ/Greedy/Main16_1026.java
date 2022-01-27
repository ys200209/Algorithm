import java.util.*;

public class Main16_1026 {
    static int N, result=0;
    static int[] A, B;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        A = new int[N];
        B = new int[N];

        for(int i=0; i<N; i++) {
            A[i] = scanner.nextInt();
        }
        for(int i=0; i<N; i++) {
            B[i] = scanner.nextInt();
        }

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0; i<N; i++) {
            result += A[i] * B[N-i-1];
        }

        System.out.println(result);

    }
    
}