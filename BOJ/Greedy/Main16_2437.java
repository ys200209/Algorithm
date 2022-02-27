import java.util.*;
import java.io.*;

public class Main16_2437 {
    static int N;
    static long[] A;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new long[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int i=1;
        while(st.hasMoreTokens()) {
            A[i] = Long.parseLong(st.nextToken());
            i++;
        }

        Arrays.sort(A);

        for(i=1; i<=N; i++) {
            if (A[i] <= A[i-1] + 1) {
                A[i] = A[i] + A[i-1];
            } else {
                System.out.println(A[i-1] + 1);
                return;
            }
        }
        
        System.out.println(A[N]+1);
    }
}