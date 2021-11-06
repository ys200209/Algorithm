package Stack_Queue;

import java.util.*;

public class Main2 {
    public static Queue<Printer> queue = new PriorityQueue<>();

    public static void main(String[] args) {

        // 프린터
        //System.out.println(solution(new int[]{2, 1, 3, 2}, 2)); // 1
        System.out.println(solution(new int[]{1, 1, 9, 1, 1, 1}, 0)); // 5

    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        for(int i=0; i<priorities.length; i++) {
            queue.offer(new Printer(i, priorities[i]));
        }

        while(!queue.isEmpty()) {
            System.out.println(queue.poll().getIndex());
        }
        

        return answer;
    }
    
}

class Printer implements Comparable<Printer>{
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

    @Override
    public int compareTo(Printer o) {
        if (this.imp > o.imp) {
            return -1;
        }
        return 1;
    }


    

    

}
