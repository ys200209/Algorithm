import java.util.*;
import java.io.*;

public class Main35_1516 {
    static int N;
    static int[] list, costs, dp;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static Queue<Integer> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        list = new int[N+1];
        costs = new int[N+1];
        dp = new int[N+1];

        for(int i=0; i<=N; i++) graph.add(new ArrayList<>());

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int cost = Integer.parseInt(st.nextToken());
            costs[i] = cost;

            while(st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());

                if (num != -1) {
                    graph.get(num).add(i);
                    list[i]++;
                }
            }
        }

        for(int i=1; i<=N; i++) {
            if (list[i] == 0) {
                queue.offer(i);
                dp[i] = costs[i];
            }
        }

        while(!queue.isEmpty()) {
            int num = queue.poll();

            for(int n : graph.get(num)) {
                list[n]--;
                dp[n] = Math.max(dp[n], dp[num] + costs[n]);

                if (list[n] == 0) queue.offer(n);
            }
        }

        for(int i=1; i<=N; i++) {
            sb.append(dp[i] + "\n");
        }
        System.out.println(sb);
    }
}