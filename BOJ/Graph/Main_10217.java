import java.util.*;
import java.io.*;

public class Main_10217 {
    static int INF = (int)1e9;
    static int T, N, M, K, u, v, c, d;
    static int[][][] graph;

    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine(), " ");

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            graph = new int[N+1][N+1][2]; // [0] : c, [1] : d

            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    if (i == j) graph[i][j][0] = 0;
                    else graph[i][j][0] = INF;
                }
            }

            for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
                d = Integer.parseInt(st.nextToken());

                graph[u][v][0] = c;
                graph[u][v][1] = d;
            }

            for(int k=1; k<=N; k++) {
                for(int i=1; i<=N; i++) {
                    for(int j=1; j<=N; j++) {
                        if (graph[i][k][0] + graph[k][j][0] > M) continue;

                        if (graph[i][j][1] == graph[i][k][1] + graph[k][j][1]) {
                            if (graph[i][j][0] > graph[i][k][0] + graph[k][j][0]) {
                                graph[i][j][0] = graph[i][k][0] + graph[k][j][0];
                                graph[i][j][1] = graph[i][k][1] + graph[k][j][1];
                            }
                        } else if (graph[i][j][1] > graph[i][k][1] + graph[k][j][1]) {
                            graph[i][j][0] = graph[i][k][0] + graph[k][j][0];
                            graph[i][j][1] = graph[i][k][1] + graph[k][j][1];
                        }
                    }
                }
            }

            for(int i=0; i<=N; i++) {
                for(int j=0; j<=N; j++) {
                    System.out.print(graph[i][j][1]);
                }
                System.out.println();
            }

        }

        



    }

}
