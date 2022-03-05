import java.util.*;
import java.io.*;

public class Main11_11724 {
    static int N, M, result=0;
    static int[][] graph;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        for(int i=1; i<=N; i++) {
            if (searchConnected(i)) result++;
        }

        System.out.println(result);

    }

    public static boolean searchConnected(int node) {
        if (visited[node]) return false;

        visited[node] = true;

        int i=0;
        for(int n : graph[node]) {
            if (n != 0 && !visited[i]) {
                searchConnected(i);
            }
            i++;
        }
        return true;
    }

}