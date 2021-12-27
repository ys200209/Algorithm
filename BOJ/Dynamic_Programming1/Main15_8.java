import java.util.*;

public class Main15_8 {
    public static int X;
    public static int[] d;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        X = scanner.nextInt();
        d = new int[X+1];

        d[1] = 0;

        for(int i=2; i<=X; i++) {
            if (d[i] == 0) {
                d[i] = d[i-1] + 1;

                if (i % 2 == 0) {
                    d[i] = Math.min(d[i], d[i/2] + 1);
                }

                if (i % 3 == 0) {
                    d[i] = Math.min(d[i], d[i/3]+1);
                }
            }
            
        }

        System.out.println(d[X]);


    }
    
}
