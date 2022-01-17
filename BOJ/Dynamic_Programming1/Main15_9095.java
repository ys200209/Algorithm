import java.util.*;

public class Main15_9095 {
    static int T, N;
    static int[] d;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        T = scanner.nextInt();
        
        d = new int[11];

        d[1] = 1;
        d[2] = 2;
        d[3] = 4;

        for(int i=4; i<11; i++) {
            d[i] = d[i-3] + d[i-2] + d[i-1];
        }

        for(int i=0; i<T; i++) {
            N = scanner.nextInt();
            System.out.println(d[N]);
        }
        
    }
    
}
