package BOJ.Shortest_Path;

import java.util.*;
import java.io.*;

public class Main25_2 {
    public static int INF = (int) 1e9;
	public static int N, E, v1, v2;
	public static ArrayList<ArrayList<Node3>> graph = new ArrayList<ArrayList<Node3>>();
	public static Queue<Node3> pq = new PriorityQueue<>();
	public static int[] dp = new int[801];
	
	

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<Node3>());
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new Node3(b, c));
		}

        st = new StringTokenizer(br.readLine(), " ");
			
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		
		int distance = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N) > dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N) ?
				dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N) : dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);

		if (distance >= INF) System.out.println("-1");
		else System.out.println(distance);
		
	}
	
	public static int dijkstra(int start, int end) {
		Arrays.fill(dp, INF);
		
		pq.offer(new Node3(start, 0));
		dp[start] = 0;
		
		while(!pq.isEmpty()) {
			Node3 node = pq.poll();
			int now = node.getIndex();
			int dis = node.getDistance();
			
			if (dp[now] > dis) continue;
			
			for(int i=0; i<graph.get(now).size(); i++) {
				int cost = dp[now] + graph.get(now).get(i).getDistance();
				
				if (cost < dp[graph.get(now).get(i).getIndex()]) {
					dp[graph.get(now).get(i).getIndex()] = cost;
					pq.offer(new Node3(graph.get(now).get(i).getIndex(), cost));
				}
			}
		}
		
		return dp[end];
	}

	static class Node3 implements Comparable<Node3> {

		private int index;
		private int distance;

		public Node3(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}

		public int getIndex() {
			return index;
		}

		public int getDistance() {
			return distance;
		}

		@Override
		public int compareTo(Node3 n1) {
			if (this.getDistance() < n1.getDistance()) {
				return -1;
			}
			return 1;
		}

	}
}

