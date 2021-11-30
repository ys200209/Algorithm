import java.util.*;

public class Main91 {public static final int INF = (int)1e9;
	public static int n, m, start;
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	public static int[] d = new int[100001];
	public static boolean[] visited = new boolean[100001];
	

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		n = scanner.nextInt();
		m = scanner.nextInt();
		start = scanner.nextInt();
		
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		for(int i=0; i<m; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int c = scanner.nextInt();
			
			graph.get(a).add(new Node(b, c));
		}
		
		Arrays.fill(d, INF);
		
		dijkstra(start);
		
		
	}
	
	public static void dijkstra(int start) {
		
		d[start] = 0;
		visited[start] = true;
		
		for(int i=0; i<graph.get(start).size(); i++) {
			d[i] = graph.get(start).get(i).getDistance();
		}
		
		for(int i=0; i<n; i++) {
			int now = getSmallestNode();
			visited[now] = true;
			
			for(int j=0; j<graph.get(now).size(); j++) {
				int cost = d[i] + d[graph.get(now).get(j).getIndex()];
				if (cost < d[i]) {
					d[i] = graph.get(now).get(j).getDistance();
				}
			}
		}
		
	}
	
	public static int getSmallestNode() {
		int min_value = INF;
		int index = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<graph.get(i).size(); j++) {
				if (graph.get(i).get(j).getDistance() < min_value) {
					min_value = graph.get(i).get(j).getDistance();
					index = i;
				}
			}
		}
		
		return index;
	}
	
	
}

class Node {
	
	private int index;
	private int distance;
	
	public Node(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public int getDistance() {
		return this.distance;
	}
	
}