import java.util.*;
import java.io.*;

public class Main_1966 {
    static int T, N, M;
    static Queue<Work> queue;
    static Queue<Work> pq;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            queue = new LinkedList<>();
            pq = new PriorityQueue<>(new Comparator<Work>() {
                @Override
                public int compare(Work w1, Work w2) {
                    return w2.distance - w1.distance; // 중요한 문서부터 처리
                }
            });

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            int i=0;
            while(st.hasMoreTokens()) {
                int dis = Integer.parseInt(st.nextToken());
                queue.offer(new Work(i, dis));
                pq.offer(new Work(i, dis));
                i++;
            }

            int count=1;
            while(!queue.isEmpty()) {
                if (pq.peek().distance == queue.peek().distance) {
                    pq.poll();
                    if (queue.poll().index == M) break;
                    count++;
                } else {
                    queue.offer(queue.poll());
                }
            }
            sb.append(count + "\n");
        }
        System.out.println(sb);
    }

}

class Work {

    int index;
    int distance;

    public Work(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

}