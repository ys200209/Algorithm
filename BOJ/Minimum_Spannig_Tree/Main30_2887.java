import java.util.*;
import java.io.*;

public class Main30_2887 {
    static long result=0;
    static int N;
    static int[] parents;
    static Planet[] planets;
    static Queue<Node> pq = new PriorityQueue<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        planets = new Planet[N];
        parents = new int[N];

        for(int i=0; i<N; i++) parents[i] = i;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            planets[i] = new Planet(i, x, y, z);
        }
        
        Arrays.sort(planets, (p1, p2) -> {
            return p1.x - p2.x;
        });
        for(int i=0; i<N-1; i++) {
            int dis = Math.abs(planets[i].x - planets[i+1].x);
            pq.offer(new Node(planets[i].index, planets[i+1].index, dis));
        }

        Arrays.sort(planets, (p1, p2) -> {
            return p1.y - p2.y;
        });
        for(int i=0; i<N-1; i++) {
            int dis = Math.abs(planets[i].y - planets[i+1].y);
            pq.offer(new Node(planets[i].index, planets[i+1].index, dis));
        }

        Arrays.sort(planets, (p1, p2) -> {
            return p1.z - p2.z;
        });
        for(int i=0; i<N-1; i++) {
            int dis = Math.abs(planets[i].z - planets[i+1].z);
            pq.offer(new Node(planets[i].index, planets[i+1].index, dis));
        }

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int A = node.from;
            int B = node.to;

            if (!union(A, B)) result += node.distance;
        }
        System.out.println(result);
    }

    public static boolean union(int A, int B) {
        int rootA = find(A);
        int rootB = find(B);

        if (rootA == rootB) return true;

        if (rootA < rootB) parents[rootB] = rootA;
        else parents[rootA] = rootB;
        return false;
    }

    public static int find(int root) {
        if (parents[root] == root) return root;

        return parents[root] = find(parents[root]);
    }

}

class Planet {

    int index;
    int x;
    int y;
    int z;

    public Planet(int index, int x, int y, int z) {
        this.index = index;
        this.x = x;
        this.y = y;
        this.z = z;
    }

}

class Node implements Comparable<Node> {

    int from;
    int to;
    int distance;

    public Node(int from, int to, int distance) {
        this.from = from;
        this.to = to;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node node) {
        return this.distance - node.distance;
    }

}