import java.util.*;
import java.io.*;

public class Main23_16928 {
    static int N, M, result=(int)1e9;
    static Map<Integer, Integer> A = new HashMap<>();
    static Map<Integer, Integer> B = new HashMap<>();
    static Queue<Position> pq = new PriorityQueue<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            A.put(from, to);
        }

        for(int i=0; i<M; i++) { 
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            B.put(from, to);
        }

        BFS(1);

        System.out.println(result);
    }

    public static void BFS(int start) {
        pq.offer(new Position(start, 0));

        while(!pq.isEmpty()) {
            Position position = pq.poll();
            int now = position.now;

            if (now >= 100) {
                result = Math.min(result, position.count);
                return;
            }

            for(int i=6; i>=1; i--) {
                if (B.get(now+i) != null) continue;

                /*if (i == 6 && )
                    else {
                    pq.offer(new Position(now+i, position.count+1));
                }*/
            }
        }

    }

}

class Position implements Comparable<Position> {

    int now;
    int count;

    public Position(int now, int count) {
        this.now = now;
        this.count = count;
    }

    @Override
    public int compareTo(Position p) {
        return p.now - this.now;
    }

}