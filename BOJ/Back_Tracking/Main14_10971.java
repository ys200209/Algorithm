import java.util.*;
import java.io.*;

public class Main14_10971 {
    static int N, cost=0, result=(int)1e9;
    static int[][] W;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        visited = new boolean[N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int j=0;
            while(st.hasMoreTokens()) {
                W[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }


        
        for(int i=0; i<N; i++) {
            visited[i] = true;
            DFS(i, i, 0);
            visited[i] = false;
        }

        System.out.println(result);
    }

    public static void DFS(int start, int index, int count) {
        if (count == N-1) {
            if (W[index][start] != 0) result = Math.min(result, cost + W[index][start]);
            return;
        }
        
        for(int j=0; j<N; j++) {
            if (W[index][j] == 0) continue;

            if (!visited[j]) {
                visited[j] = true;
                System.out.println("[" + index + ", " + j + "]");
                cost += W[index][j];
                DFS(start, j, count+1);
                cost -= W[index][j];
                visited[j] = false;
            }
        }
        
        
    }
}