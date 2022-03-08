import java.util.*;
import java.io.*;

public class Main_1956 {
    static int INF = (int)1e9;
    static int V, E, result=(int)1e9;
    static int[][] graph;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        visited = new boolean[V+1];
        graph = new int[V+1][V+1];

        for(int i=0; i<=V; i++) {
            Arrays.fill(graph[i], INF);
            for(int j=0; j<=V; j++) {
                if (i == j) graph[i][j] = 0;
            }
        }

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph[A][B] = C;
        }

        for(int k=1; k<=V; k++) {
            for(int i=1; i<=V; i++) {
                for(int j=1; j<=V; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        for(int i=0; i<=V; i++) {
            System.out.println(Arrays.toString(graph[i]));
        }
        
        for(int i=1; i<=V; i++) {
            for(int j=1; j<=V; j++) {
                if (i == j) continue;

                if (graph[i][j] != INF && graph[j][i] != INF) {
                    result = Math.min(result, graph[i][j] + graph[j][i]);
                }
            }
        }

        if (result == INF) System.out.println("-1");
        else System.out.println(result);

    }

}