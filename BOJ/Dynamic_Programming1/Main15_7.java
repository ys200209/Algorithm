import java.util.*;
import java.io.*;

public class Main15_7 {
    public static int N;
    public static int[] stairs, d;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stairs = new int[N+1];
        d = new int[N+1];

        for(int i=1; i<=N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        // d[0] = stairs[0];
        d[1] = stairs[1];

        if (N >= 2) {
            d[2] = stairs[1] + stairs[2];
        } 

        for(int i=3; i<=N; i++) {
            d[i] = Math.max(d[i-3]+stairs[i-1], d[i-2]) + stairs[i];
        }


        // System.out.println(Arrays.toString(d));

        System.out.println(d[N]);

    }
    
}
