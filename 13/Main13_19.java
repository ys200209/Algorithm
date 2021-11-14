import java.util.*;

class Main13_19 {
    public static int N, result_min=1000000000, result_max=-1000000000, result, C;
    public static int[] A, cal;
    
    
    public static void main(String[] args) {

        // 삼성전자 SW 역량테스트

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

        result = A[0];

        DFS(1);

        System.out.println(result_max);
        System.out.println(result_min);

    }

    public static void DFS(int index) {
        if (index == N) {
            result_min = Math.min(result_min, result);
            result_max = Math.max(result_max, result);
            return;
        }

        for(int i=0; i<4; i++) {
            if (cal[0] != 0) {
                result += A[index];
                index += 1;
                cal[0] -= 1;
                DFS(index);
                cal[0] += 1;
                index -= 1;
                result -= A[index];
            }
            if (cal[1] != 0) {
                result -= A[index];
                index += 1;
                cal[1] -= 1;
                DFS(index);
                cal[1] += 1;
                index -= 1;
                result += A[index];
            }
            if (cal[2] != 0) {
                result *= A[index];
                index += 1;
                cal[2] -= 1;
                DFS(index);
                cal[2] += 1;
                index -= 1;
                result /= A[index];
            }
            if (cal[3] != 0) {
                if (result < 0) {
                    result *= -1;
                    C = result % A[index];
                    result /= A[index];
                    result *= -1;
                } else {
                    C = result % A[index];
                    result /= A[index];
                }
                index += 1;
                cal[3] -= 1;
                DFS(index);
                cal[3] += 1;
                index -= 1;
                result *= A[index];
                result += C;
            }
        }
    }

}