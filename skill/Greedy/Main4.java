import java.util.*;

public class Main4 {
    public static int weight;
    public static Queue<Integer> queue;

    public static void main(String[] args) {

        System.out.println(solution(new int[]{70, 50, 80, 50}, 170)); // 3
        System.out.println(solution(new int[]{70, 80, 50}, 100)); // 3
        System.out.println(solution(new int[]{1, 2, 3, 3, 4, 5}, 6)); // 3

    }

    public static int solution(int[] people, int limit) {
        int answer = 0;
        weight = 0;
        queue = new PriorityQueue<>();
        
        if (people.length == 1) return 1;

        for(int i=0; i<people.length; i++) {
            weight += people[i];
            queue.offer(people[i]);
        }

        if (weight <= limit) return 1;
        
        weight = 0;
        int result;
        while(!queue.isEmpty()) {
            result = queue.poll();

            for(int i=0; i<queue.size(); i++) {
                if (result + queue.peek() <= limit) {
                    result += queue.poll();
                } else break;
            }

            answer += 1;
        }

        return answer;
    }
    
}
