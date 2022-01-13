import java.io.*;
import java.util.StringTokenizer;

public class Main15_27 {
    static int N, X, lower, upper;
    static int[] A;
    static boolean exist;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        A = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        int i = 0;
        while(st.hasMoreTokens()) {
            A[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        lowerSearch(X, 0, N-1);
        upperSearch(X, 0, N-1);

        System.out.println("lower : " + lower + ", upper : " + upper);

        if (exist) System.out.println(upper - lower + 1);
        else System.out.println("-1");
        

    }

    public static void lowerSearch(int target, int front, int back) {
        if (front > back) return;

        int mid = (front + back) / 2;

        if (A[mid] > target) {
            lowerSearch(target, front, mid-1);
        } else if (A[mid] < target) {
            lowerSearch(target, mid+1, back);
        } else {
            lower = mid;
            exist = true;
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
            exist = true;
            upperSearch(target, mid+1, back);
        }
    }

}