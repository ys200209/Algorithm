package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2_11866 {
    static int N, K, remove_count=0, K_count;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        K_count = K;

        visited = new boolean[N+1];
        int index = 0;
        while(remove_count != N) {
            index++;

            if (index > N) index=1;
            if (visited[index]) continue;

            K_count--;
            if (K_count == 0) {
                remove(index);
            }
        }
        sb.append(">");

        System.out.println(sb);

    }

    private static void remove(int index) {
        visited[index] = true;
        remove_count++;
        K_count = K;
        if (sb.length() == 0) sb.append("<" + index);
        else sb.append(", " + index);
    }

}
