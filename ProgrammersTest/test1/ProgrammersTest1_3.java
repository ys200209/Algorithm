import java.util.*;

class ProgrammersTest1_3 {
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {

        // System.out.println(solution(new int[]{4, 3, 1, 2, 5})); // 2
        System.out.println(solution(new int[]{5, 4, 3, 2, 1})); // 5

    }

    public static int solution(int[] order) {
        int answer = 0;

        int box = 1;
        for(int i=0; i<order.length; i++) {
            while(order[i] > box) {
                stack.push(box);
                box++;
            }

            if (order[i] == box) {
                box++;
                answer++;
                continue;
            } else {
                if (!stack.isEmpty() && stack.peek() == order[i]) {
                    answer++;
                    stack.pop();
                    continue;
                }
            }

            break;
        }

        // System.out.println("box : " + box);
        return answer;
    }
    
}