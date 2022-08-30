import java.util.*;
import java.io.*;

public class Main25_11780 {
    static int INF = (int)1e9;
    static int N, M;
    static int[][] graph;
    static Node[][] dp;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new int[N+1][N+1];
        dp = new Node[N+1][N+1];
        
        for(int i=1; i<=N; i++) {
            Arrays.fill(graph[i], INF);

            for(int j=1; j<=N; j++) {
                if (i == j) graph[i][j] = 0;
                dp[i][j] = new Node();
            }
        }
        
        StringTokenizer st;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph[A][B] = Math.min(graph[A][B], C);
        }

        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    // graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    if (graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                        dp[i][k].queue.offer(k);
                    } else {
                        //dp[i][j].queue.poll();
                    }
                }
            }
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                sb.append(graph[i][j] + " ");
            }
            sb.append("\n");
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if (graph[i][j] == 0) sb.append("0\n");
                else {
                    int size = dp[i][j].queue.size()+2;
                    if (size == 2) sb.append(size + " " + i + " " + j + "\n");
                    else {
                        sb.append(size + " " + i + " ");
                        while(!dp[i][j].queue.isEmpty()) {
                            sb.append(dp[i][j].queue.poll() + " ");
                        }
                        sb.append(j + "\n");
                    }
                }
            }
        }

        System.out.println("-------------------");
        System.out.println(sb);
    }

    static class Node {

        Queue<Integer> queue;

        public Node() {
            queue = new LinkedList<>();
        }

    }

}

