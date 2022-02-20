import java.util.*;
import java.io.*;

public class Main_5568 {
    static String str = "";
    static int N, M;
    static String[] A;
    static boolean[] visited;
    static Set<String> set = new HashSet<>();
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        A = new String[N];
        visited = new boolean[N];

        for(int i=0; i<N; i++) {
            A[i] = br.readLine();
        }

        DFS(0);

        System.out.println(set.size());
    }

    public static void DFS(int count) {
        if (count == M) {
            set.add(str);
            return;
        }

        for(int i=0; i<N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                str += A[i];
                DFS(count+1);
                str = str.substring(0, str.length() - A[i].length());
                visited[i] = false;
            }
        }
    

    }

}