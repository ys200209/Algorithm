import java.util.*;
import java.io.*;

public class Main29_2 {
    static int INF = (int)1e9;
    static int N, M;
    static int[][] graph;
    static int[] parent;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new int[N+1][N+1];
        parent = new int[N+1];
        
        for(int i=1; i<=N; i++) {
            parent[i] = i;
        }

        StringTokenizer st;
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int j=1;
            while(st.hasMoreTokens()) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 1) union(i, j);
                j++;
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        int root = find(Integer.parseInt(st.nextToken()));
        while(st.hasMoreTokens()) {
            int child = Integer.parseInt(st.nextToken());

            if (!isSameParent(root, child)) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
        return;
    }

    public static void union(int A, int B) {
        int rootA = find(A);
        int rootB = find(B);

        System.out.println("A : " + A + ", B : " + B + "\nrootA : " + rootA + ", rootB : " + rootB);

        if (rootA < rootB) parent[rootB] = rootA;
        else parent[rootA] = rootB;
    }

    public static int find(int root) {
        if (parent[root] == root) return root;

        return parent[root] = find(parent[root]);
    }

    public static boolean isSameParent(int A, int B) {
        int rootB = find(B);

        if (A == rootB) return true;
        return false;
    }
}