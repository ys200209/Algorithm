package Stack_Queue;

import java.util.*;

public class Main2 {
    public static Queue<Printer> queue = new LinkedList<>();
    public static Queue<Integer> pri_queue = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) {

        // 프린터
        System.out.println(solution(new int[]{2, 1, 3, 2}, 2)); // 1
        System.out.println(solution(new int[]{1, 1, 9, 1, 1, 1}, 0)); // 5

    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        queue = new LinkedList<>();
        pri_queue = new PriorityQueue<>(Collections.reverseOrder()); // 새로운 입력값에 대한 대응 (초기화)

        for(int i=0; i<priorities.length; i++) {
            queue.offer(new Printer(i, priorities[i]));
            pri_queue.offer(priorities[i]);
        }

        while(!queue.isEmpty()) { // 큐가 빌때까지 추출
            
            if (queue.peek().getImp() == pri_queue.peek()) { // 만약 추출할 프린트의 우선순위가 최고순위라면
                answer ++;
                if (queue.peek().getIndex() == location) { // 추출할 프린트의 순서가 location 번째로 출력된다면 리턴
                    return answer;
                }
                queue.poll(); // 추출하라
                pri_queue.poll(); // 추출하라
            } else {
                queue.offer(queue.poll()); // 추출할 프린트의 우선순위가 상대적으로 낮다면 다시 큐의 마지막에 삽입
            }

        }
        
        return answer;
    }
    
}

class Printer {
    private int index;
    private int imp;

    public Printer(int index, int imp) {
        this.index = index;
        this.imp = imp;
    }

    public int getIndex() {
        return index;
    }

    public int getImp() {
        return imp;
    }
    
}
