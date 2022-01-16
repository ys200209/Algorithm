import java.util.*;

public class Main14_7 {
    static int N, MAX=0, MIN=(int)1e9;
    static int[] A, cal;
    static boolean[] visited;

    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        A = new int[N];
        cal = new int[4];
        visited = new boolean[N];

        for(int i=0; i<N; i++) {
            A[i] = scanner.nextInt();
        }

        for(int i=0; i<4; i++) {
            cal[i] = scanner.nextInt();
        }

        DFS(A[0], 0);
        visited[0] = true;

        System.out.println(MAX);
        System.out.println(MIN);

    }

    public static void DFS(int result, int count) {
        
        if (count == N-1) {
            MAX = Math.max(MAX, result);
            MIN = Math.min(MIN, result);
            return;
        }

        for(int i=1; i<N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                for(int j=0; j<4; j++) {
                    if (cal[j] != 0 && j == 0) {
                        cal[j] -= 1;
                        result += A[i];
                        count += 1;
                        DFS(result, count);
                        count -= 1;
                        result -= A[i];
                        cal[j] += 1;
                    } else if (cal[j] != 0 && j == 1) {
                        cal[j] -= 1;
                        result -= A[i];
                        count += 1;
                        DFS(result, count);
                        count -= 1;
                        result += A[i];
                        cal[j] += 1;
                    } else if (cal[j] != 0 && j == 2) {
                        cal[j] -= 1;
                        result *= A[i];
                        count += 1;
                        DFS(result, count);
                        count -= 1;
                        result /= A[i];
                        cal[j] += 1;
                    } else if (cal[j] != 0 && j == 3) {
                        cal[j] -= 1;
                        if (result < 0 && A[i] > 0) {
                            result *= -1;
                            int c = result % A[i];
                            result /= A[i];
                            result *= -1;
                            count += 1;
                            DFS(result, count+1);
                            count -= 1;
                            result *= -1;
                            result = result * A[i] + c;
                            result *= -1;
                        } else {
                            int c = result % A[i];
                            result /= A[i];
                            count += 1;
                            DFS(result, count+1);
                            count -= 1;
                            result = result * A[i] + c;
                        }
                        cal[j] += 1;
                    }
                }
                visited[i] = false;
            }
        }


    }

}