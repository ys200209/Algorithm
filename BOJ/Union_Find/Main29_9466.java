import java.util.*;
import java.io.*;

public class Main29_9466 {
    static int T, N;
    static int[] A;
    static int[] parents;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            N = Integer.parseInt(br.readLine());
            A = new int[N+1];
            parents = new int[N+1];
            visited = new boolean[N+1];
            st = new StringTokenizer(br.readLine(), " ");

            int i=1;
            while(st.hasMoreTokens()) {
                A[i] = Integer.parseInt(st.nextToken());
                union(i, A[i]);
                i++;
            }
            System.out.println(Arrays.toString(visited));
        }
        
        

    }

    public static void union(int A, int B) {
        int rootA = find(A);
        int rootB = find(B);
        
        if (rootA == rootB) {
            visited[A] = true;
            visited[B] = true;
            return;
        }

        if (rootA < rootB) parents[B] = A;
        else parents[A] = B;
    }

    public static int find(int root) {
        if (parents[root] == root) return root;

        return parents[root] = find(parents[root]);
    }

}
