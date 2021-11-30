import java.util.*;

public class Main92 {
	public static final int INF = (int)1e9;
	public static int n, m, start;
	public static ArrayList<ArrayList<Node1>> graph = new ArrayList<>();
	public static Queue<Node1> pq = new PriorityQueue<>();
	public static int[] d = new int[100001];

	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		n = scanner.nextInt();
		m = scanner.nextInt();
		start = scanner.nextInt();
		
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<Node1>());
		}
		
		for(int i=0; i<m; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int c = scanner.nextInt();
			
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
			int dis = node.getDistance();
			
			if (d[now] < dis) continue;
			
			for(int j=0; j<graph.get(now).size(); j++) {
				int cost = d[j] + d[graph.get(now).get(j).getIndex()];
				if (cost < d[graph.get(now).get(j).getIndex()]) {
					d[graph.get(now).get(j).getIndex()] = 
							graph.get(now).get(j).getDistance();
					pq.offer(new Node1(graph.get(now).get(j).getIndex(), cost));
				}
			}
			
		}
		
		
	}
	
	
}

class Node1 implements Comparable<Node1> {
	
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