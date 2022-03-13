import java.util.*;
import java.io.*;

public class Main29_1 {
    static int N, M;
    static int[] parent;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];

        for(int i=0; i<=N; i++) {
            parent[i] = i;
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int command = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (command == 0) union(A, B);
            else {
                if (isSameParent(A, B)) sb.append("YES\n");
                else sb.append("NO\n");
            }

        }
        System.out.println(sb);
    }

    public static void union(int A, int B) {
        int rootA = find(A);
        int rootB = find(B);    

        if (rootA < rootB) parent[rootB] = rootA;
        else parent[rootA] = rootB;
    }

    public static int find(int root) {
        if (parent[root] == root) return root;

        return parent[root] = find(parent[root]);
    }

    public static boolean isSameParent(int A, int B) {
        int rootA = find(A);
        int rootB = find(B);

        if (rootA == rootB) return true;
        else return false;
    }

}