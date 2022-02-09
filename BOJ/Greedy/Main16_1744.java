import java.util.*;
import java.io.*;

public class Main16_1744 {
    static int N, result=0;
    static int[] A;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];

        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1) {
            System.out.println(A[0]);
            return;
        }

        Arrays.sort(A);

        // System.out.println(Arrays.toString(A));
        int index = N-2;
        while(index >= 0) {
            if (A[index] > 1) {
                result += A[index] * A[index+1];
                index-=2;
            } else if (A[index] == 0) {
                result += A[index+1];
                index-=1;
            } else {
                result += Math.max(A[index]*A[index+1], A[index]+A[index+1]);
                index-=2;
            }
            
        }

        System.out.println(result);

    }
}