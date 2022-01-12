import java.io.*;
import java.util.StringTokenizer;

public class Main15_27 {
    static int N, X, lower, upper;
    static int[] A;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        A = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        int i=0;
        while(st.hasMoreTokens()) {
            A[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        searchLower(X, 0, N);

        searchUpper(X, 0, N);

        System.out.println("lower = " + lower);
        System.out.println("upper = " + upper);
    }

    public static void searchLower(int target, int front, int back) {
        if (front > back) return;

        int mid = (front+back) / 2;

        if (A[mid] > target) {
            searchLower(target, front, mid-1);
        } else if (A[mid] < target) {
            searchLower(target, mid+1, back);
        } else {
            lower = mid;
            searchLower(target, front, mid-1);
        }
    }

    public static void searchUpper(int target, int front, int back) {
        if (front >= back) return;

        int mid = (front+back) / 2;

        if (A[mid] > target) {
            searchUpper(target, mid+1, back);
        } else if (A[mid] < target) {
            searchUpper(target, front, mid-1);
        } else {
            upper = mid;
            searchUpper(target, mid+1, back);
        }
    }
    
}
