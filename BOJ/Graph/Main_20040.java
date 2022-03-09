import java.util.*;
import java.io.*;

public class Main_20040 {
    static int N, M, result=0;
    static int[] parent;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N];

        for(int i=0; i<N; i++) {
            parent[i] = i;
        }

        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            if (union(A, B)) {
                result = i;
                break;
            }
        }
        System.out.println(result);
        return;
    }

    public static boolean union(int A, int B) {
        int rootA = find(A);
        int rootB = find(B);
        if (rootA == rootB) return true;

        parent[rootB] = rootA;
        return false;
    }

    public static int find(int child) {
        if (child == parent[child]) return child;

        return parent[child] = find(parent[child]);
    }

}