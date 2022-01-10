import java.util.*;
import java.io.*;

public class Main21_1 {
    static int N, M, MIN, MAX;
    static int[] A, B;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int i = 0;
        while(st.hasMoreTokens()) {
            A[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        M = Integer.parseInt(br.readLine());
        B = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        i = 0;
        while(st.hasMoreTokens()) {
            B[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        Arrays.sort(A);

        MIN = A[0];
        MAX = A[N-1];

        for(i=0; i<M; i++) {
            if (B[i] < MIN || B[i] > MAX) {
                sb.append("0\n");
                continue;
            }

            if (A[0] == B[i] || A[N-1] == B[i]) {
                sb.append("1\n");
                continue;
            }

            if (searchBinary(B[i], 0, N/2, N-1)) sb.append("1\n");
            else sb.append("0\n");

        }

        System.out.println(sb);

    }

    public static boolean searchBinary(int target, int front, int mid, int back) {
        if (front == mid || back == mid) return false;

        if (A[mid] < target) {
            front = mid;
            mid = (front + back) / 2;
            return searchBinary(target, front, mid, back);
        } else if (A[mid] > target) {
            back = mid;
            mid = (front + back) / 2;
            return searchBinary(target, front, mid, back);
        } else return true;
    }
    
}