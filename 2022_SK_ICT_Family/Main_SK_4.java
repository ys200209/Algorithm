import java.util.*;
import java.io.*;

public class Main_SK_4 {
    static int INF = (int)1e9;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static Queue<Node> queue = new LinkedList<>();
    static int[][] dp;
    
    public static void main(String[] args) throws IOException {
        
        System.out.println(solution(5, new int[][]{{0,1},{0,2},{1,3},{1,4}})); // 16
        // System.out.println(solution(4, new int[][]{{2,3},{0,1},{1,2}})); // 8


    }

    public static long solution(int n, int[][] edges) {
        long answer = 0;
        dp = new int[n][n];

        for(int i=0; i<n; i++) {
            Arrays.fill(dp[i], INF);
            for(int j=0; j<n; j++) {
                if (i == j) dp[i][j] = 0;
            }
        }

        for(int i=0; i<edges.length; i++) {
            int A = edges[i][0];
            int B = edges[i][1];

            dp[A][B] = 1;
            dp[B][A] = 1;
        }

        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if (i == j) continue;
                for(int k=0; k<n; k++) {
                    if (i == k || j == k) continue;
                    if (dp[i][j] + dp[j][k] == dp[i][k]) answer++;
                }
            }
        }
        

        /*
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++) {
            int A = edges[i][0];
            int B = edges[i][1];

            graph.get(A).add(B);
            graph.get(B).add(A);
        }
        
        for(int i=0; i<4; i++) {
            boolean[] v = new boolean[n];
            v[i] = true;
            queue.offer(new Node(i, i, i, v));
            BFS(i);
        }*/

        return answer;
    }

    public static void DFS(int count) {

    }

}

class Node {

    int i;
    int j;
    int k;
    boolean[] visited;

    public Node(int i, int j, int k, boolean[] visited) {
        this.i = i;
        this.j = j;
        this.k = k;
        this.visited = visited;
    }

}