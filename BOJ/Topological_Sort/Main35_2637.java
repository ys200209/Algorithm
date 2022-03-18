import java.util.*;
import java.io.*;

public class Main35_2637 {
    static int N, M;
    static int[] list, dp;
    static ArrayList<ArrayList<Peace>> graph = new ArrayList<>();
    static Queue<Integer> pq = new PriorityQueue<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new int[N+1];
        dp = new int[N+1];

        for(int i=0; i<=N; i++) graph.add(new ArrayList<>());

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int X = Integer.parseInt(br.readLine());
            int Y = Integer.parseInt(br.readLine());
            int K = Integer.parseInt(br.readLine());
    
            graph.get(Y).add(new Peace(X, K));
            list[X]++;
        }

        for(int i=1; i<=N; i++) {
            if (list[i] == 0) pq.offer(i);
        }

        while(!pq.isEmpty()) {
            int num = pq.poll();

            for(Peace peace : graph.get(num)) {
                list[peace.index]--;
                if (dp[peace.index] < dp[num])

                if (list[peace.index] == 0) pq.offer(peace.index);
            }
        }

    }

}

class Peace {

    int index;
    int count;

    public Peace(int index, int count) {
        this.index = index;
        this.count = count;
    }

}