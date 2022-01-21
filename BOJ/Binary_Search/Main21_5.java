import java.util.*;

public class Main21_5 {
    static long MAX=1;
    static int N, C;
    static int[] x;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        C = scanner.nextInt();
        x = new int[200001];

        for(int i=0; i<N; i++) {
            x[i] = scanner.nextInt();
        }

        Arrays.sort(x);

        binarySearch(0, 0, N-1);

        System.out.println(MAX);

    }

    public static void binarySearch(long now, int front, int back) {
        if (front > back) return;

        int mid = (front + back) / 2;

        long A = x[mid] - x[0];
        long B = x[N-1] - x[mid];

        MAX = Math.max(now, Math.min(A, B));

        binarySearch(MAX, mid+1, back);
        binarySearch(MAX, front, mid-1);

    }
    
}