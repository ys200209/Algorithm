import java.util.*;

public class Main9_2 {
    public static final int INF = (int) 1e9;
	public static int n, m, start; // 노드의 개수(N), 간선의 개수(M), 시작 노드 번호(Start). (N <= 100,000)
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<>(); // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
	public static boolean[] visited = new boolean[100001]; // 방문한 적이 있는지 체크하는 목적의 배열 만들기
	public static int[] d = new int[100001]; // 최단 거리 테이블 만들기
	
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		n = scanner.nextInt();
		m = scanner.nextInt();
		start = scanner.nextInt();
		
		// 그래프 초기화
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		// 모든 간선 정보를 입력받음
		for (int i=0; i<m; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int c = scanner.nextInt();
			
			// a번 노드에서 b번 노드로 가는 비용이 c이다
			graph.get(a).add(new Node(b, c));
		}
		
		// 최단 거리 테이블을 모두 무한으로 초기화
		Arrays.fill(d, INF);
		
		// 다익스트라 알고리즘을 수행
		dijkstra(start);
		
		

	}
	
	public static void dijkstra(int start) {
		// 시작 노드에 대해서 초기화
		d[start] = 0;
		visited[start] = true;
		
		for(int j=0; j<graph.get(start).size(); j++) {
			d[graph.get(start).get(j).getIndex()] = // a에서 b로 가는게
					graph.get(start).get(j).getDistance(); // c의 비용이다. 라는 의미같음
		}
		
		// 시작 노드를 제외한 전체 n-1개의 노드에 대해 반복
		for(int i=0; i<n-1; i++) {
			// 현재 최단 거리가 가장 짧은 노드를 꺼내서, 방문 처리
			int now = getSmallestNode();
			visited[now] = true; // 방문 처리
			
			// 현재 노드와 연결된 다른 노드를 확인
			for(int j=0; j<graph.get(now).size(); j++) {
				int cost = d[now] + graph.get(now).get(j).getDistance();
				
				// 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
				if (cost < d[graph.get(now).get(j).getIndex()]) {
					d[graph.get(now).get(j).getIndex()] = cost;
				}
			}
		}
	}
	
	public static int getSmallestNode() {
		int min_value = INF;
		int index = 0; // 가장 최단 거리가 짧은 노드 (인덱스)
		
		for(int i=1; i<=n; i++) {
			if (d[i] < min_value && !visited[i]) { // 아직 방문하지 않은 노드이면서 최단 거리 테이블값이 가장 짧다면
				min_value = d[i]; // 최소값을 최단 거리 비용만큼으로 변경함
				index = i;
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
