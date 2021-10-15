import java.util.*;

class Main15_1 {
    public static int N, result_0=0, result_1=0;
    public static long[] cache;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        // 백준 온라인 저지 Dynamic_Programming(15)의 1번

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        cache = new long[41];

        System.out.println("cache : " + Arrays.toString(cache));

        for(int i=0; i<N; i++) {
            fibo(scanner.nextInt());
            sb.append(result_0 + " " + result_1 + "\n");
            result_0 = 0;
            result_1 = 0;
            System.out.println("cache : " + Arrays.toString(cache));
        }

        System.out.println(sb);
    }

    public static long fibo(int n) {
        
        if (n == 0) {
            result_0++;
            return cache[n] = 0;
        } else if (n == 1) {
            result_1++;
            return cache[n] = 1;
        } else {
            if (cache[n] == 0) {
                return cache[n] = fibo(n-2) + fibo(n-1);
            } else {
                return cache[n];
            }
        }
        
    }
    
}
