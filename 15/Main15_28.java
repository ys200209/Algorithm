import java.io.*;
import java.util.*;

public class Main15_28 {
    static int N, result;
    static int[] A;
    static boolean exist;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int i=0;
        while(st.hasMoreTokens()) {
            A[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        binarySearch(0, N-1);
        
        if (exist) System.out.println(result);
        else System.out.println("-1");
    }

    public static void binarySearch(int front, int back) {
        if (front > back || exist) return;

        int mid = (front + back) / 2;

        if (A[mid] < mid) {
            binarySearch(mid+1, back);
        } else if (A[mid] > mid) {
            binarySearch(front, mid-1);
        } else {
            result = mid;
            exist = true;
        }

    }
}
