import java.io.*;
import java.util.*;

public class Main9_2 {
    public static int INF = (int) 1e9;
	public static int N, M, X, K;
	public static int[][] graph;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N+1][N+1];
		
		for(int i=0; i<=N; i++) {
			Arrays.fill(graph[i], INF);
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if (i == j) graph[i][j] = 0;
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		X = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}   
		
		int distance = graph[1][K] + graph[K][X];
		
        if (distance >= INF) System.out.println("-1");
        else System.out.println(distance);
	}
	
	
}