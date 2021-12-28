import java.util.*;

public class Main12_1 {
    public static int N;
    public static Queue<Integer> queue = new PriorityQueue<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        
        Th th = new Th();
        th.start();

        System.out.println("th.isAlive() = " + th.isAlive());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) { }

        System.out.println("th.isAlive() = " + th.isAlive());

        // a();

    }

    
    public static void a() {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);

        for(int i=0; i<queue.size(); i++) {
            queue.poll(); // 4-0, 3-1, 2-2, 
            System.out.println(i); 
        }
    }

    static class Th extends Thread {
        public void run() { 
            try { 
                int i=0;
                while(true) {
                    System.out.println(i);
                    i++;
                    Thread.sleep(500);

                    if (i == 5) {
                        System.out.println("interrupt!!");
                        this.interrupt();
                    }
                }
            } catch (InterruptedException e) { }
        }
    }
    
}

