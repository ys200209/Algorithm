import java.util.*;
import java.io.*;

public class Main27_6 {
    static int N, K, result=0;
    static int[] dp;
    static Queue<Locate> pq = new PriorityQueue<>();
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        dp = new int[100001];
        
        BFS(N);

        // System.out.println(Arrays.toString(dp));
        
        ArrayList<Integer> list = new ArrayList<>();
        int count = dp[K];
        list.add(K);
        int MAX = K;
        while(MAX != N) {
            count--;
            if (MAX-1 >= 0) {
                if (count == dp[MAX-1]) {
                    MAX -= 1;
                    list.add(MAX);
                    continue;
                }
            }
            if (MAX+1 <= 100001) {
                if (count == dp[MAX+1]) {
                    MAX += 1;
                    list.add(MAX);
                    continue;
                }
            }
            if (MAX % 2 == 0) {
                if (count == dp[MAX/2]) {
                    MAX /= 2;
                    list.add(MAX);
                    continue;
                }
            }
        }
        
        for(int i=list.size()-1; i>=0; i--) {
            sb.append(list.get(i) + " ");
        }

        System.out.println(sb);
    }

    public static void BFS(int index) {
        pq.offer(new Locate(index, 0));
        int[] dx = new int[]{-1, 1};

        while(!pq.isEmpty()) {
            Locate locate = pq.poll();

            int now = locate.index;
            int count = locate.count;

            if (visited[now]) continue;

            visited[now] = true;
            dp[now] = count;

            if (now == K) {
                sb.append(count+"\n");
                return;
            }

            for(int i=0; i<2; i++) {
                int nx = now + dx[i];
                if (nx < 0 || nx > 100000) continue;

                pq.offer(new Locate(nx, count+1));
            }

            if (now*2 <= 100000) pq.offer(new Locate(now*2, count+1));

        }

    }

}

class Locate implements Comparable<Locate> {

    int index;
    int count;

    public Locate(int index, int count) {
        this.index = index;
        this.count = count;
    }

    @Override
    public int compareTo(Locate locate) {
        return this.count - locate.count;
    }

}