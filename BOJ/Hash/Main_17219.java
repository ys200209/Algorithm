import java.util.*;
import java.io.*;

public class Main_17219 {
    static int N, M;
    static Map<String, String> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            map.put(st.nextToken(), st.nextToken());
        }

        for(int i=0; i<M; i++) {
            sb.append(map.get(br.readLine()) + "\n");
        }
        System.out.println(sb);
    }
}