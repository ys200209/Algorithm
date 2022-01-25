import java.util.*;
import java.io.*;

public class Main25_1 {
    public static int INF = (int) 1e9;
	public static int V, E, K;
	public static ArrayList<ArrayList<Node2>> graph = new ArrayList<ArrayList<Node2>>();
	public static Queue<Node2> pq = new PriorityQueue<>();
	public static int[] d = new int[6];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		for(int i=0; i<=V; i++) {
			graph.add(new ArrayList<Node2>());
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new Node2(b, c));
		}
		
		Arrays.fill(d, INF);
		
		dijkstra(K);

        for(int i=1; i<=V; i++) {
            if (d[i] == INF) System.out.println("INF");
            else System.out.println(d[i]);
        }
		
	}
	
	public static void dijkstra(int start) {
		pq.offer(new Node2(start, 0));
		d[start] = 0;
		
		while(!pq.isEmpty()) {
			Node2 node = pq.poll();
			int now = node.getIndex();
			int dis = node.getDistance();
			
			if (d[now] > dis) continue;
			
			for(int i=0; i<graph.get(now).size(); i++) {
				int cost = d[now] + graph.get(now).get(i).getDistance();
				
				if (cost < d[graph.get(now).get(i).getIndex()]) {
					d[graph.get(now).get(i).getIndex()] = cost;
					pq.offer(new Node2(graph.get(now).get(i).getIndex(), cost));
				}
			}
			
		}
	}
 
}

class Node2 implements Comparable<Node2>{
	
	private int index;
	private int distance;
	
	public Node2(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}
	
	public int getIndex() {
		return index;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public int compareTo(Node2 n1) {
		if (this.getDistance() < n1.getDistance()) {
			return -1;
		}
		return 1;
	}
	
}