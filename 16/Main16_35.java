import java.util.*;

public class Main16_35 {
    static int N;
    static int[] d = new int[1001];

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        d[1] = 1;

        int index2 = 0, index3 = 0, index5 = 0;
        int now2 = 2, now3 = 3, now5 = 5;

        for(int i=1; i<=N; i++) {
            d[i] = Math.min(now2, Math.min(now3, now5));

            if (d[i] == now2) {
                index2++;
                now2 = d[index2] * 2;
            }
            if (d[i] == now3) {
                index3++;
                now3 = d[index3] * 3;
            }
            if (d[i] == now5) {
                index5++;
                now5 = d[index5] * 5;
            }

        }

        System.out.println(Arrays.toString(d));

    }
    
}