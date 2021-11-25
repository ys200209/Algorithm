import java.util.*;

public class Main92 {
	public static final int INF = (int) 1e9;
	public static int n, m, start;
	public static ArrayList<ArrayList<Node1>> graph = new ArrayList<>();
	public static int[] d = new int[100001];
	public static Queue<Node1> pq = new PriorityQueue<>();
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		start = sc.nextInt();
		
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<Node1>());
		}
		
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			graph.get(a).add(new Node1(b, c));
		}
		
		Arrays.fill(d, INF);
		
		dijkstra(start);
		
		
	}
	
	public static void dijkstra(int start) {
		
		pq.offer(new Node1(start, 0));
		d[start] = 0;
		
		while(!pq.isEmpty()) {
			Node1 node = pq.poll();
			int now = node.getIndex();
			int distance = node.getDistance();
			
			if (d[now] < distance) continue;
			
			for(int i=0; i<graph.get(now).size(); i++) {
				int cost = d[now] + graph.get(now).get(i).getDistance();
				
				if (cost < d[graph.get(now).get(i).getIndex()]) {
					d[graph.get(now).get(i).getIndex()] = cost;
					pq.offer(new Node1(graph.get(now).get(i).getIndex(), cost));
				}
			}
		}
	}
}

class Node1 implements Comparable<Node1>{
	
	private int index;
	private int distance;
	
	public Node1(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public int getDistance() {
		return this.distance;
	}
	
	@Override
	public int compareTo(Node1 n1) {
		if (this.distance < n1.distance) {
			return -1;
		}
		return 1;
	}
	
}