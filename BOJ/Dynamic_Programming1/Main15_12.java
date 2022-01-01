import java.util.*;

public class Main15_12 {
    public static int N, result=0;
    public static int[] A, inc_d, dec_d;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        A = new int[N+1];
        inc_d = new int[N+1];
        dec_d = new int[N+1];

        for(int i=1; i<=N; i++) {
            A[i] = scanner.nextInt();
            inc_d[i] = 1;
            dec_d[i] = 1;
        }

        if (N == 1) {
            System.out.println("1");
            return;
        }
        
        for(int i=1; i<=N; i++) {
            for(int j=i+1; j<=N; j++) {
                if (A[i] < A[j] && inc_d[j] < inc_d[i]+1) {
                    inc_d[j] = inc_d[i]+1;
                } else if (A[i] > A[j]) {
                    
                }
            }
        }
        
        //for(int i=N; i>=1; i++) {
            
        //}

        for(int j=N-1; j>=1; j--) {
            if (A[j] > A[j+1] && dec_d[j] < dec_d[j+1] + 1) {
                dec_d[j] = dec_d[j+1] + 1;
            }
        }

        for(int i=2; i<=N; i++) {
            if (A[i-1] > A[i]) {
                result = Math.max(result, inc_d[i-1] + dec_d[i]);
            } 
        }

        System.out.println("inc_d = " + Arrays.toString(inc_d));
        System.out.println("dec_d = " + Arrays.toString(dec_d));

        System.out.println(result);

    }
    
}