package Heap;

import java.util.*;

public class Main3 {
    public static Queue<Integer> queue = new PriorityQueue<>();
    public static Queue<Integer> readyQueue = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) {

        // 이중 우선순위 큐 (3)

        //System.out.println(Arrays.toString(solution(new String[]{"I 16","D 1"}))); // [0, 0]
        //System.out.println(Arrays.toString(solution(new String[]{"I 7","I 5","I -5","D -1"}))); // [7, 5]
        System.out.println(Arrays.toString(solution(
            new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}
            ))); // [333, -45]
        
        // [-45, 45, 333]

    }

    public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        String command = null;
        int number = 0;

        for(int i=0; i<operations.length; i++) {
            command = operations[i].split(" ")[0];
            number = Integer.parseInt(operations[i].split(" ")[1]);

            if (command.equals("I")) {
                if (!queue.isEmpty()) {
                    queue.offer(number);
                } else {
                    readyQueue.offer(number);
                }
                System.out.println("I");
            } else {
                if (number == 1) {
                    while(!queue.isEmpty()) {
                        readyQueue.offer(queue.poll());
                    }
                    readyQueue.poll();
                } else {
                    while(!readyQueue.isEmpty()) {
                        queue.offer(readyQueue.poll());
                    }
                    queue.poll();
                }
            }
        }

        if (queue.isEmpty() && readyQueue.isEmpty()) {
            return new int[]{0, 0};
        }

        System.out.println("- queue.size() = " + queue.size());
        System.out.println("- readyQueue.size() = " + readyQueue.size());

        if (queue.size() == 1 || readyQueue.size() == 1) {
            if (queue.isEmpty()) {
                int ret = readyQueue.poll();
                return new int[]{ret, ret};
            } else {
                int ret = queue.poll();
                return new int[]{ret, ret};
            }
        }

        if (queue.isEmpty()) {
            answer[0] = readyQueue.poll();
            while(!readyQueue.isEmpty()) {
                answer[1] = readyQueue.poll();
            }
        } else {
            answer[1] = queue.poll();
            while(!queue.isEmpty()) {
                answer[0] = queue.poll();
            }
        }
        return answer;
    }
    
}
