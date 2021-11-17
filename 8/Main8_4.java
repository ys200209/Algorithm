import java.util.*;

public class Main8_4 {
    public static int N;
    public static int[] d;

    public static void main(String[] args) {

        /*
        a1=1, a2=3, a3=5, a4=11,
        */
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        d = new int[100];
        d[0] = 1;
        d[1] = 3;

        for(int i=2; i<N; i++) {
            d[i] = d[i-1]+d[i-2]*2;
        }

        System.out.println(d[N-1]);


    }
    
}
