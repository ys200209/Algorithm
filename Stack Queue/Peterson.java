import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Peterson {
    static int count=0;
    static int turn=0;
    static AtomicBoolean[] flag = new AtomicBoolean[2];
    static {
        for(int i=0; i<flag.length; i++) {
            flag[i] = new AtomicBoolean();
        }
    }

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Thread pthread = new Thread(new Producer());
        Thread cthread = new Thread(new Consumer());

        pthread.start();
        cthread.start();

        try {
            pthread.join();
            cthread.join();
            System.out.println("finish");
            System.out.println((System.currentTimeMillis() - startTime) + " ms");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Producer implements Runnable {
        @Override
        public void run() {
            for(int i=0; i<1000; i++) {
                flag[0].set(true);
                turn = 1;
                while(flag[1].get()&&turn==1);

                count++;
                System.out.println("생산");
                flag[0].set(false);
            }
        }
    }

    static class Consumer implements Runnable {
        @Override
        public void run() {
            for(int i=0; i<1000; i++) {
                flag[1].set(true);
                turn = 0;
                while(flag[0].get()&&turn==0);

                count--;
                System.out.println("소비");
                flag[1].set(false);
            }
        }
    }
    
}


