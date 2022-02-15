import java.io.*;
import java.util.*;

public class Main26_1 {
    static int N, X, result=0;
    static int[] A;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];

        int i=0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreElements()) {
            A[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        X = Integer.parseInt(br.readLine());

        Arrays.sort(A);

        twoPointer(0, N-1);

        System.out.println(result);
    }

    public static void twoPointer(int start, int end) {
        if (start >= end) return;

        if (A[start] + A[end] > X) {
            twoPointer(start, end-1);
        } else if (A[start] + A[end] < X) {
            twoPointer(start+1, end);
        } else {
            result++;
            twoPointer(start+1, end-1);
        }

    }

}