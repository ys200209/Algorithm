import java.util.*;
import java.io.*;

public class Main_1781 {
    static int N, score=0;
    static Queue<Work> readyQueue = new PriorityQueue<>(new Comparator<Work>() {
        @Override
        public int compare(Work w1, Work w2) {
            return w2.dead - w1.dead;
        }
    });
    static Queue<Work> pq = new PriorityQueue<>(new Comparator<Work>() {
        @Override
        public int compare(Work w1, Work w2) {
            return w2.score - w1.score;
        }
    });
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            readyQueue.offer(new Work(A, B));
        }

        int time = readyQueue.peek().dead;

        while(time > 0) {
            while (!readyQueue.isEmpty() && time <= readyQueue.peek().dead) pq.offer(readyQueue.poll());

            if (!pq.isEmpty()) score += pq.poll().score;
            time--;
        }
        System.out.println(score);
    }

    static class Work {

        int dead;
        int score; // �Ŷ��

        public Work(int dead, int score) {
            this.dead = dead;
            this.score = score;
        }

    }

}

