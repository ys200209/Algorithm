import java.util.*;
import java.io.*;

public class Main35_1005 {
    static int T, N, K, victory;
    static int[] list, costs, dp;
    static ArrayList<ArrayList<Integer>> graph;
    static Queue<Integer> queue;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            list = new int[N+1];
            costs = new int[N+1];
            dp = new int[N+1];
            graph = new ArrayList<>();
            queue = new LinkedList<>();

            for(int i=0; i<=N; i++) graph.add(new ArrayList<>());

            st = new StringTokenizer(br.readLine(), " ");
            int i=1;
            while(st.hasMoreTokens()) {
                costs[i] = Integer.parseInt(st.nextToken());
                i++;
            }

            for(i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                graph.get(X).add(Y);
                list[Y]++;
            }   

            victory = Integer.parseInt(br.readLine());

            for(i=1; i<=N; i++) {
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
            sb.append(dp[victory] + "\n");
        }
        System.out.println(sb);
    }
}