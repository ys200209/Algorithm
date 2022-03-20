import java.util.*;
import java.io.*;

public class Main_13904 {
    static int N, score=0, time=1;
    static Queue<Work> queue = new LinkedList<>();
    static Queue<Work> pq = new PriorityQueue<>(new Comparator<Work>() {
        @Override
        public int compare(Work w1, Work w2) {
            /*if (w1.d == w2.d) { // 기간이 같다면 중요도가 높은 순서로 정렬
                return w2.w - w1.w;
            } else { // 기간이 다르다면
                return w1.d - w2.d; // 기간이 빠른 순서로 정렬
            }*/
            return w1.w - w2.w;
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
            
            pq.offer(new Work(d, w));
        }

        while(!pq.isEmpty()) {
            Work work = pq.poll();

            if (work.d == queue.size()) { // 해당 일 수에 끝낼 수 있는 과제가 초과되었다면
                System.out.println(work.d + "초과");
                if (queue.peek().w < work.w) { // 기존의 과제보다 새로운 과제가 더 많은 점수라면
                    queue.poll();
                    queue.offer(work);
                }
            } else queue.offer(work);

            
        }

        while(!queue.isEmpty()) {
            score += queue.poll().w;
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