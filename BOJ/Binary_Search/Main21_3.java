import java.util.*;
import java.io.*;

public class Main21_3 {
    static long result=1;
    static int N, K, count;
    static int[] A;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N];

        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(A);

        binarySearch(0, A[N-1]);

        System.out.println(result);

    }

    public static void binarySearch(long front, long back) {
        if (front > back) return;

        long mid = (front + back) / 2;

        count=0;
        for(int i=0; i<N; i++) {
            count += mid > 0 ? A[i] / mid : 0;
        }

        if (count >= K) {
            result = mid;
            binarySearch(mid+1, back);
        } else if (count < K) {
            binarySearch(front, mid-1);
        }

    }
    
}
