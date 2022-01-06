import java.util.*;
import java.io.*;

public class Main15_7 {
    static int N, result=0;
    static int[] stairs, d;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        stairs = new int[N+1];
        d = new int[N+1];
        
        for(int i=1; i<=N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        TopDown(N);

        for(int i=0; i<=N; i++) {
            result = Math.max(result, d[i]);
        }

        System.out.println(Arrays.toString(stairs));

        System.out.println(Arrays.toString(d));

        System.out.println(result);

    }

    public static int TopDown(int index) {
        if (index == 0) return 0;
        if (index == 1) return d[index] = stairs[index];
        if (index == 2) return d[index] = stairs[index] + stairs[index-1];

        if (d[index] == 0) {
            return d[index] = Math.max(TopDown(index-2), TopDown(index-3) + stairs[index-1]) + stairs[index];
        }

        return d[index];
    }
    
}