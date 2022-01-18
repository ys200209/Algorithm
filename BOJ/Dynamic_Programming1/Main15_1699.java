import java.util.*;

public class Main15_1699 {
    static int N;
    static int[] d;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        d = new int[N+1]; // 100001

        int j;
        for(j=1; j*j<=N; j++) {
            d[j*j] = 1;
        }
        j -= 1;

        for(int i=2; i<=N; i++) {
            int count = 0;
            int num = i;
            for(j=j-1; j>0; j--) {
                if (num/(j*j) > 0) {
                    count += 1;
                    num -= j*j;
                    if (d[num] != 0) {
                        count += d[num];
                        break;
                    }
                }
            }
            
            d[i] = d[i] == 0 ? count : Math.min(d[i], count);
           
        }

        System.out.println(Arrays.toString(d));

        System.out.println(d[N]);

    }
}
