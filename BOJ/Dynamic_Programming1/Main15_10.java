import java.util.*;

public class Main15_10 {
    static int N;
    static int[] juice, d;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        juice = new int[N+1];
        d = new int[N+1];

        for(int i=1; i<=N; i++) {
            juice[i] = scanner.nextInt();
        }

        TopDown(N);

        /*d[1] = juice[1];
        if (N > 1) {
            d[2] = juice[1] + juice[2];
        }

        for(int i=3; i<=N; i++) {
            d[i] = Math.max(d[i], Math.max(d[i-2], d[i-3] + juice[i-1]) + juice[i]);
        }*/

        System.out.println(Arrays.toString(d));

        System.out.println(d[N]);

    }

    public static int TopDown(int index) {
        if (index <= 1) return d[index] = juice[index];
        if (index == 2) return d[index] = juice[index-1] + juice[index];

        if (d[index] == 0) {
            return d[index] = Math.max(Math.max(TopDown(index-2), TopDown(index-3)+juice[index-1] + juice[index]), 
                            TopDown(index-1));
        }

        return d[index];
    }


}