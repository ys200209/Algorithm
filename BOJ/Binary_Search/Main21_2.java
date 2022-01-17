import java.util.*;
import java.io.*;

public class Main21_2 {
    static int N, M, MIN, MAX, lower, upper;
    static int[] A, B;
    static boolean exist;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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
            exist = false;
            if (B[i] < MIN || B[i] > MAX) {
                sb.append("0 ");
                continue;
            }

            lowerSearch(B[i], 0, N-1);
            upperSearch(B[i], 0, N-1);

            if (exist) sb.append((upper-lower+1)+" ");
            else sb.append("0 ");
        }

        System.out.println(sb);
        
    }

    public static void lowerSearch(int target, int front, int back) {
        if (front > back) return;

        int mid = (front + back) / 2;

        if (A[mid] > target) {
            lowerSearch(target, front, mid-1);
        } else if (A[mid] < target) {
            lowerSearch(target, mid+1, back);
        } else {
            exist = true;
            lower = mid;
            lowerSearch(target, front, mid-1);
        }

    }

    public static void upperSearch(int target, int front, int back) {
        if (front > back) return;

        int mid = (front + back) / 2;

        if (A[mid] > target) {
            upperSearch(target, front, mid-1);
        } else if (A[mid] < target) {
            upperSearch(target, mid+1, back);
        } else {
            upper = mid;
            upperSearch(target, mid+1, back);
        }
    }

}