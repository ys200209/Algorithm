import java.util.*;

public class Main15_4 {
    public static int T;
    public static long[] d = new long[101];
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();

        d[1] = 1;
        d[2] = 1;
        d[3] = 1;
        d[4] = 2;
        d[5] = 2;

        /*
            d[6] = d[5] + d[1] = 3;
            d[7] = d[6] + d[2] = 4;
            d[8] = d[7] + d[3] = 5;
            d[9] = d[8] + d[4] = 7;
            d[10] = d[9] + d[5] = 9;
            d[11] = d[10] + d[6] = 12;
        */

        for(int i=0; i<T; i++) {
            int number = scanner.nextInt();

            for(int j=5; j<=number; j++) {
                if (d[j] == 0) {
                    d[j] = d[j-1] + d[j-5];
                }
            }

            sb.append(d[number] + "\n");
        }

        System.out.println(sb);

    }
    
}
