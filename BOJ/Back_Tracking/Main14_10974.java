import java.util.*;
import java.io.*;

public class Main14_10974 {
    static String str = "";
    static int N;
    static int[] A;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        visited = new boolean[N];

        for(int i=1; i<=N; i++) {
            A[i-1] = i;
        }

        DFS(0);

        System.out.println(sb);
    }

    public static void DFS(int count) {
        if (count == N) {
            sb.append(str + "\n");
            return;
        }

        for(int i=0; i<N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                String num = Integer.toString(A[i]);
                str += num + " ";
                DFS(count+1);
                str = str.substring(0, str.length() - num.length() - 1);
                visited[i] = false;
            }
        }

    }

}
