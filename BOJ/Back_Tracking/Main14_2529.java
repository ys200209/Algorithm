import java.util.*;
import java.io.*;

public class Main14_2529 {
    static int K;
    static String str = "", MAX="0", MIN="9999999999";
    static String[] S;
    static boolean[] visited;

    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        visited = new boolean[10];
        S = new String[K];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int i=0;
        while(st.hasMoreTokens()) {
            S[i] = st.nextToken();
            i++;
        }

        DFS(0);

        System.out.println(MAX + "\n" + MIN);
    }

    public static void DFS(int count) {
        if (count == K+1) {
            MAX = Long.parseLong(MAX) < Long.parseLong(str) ? str : MAX;
            MIN = Long.parseLong(MIN) > Long.parseLong(str) ? str : MIN;
            return;
        }

        for(int i=0; i<=9; i++) {
            if (count != 0) {
                int num = Integer.parseInt(str.substring(str.length()-1, str.length()));
                if (S[count-1].equals("<")) {
                    if (num > i) continue;
                } else {
                    if (num < i) continue;
                }
            }
            if (!visited[i]) {
                visited[i] = true;
                str += i;
                DFS(count+1);
                str = str.substring(0, str.length()-1);
                visited[i] = false;
            }
            
        }
    }

}
