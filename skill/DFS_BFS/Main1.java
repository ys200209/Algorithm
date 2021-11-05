package DFS_BFS;

import java.util.*;

public class Main1 {
    public static int answer = 0;
    public static void main(String[] args) {
        // 타겟 넘버
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3)); // 5

    }
    
    public static int solution(int[] numbers, int target) {

        DFS(numbers, 0, 0, target);

        return answer;
    }

    public static void DFS(int[] numbers, int sum, int index, int target) {
        if (index >= numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }

        DFS(numbers, sum-numbers[index], index+1, target);
        DFS(numbers, sum+numbers[index], index+1, target);
        return;
    }

}
