import java.util.*;

class ProgrammersTest2_1 {
    static int N, answer=0;

    public static void main(String[] args) {

        // System.out.println(solution(new int[]{-2, 3, 0, 2, -5})); // 2
        System.out.println(solution(new int[]{-3, -2, -1, 0, 1, 2, 3})); // 5

    }
    
    public static int solution(int[] number) {
        N = number.length;

        DFS(0, 0, number, 0);

        return answer;
    }

    public static void DFS(int index, int count, int[] number, int sum) {
        if (count == 3) {
            if (sum == 0) answer++;
            return;
        }

        for(int i=index; i<N; i++) {
            DFS(i+1, count+1, number, sum + number[i]);
        }

    }
    
}