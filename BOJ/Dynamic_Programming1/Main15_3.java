import java.util.*;

public class Main15_3 {
    public static Integer[] d = new Integer[1000001];
    
    public static void main(String[] args) {

        // 백준 온라인 저지 Dynamic_Programming(15)의 3번
        // N=1, 1
        // N=2, 2
        // N=3, (001, 100, 111) 3
        // N=4, 5
        // N=5, (00001, 00100, 10000, 00111, 10011, 11001, 11100, 11111) 8
        // N=6, (000000, 000011, 001001, 100001, 001100, 100100, 110000, 001111, 100111, 110011, 111001, 111100, 111111) 13.

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        
        d[1] = 1;
        d[2] = 2;

        /*
            for(int i=3; i<=N; i++) {
                d[i] = (d[i-2] + d[i-1]) % 15746;
            }
        */

        count(N);

        System.out.println(d[N]);

    }

    public static int count(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (d[n] != null) return d[n];
        return d[n] = 
                (d[n-1] = d[n-1] != null ? d[n-1] : count(n-1)) + 
                (d[n-2] = d[n-2] != null ? d[n-2] : count(n-2)) % 15746;
    }

}
