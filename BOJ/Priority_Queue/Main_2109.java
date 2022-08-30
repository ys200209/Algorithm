import java.util.*;
import java.io.*;

public class Main_2109 {
    static int N, score=0, time;
    static Queue<Work> pq = new PriorityQueue<>(new Comparator<Work>() {
        @Override
        public int compare(Work w1, Work w2) {
            return w2.pay - w1.pay; // ���� �������� �������� ����
        }
    });
    static Queue<Work> readyPQ = new PriorityQueue<>(new Comparator<Work>() {
        @Override
        public int compare(Work w1, Work w2) {
            return w2.day - w1.day; // �ð��� �������� �������� ����
        }
    });
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        
        if (N == 0) {
            System.out.println(0);
            return;
        }

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            readyPQ.offer(new Work(p, d));
        }
        
        time = readyPQ.peek().day;
        

        while(time > 0) {
            while(!readyPQ.isEmpty() && time <= readyPQ.peek().day) {
                pq.offer(readyPQ.poll());
            }

            if (!pq.isEmpty()) score += pq.poll().pay;
            time--;
        }
        System.out.println(score);
    }

    static class Work {

        int pay;
        int day;

        public Work(int pay, int day) {
            this.pay = pay;
            this.day = day;
        }

    }

}

