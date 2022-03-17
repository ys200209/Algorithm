import java.util.*;
import java.io.*;

public class Main11_1062 {
    static int N, K, result=0;
    static String[] A;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new String[N];
        visited = new boolean[26];

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            A[i] = str.substring(4, str.length()-4);
        }
        
        if (K >= 26) {
            System.out.println(N);
            return;
        }

        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;
        K -= 5;

        DFS(0, 0);
        
        System.out.println(result);
    }

    public static void DFS(int index, int count) {
        if (count >= K) {
            int check = 0;
            for(String str : A) {
                boolean read = true;
                for(int i=0; i<str.length(); i++) {
                    if (!visited[str.charAt(i) - 'a']) {
                        read = false;
                        break;
                    }
                }
                if (read) check++;
            }
            if (check != 0) result = Math.max(result, check);
            return;
        }

        for(int i=index; i<26; i++) {
            if(!visited[i]) {
                visited[i] = true;
                DFS(index+1, count+1);
                visited[i] = false;
            }
        }


    }

}