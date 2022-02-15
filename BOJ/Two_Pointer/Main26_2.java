import java.io.*;
import java.util.*;

public class Main26_2 {
    static int N, diff=2000000000;
    static int[] A, result;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        result = new int[2];

        int i=0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreElements()) {
            A[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        Arrays.sort(A);

        twoPointer(0, N-1);

        for(int n : result) {
            System.out.print(n + " ");
        }

    }

    public static void twoPointer(int start, int end) {
        if (start >= end) return;

        if (Math.abs(A[start] + A[end]) < diff) {
            diff = Math.abs(A[start] + A[end]);
            result[0] = A[start];
            result[1] = A[end];
        }

        if (A[start] + A[end] > 0) {
            twoPointer(start, end-1);
        } else if (A[start] + A[end] < 0) {
            twoPointer(start+1, end);
        } else {
            diff = 0;
            result[0] = A[start];
            result[1] = A[end];
            return;
        }

    }

}