import java.util.*;

public class Main14_7 {
    static long MAX=(long)-1e9, MIN=(long)1e9;
    static int N;
    static int[] A, cal;
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        A = new int[N];
        cal = new int[4];

        for(int i=0; i<N; i++) {
            A[i] = scanner.nextInt();
        }

        for(int i=0; i<4; i++) {
            cal[i] = scanner.nextInt();
        }

        DFS(A[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);

    }

    public static void DFS(long num, int count) {
        if (count == A.length) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }

        for(int i=0; i<4; i++) {
            if (cal[i] != 0) {
                cal[i] -= 1;
                if (i == 0) {
                    DFS(num + A[count], count+1);
                } else if (i == 1) {
                    DFS(num - A[count], count+1);
                } else if (i == 2) {
                    DFS(num * A[count], count+1);
                } else {
                    if (num < 0 && A[count] > 0) DFS(((num*-1)/A[count])*-1, count+1);
                    else DFS(num/A[count], count+1);
                }
                cal[i] += 1;
            }
        }
    }
}