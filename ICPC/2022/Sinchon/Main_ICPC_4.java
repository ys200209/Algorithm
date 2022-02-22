import java.util.*;
import java.io.*;

public class Main_ICPC_4 {
    static int INF = (int)1e9;
    static int N, M;
    static int[][] graph;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N+1][N+1];

        for(int i=0; i<=N; i++) {
            Arrays.fill(graph[i], INF);

            for(int j=0; j<=N; j++) {
                if (i == j) graph[i][j] = 0;
            }
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph[A][B] = C;
            // graph[B][A] = C;
        }

        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        for(int i=0; i<=N; i++) {
            System.out.println(Arrays.toString(graph[i]));
        }




    }

}
