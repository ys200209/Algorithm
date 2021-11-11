package Heap;

import java.util.*;

public class Main2 {
    public static Queue<Process> queue = new PriorityQueue<>();
    public static Queue<Process> readyQueue = new LinkedList<>();

    public static void main(String[] args) {

        // 디스크 컨트롤러 (2)
        //System.out.println(solution(new int[][]{{0, 3}, {1, 9}, {2, 6}})); // 9
        //System.out.println(solution(new int[][]{{0, 10}, {1, 8}, {2, 6}})); // 10+14+23 = 47/3 = 15
        //System.out.println(solution(new int[][]{{0, 10}, {13, 6}})); // 10+3+6 = 19/2 = 9
        System.out.println(solution(new int[][]{{3, 10}, {3, 6}})); // 3+6+16 = 25/2 = 12

    }
    
    public static int solution(int[][] jobs) {
        int answer = 0;
        int point = 0;
        boolean waiting = false;

        for(int i=0; i<jobs.length; i++) {
            queue.offer(new Process(jobs[i][0], jobs[i][1]));
        }

        while(!queue.isEmpty()) {
            Process process = null;
            waiting = false;

            while(!queue.isEmpty()) {
                process = queue.poll();
                if (process.getArrive() > answer) {
                    readyQueue.offer(process);
                    waiting = true;
                } else {
                    waiting = false;
                    break;
                }
            }

            if (waiting) {
                point += 1;
                answer += 1;
            } else {
                point += process.getSize();
                answer += point - process.getArrive();
            }

            System.out.println("point = " + point);
            System.out.println("answer = " + answer);
            

            while(!readyQueue.isEmpty()) {
                queue.offer(readyQueue.poll());
            }

        }

        answer /= jobs.length;

        return answer;
    }

}

class Process implements Comparable<Process>{

    private int arrive;
    private int size;

    public Process(int arrive, int size) {
        this.arrive = arrive;
        this.size = size;
    }

    public int getArrive() {
        return arrive;
    }

    public int getSize() {
        return size;
    }

    @Override
    public int compareTo(Process p1) {
        if (this.size > p1.size) {
            return 1;
        }
        return -1;
    }

}
