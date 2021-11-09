package Heap;

import java.util.*;

public class Main1 {

    public static Queue<Integer> queue = new PriorityQueue<>();
    
    public static void main(String[] args) {

        // 더 맵게(2)
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7)); // 2
        // System.out.println(solution(new int[]{0, 1}, 1)); // 2

    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        for(int i=0; i<scoville.length; i++) {
            queue.offer(scoville[i]);
        }

        while(queue.size() != 1) {
            answer++;
            queue.offer(queue.poll() + (queue.poll()*2) );
            
            if (queue.peek() >= K) {
                return answer;
            }
            
        }

        return -1;
    }

}
