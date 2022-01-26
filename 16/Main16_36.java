import java.util.*;

public class Main16_36 {
    static String[] A, B;
    static int[] d;

    public static void main(String[] args) {

        // 16:48
        Scanner scanner = new Scanner(System.in);
        A = scanner.next().split("");
        B = scanner.next().split("");

        d = new int[B.length];
        Arrays.fill(d, 1);

        for(int i=0; i<A.length; i++) {
            for(int j=0; j<B.length; j++) {
                if (A[i].equals(B[j])) {
                    d[i] = 0;
                }
            }
        }

        System.out.println(Arrays.toString(d));

    }
    
}