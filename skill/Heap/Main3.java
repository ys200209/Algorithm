package Heap;

import java.util.*;

public class Main3 {
    Deque<Integer> deq = new ArrayDeque<>();
    Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
    queue = new PriorityQueue<>(queue, Collections.reverseOrder());
    

    public static void main(String[] args) {

        System.out.println(solution(new String[]{"I 16","D 1"})); // [0, 0]
        System.out.println(solution(new String[]{"I 7","I 5","I -5","D -1"})); // [7, 5]

    }

    public static int[] solution(String[] operations) {
        int[] answer = {};
        String command = null;
        int number = 0;


        

        return answer;
    }
    
}
