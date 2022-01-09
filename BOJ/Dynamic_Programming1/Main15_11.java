import java.util.*;

public class Main15_11 {
    static int N, result=1;
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

        for(int i=1; i<=N; i++) {
            for(int j=i-1; j>0; j--) {
                if (A[i] > A[j] && d[i] < d[j] + 1) {
                    d[i] = d[j] + 1;
                    result = Math.max(result, d[i]);
                }
            }
        }

        System.out.println(Arrays.toString(d));

        System.out.println(result);

    }

    /*public static int TopDown(int index) {
        if (index == 1) return d[index];

        if (d[index] == 1) {
            d[index] = 
        }
        
        return d[index];
    }*/


}