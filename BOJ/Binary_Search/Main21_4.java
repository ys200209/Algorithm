import java.io.*;
import java.util.*;

public class Main21_4 {
    static long slice, result;
    static int N, M;
    static int[] A;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        int i=0;
        while(st.hasMoreElements()) {
            A[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        Arrays.sort(A);

        binarySearch(0, A[N-1]);

        System.out.println(result);
    }

    public static void binarySearch(long front, long back) {
        if (front > back) return;

        long mid = (front + back) / 2;

        System.out.println("mid : " + mid);
        slice = 0;
        for(int i=0; i<N; i++) {
            slice += A[i] - mid > 0 ? A[i] - mid : 0;
        }

        if (slice < M) {
            binarySearch(front, mid-1);
        } else {
            result = mid;
            binarySearch(mid+1, back);
        }

    }

}
