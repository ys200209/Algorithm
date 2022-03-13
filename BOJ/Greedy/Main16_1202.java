import java.util.*;
import java.io.*;

public class Main16_1202 {
    static long result=0;
    static int N, K;
    static Queue<Jewel> jewelQueue = new PriorityQueue<>((j1, j2) -> { // 보석 큐에 무게 순으로 오름차순
        return j1.w - j2.w;
    });
    static Queue<Jewel> pq = new PriorityQueue<>((j1, j2) -> { // 우선 큐에 가격 순으로 내림차순
        return j2.price - j1.price;
    });
    static Queue<Integer> bag = new PriorityQueue<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            jewelQueue.offer(new Jewel(A, B));
        }
        

        for(int i=0; i<K; i++) {
            bag.offer(Integer.parseInt(br.readLine()));
        }

        while(!bag.isEmpty()) {
            int bagW = bag.poll();

            while(!jewelQueue.isEmpty()) {
                if (bagW >= jewelQueue.peek().w) pq.offer(jewelQueue.poll());
                else break;
            }

            System.out.println("pq.size : " + pq.size());
            if (!pq.isEmpty()) result += pq.poll().price;

        }
        System.out.println(result);
    }
}

class Jewel {

    int w;
    int price;

    public Jewel(int w, int price) {
        this.w = w;
        this.price = price;
    }

}