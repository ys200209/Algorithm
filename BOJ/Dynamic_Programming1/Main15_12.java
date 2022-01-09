import java.util.*;

public class Main15_12 {
    static int N, result=0;
    static int[] A, inc_d, dec_d;
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        A = new int[N+1];
        inc_d = new int[N+1];
        dec_d = new int[N+1];

        for(int i=1; i<=N; i++) {
            A[i] = scanner.nextInt();
        }

        inc_d[1] = 1;
        dec_d[N] = 1;
        
        for(int i=2; i<=N; i++) {
            increaseTopDown(i);
        }

        for(int i=N-1; i>=1; i--) {
            decreaseTopDown(i);
        }
        
        for(int i=1; i<=N; i++) {
            result = Math.max(result, inc_d[i] + dec_d[i]);
        }


        // System.out.println("inc : " + Arrays.toString(inc_d));
        // System.out.println("dec : " + Arrays.toString(dec_d));

        System.out.println(result-1);
    }

    public static int increaseTopDown(int index) {
        if (index == 1) return 1;

        if (inc_d[index] == 0) {
            for(int i=index - 1; i>0; i--) {
                if (A[i] < A[index]) {
                    inc_d[index] = Math.max(inc_d[index], increaseTopDown(i) + 1);
                } 
            }
            if (inc_d[index] == 0) inc_d[index] = 1;
        }

        return inc_d[index];
    }

    public static int decreaseTopDown(int index) {
        if (index == N) return 1;

        if (dec_d[index] == 0) {
            for(int i=index+1; i<=N; i++) {
                if (A[index] > A[i]) {
                    dec_d[index] = Math.max(dec_d[index], dec_d[i]+1);
                }
            }
            if (dec_d[index] == 0) dec_d[index] = 1;
        }

        return dec_d[index];
    }

}