import java.io.*;
import java.util.*;

public class Main15_11722 {
    static int N, result=1;
    static int[] A, d;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        A = new int[N+1];
        d = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int i=1;
        while(st.hasMoreTokens()) {
            A[i] = Integer.parseInt(st.nextToken());
            d[i] = 1;
            i++;
        }

        for(i=2; i<=N; i++) {
            for(int j=1; j<i; j++) {
                if (A[j] > A[i]) {
                    d[i] = Math.max(d[i], d[j]+1);
                }
            }
            result = Math.max(result, d[i]);
        }

        // System.out.println(Arrays.toString(d));

        System.out.println(result);

    }
}