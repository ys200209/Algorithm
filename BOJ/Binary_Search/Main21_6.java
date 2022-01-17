import java.util.*;
import java.io.*;

public class Main21_6 {
    static int N, K;
    static long[] B;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        B = new long[N*N+1];

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                B[(N*(i-1))+j] = i*j;
            }
        }

        Arrays.sort(B);

        System.out.println(B[K]);

    }
    
}
