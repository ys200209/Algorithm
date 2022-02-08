import java.util.*;

public class Main2_1 {
    
    public static void main(String[] args) {


        System.out.println(solution(new int[]{70, 50, 80, 50}, 100)); // 3
        System.out.println(solution(new int[]{70, 80, 50}, 100)); // 3
        System.out.println(solution(new int[]{40, 40, 40, 40, 40, 40}, 240)); // 3
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int MIN = 0;
        int MAX = people.length-1;
        while(MIN <= MAX) {
            if (limit - people[MAX] < people[MIN]) {
                MAX -= 1;
                answer++;
            } else {
                MIN += 1;
                MAX -= 1;
                answer++;
            }
        }

        return answer;
    }
}