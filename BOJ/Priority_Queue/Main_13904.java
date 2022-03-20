import java.util.*;
import java.io.*;

public class Main_13904 {
    static int N, score=0, time;
    static Queue<Work> pq = new PriorityQueue<>(new Comparator<Work>() {
        @Override
        public int compare(Work w1, Work w2) {
            return w2.w - w1.w; // 점수를 기준으로 역 정렬
        }
    });
    static Queue<Work> readyPQ = new PriorityQueue<>(new Comparator<Work>() {
        @Override
        public int compare(Work w1, Work w2) {
            return w2.d - w1.d; // 기간을 기준으로 역 정렬
        }
    });
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            readyPQ.offer(new Work(d, w));
        }

        time = readyPQ.peek().d;

        while(time > 0) {
            while(!readyPQ.isEmpty() && time <= readyPQ.peek().d) {
                pq.offer(readyPQ.poll());
            }

            if (!pq.isEmpty()) score += pq.poll().w;
            time--;
        }
        
        System.out.println(score);
    }

}

class Work {

    int d;
    int w;

    public Work(int d, int w) {
        this.d = d;
        this.w = w;
    }

}