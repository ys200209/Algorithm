import java.util.*;

public class Main11_1182 {
    static int N, S, sum=0, result=0;
    static int[] A;

    public static void main(String[] args) { 

        Scanner scanner = new Scanner(System.in);
        
        N = scanner.nextInt();
        S = scanner.nextInt();
        A = new int[N];

        for(int i=0; i<N; i++) {
            A[i] = scanner.nextInt();
        }

        if (N == 1) {
            if (A[0] == S) System.out.println("1");
            else System.out.println("0");
            return;
        }

        DFS(0, 0);

        System.out.println(result);

    }

    public static void DFS(int index, int count) {
        // if (count == N-1) return;

        for(int i=index; i<N; i++) {
            System.out.println("count : " + count + ", i : " + i);
            sum += A[i];
            if (sum == S) result += 1;
            DFS(i+1, count+1);
            sum -= A[i];
        }

    }
    
}