import java.util.*;
import java.io.*;

public class Main25_5 {
    public static int INF = (int) 1e9;
	public static int N, M;
	public static int[][] graph;
    public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		graph = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			Arrays.fill(graph[i], INF);
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if (i == j) graph[i][j] = 0;
			}
		}
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a][b] = Math.min(graph[a][b], c);
		}
		
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if (graph[i][j] == INF) sb.append("0 ");
				else sb.append(graph[i][j] + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}