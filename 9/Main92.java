
import java.util.*;

public class Main92 {
	public static final int INF = (int)1e9;
	public static PriorityQueue<Node1> pq = new PriorityQueue<>();
	public static int n, m, start;
	public static ArrayList<ArrayList<Node1>> graph = new ArrayList<>();
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
		
		Arrays.fill(d, INF);;
		
		dijkstra(start);
		
	}
	
	public static void dijkstra(int start) {
		
		pq.offer(new Node1(start, 0));
		d[start] = 0;
		
		while(!pq.isEmpty()) {
			Node1 node = pq.poll();
			int index = node.getIndex();
			int distance = node.getDistance();
			
			if (d[index] < distance) continue;
			
			for(int i=0; i<graph.get(index).size(); i++) {
				int cost = d[i] + graph.get(index).get(i).getDistance();
				if (d[graph.get(index).get(i).getIndex()] > cost) {
					d[graph.get(index).get(i).getIndex()] = cost;
					pq.offer(new Node1(graph.get(index).get(i).getIndex(), cost));
				}
			}
		}
		
	}
	
}

class Node1 implements Comparable<Node1>{
	
	private int index;
	private int distance;
	
	public Node1 (int index, int distance) {
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