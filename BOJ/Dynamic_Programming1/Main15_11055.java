import java.io.*;
import java.util.*;

public class Main15_11055 {
    static int N, result;
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
            i++;
        }

        d[1] = A[1];
        result = d[1];

        for(i=2; i<=N; i++) {
            for(int j=1; j<i; j++) {
                if (A[i] >= A[j]) {
                    d[i] = Math.max(d[i], d[j] + A[i]);
                }
            }
            if (d[i] == 0) d[i] = A[i];
            result = Math.max(result, d[i]);
        }

        System.out.println(Arrays.toString(d));
        
        System.out.println(result);

    }
}