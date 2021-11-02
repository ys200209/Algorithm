import java.util.*;

public class Main1 {

    public static void main(String[] args) {

        // 코딩테스트 > 스택/큐 > 기능개발
        System.out.println(Arrays.toString(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5}))); // [2, 1]
        System.out.println(Arrays.toString(solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}))); // [1, 3, 2]

    }

    public static int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        Queue<Integer> progresses_queue = new LinkedList<>();
        Queue<Integer> speeds_queue = new LinkedList<>();
        
        for(int i=0; i<progresses.length; i++) {
            progresses_queue.offer(progresses[i]);
            speeds_queue.offer(speeds[i]);
        }

        for(int i=1; i<100; i++) {
            if (progresses_queue.isEmpty()) break;

            while (!progresses_queue.isEmpty()) {
                if (progresses_queue.peek()+(i*speeds_queue.peek()) >= 100) {
                    progresses_queue.poll();
                    speeds_queue.poll();
                    count++;
                } else break;
                
            }
            if (count != 0) {
                list.add(count);
                count = 0;
            }
        }

        int[] answer = new int[list.size()];

        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
    
}
