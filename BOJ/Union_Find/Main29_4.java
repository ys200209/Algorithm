import java.util.*;
import java.io.*;

public class Main29_4 {
    static int N, M;
    // static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] parent;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];

        for(int i=1; i<=N; i++) {
            parent[i] = i;
        }

        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            if (union(A, B)) {
                System.out.println(i);
                return;
            }
        }

        System.out.println("0");
        return;
    }

    public static boolean union(int A, int B) {
        int rootA = find(A);
        int rootB = find(B);

        if (rootA == rootB) return true;

        parent[rootB] = rootA;
        return false;
    }

    public static int find(int root) {
        if (parent[root] == root) return root;

        return parent[root] = find(parent[root]);
    }

}