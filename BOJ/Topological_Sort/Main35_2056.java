import java.util.*;
import java.io.*;

public class Main35_2056 {
    static int N;
    static int[] list, dp, costs;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static Queue<Integer> queue = new PriorityQueue<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        list = new int[N+1];
        dp = new int[N+1];
        costs = new int[N+1];

        for(int i=0; i<=N; i++) graph.add(new ArrayList<>());

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int cost = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            costs[i] = cost;
            
            for(int j=0; j<count; j++) {
                int task = Integer.parseInt(st.nextToken());
                graph.get(task).add(i);
                list[i]++;
            }
            
        }

        // System.out.println("task : " + Arrays.toString(list));

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

                if (list[n] == 0) {
                    queue.offer(n);
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        System.out.println(dp[N]);
    }
}