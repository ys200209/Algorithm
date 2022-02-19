import java.util.*;
import java.io.*;

public class Main_9375 {
    static int T, N;
    static Map<String, Integer> map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            map = new HashMap<>();
            N = Integer.parseInt(br.readLine());

            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " "); 
                String A = st.nextToken();
                String B = st.nextToken();

                map.put(B, map.getOrDefault(B, 0) + 1);
            }
            
            int ans = 1;
            for(String s : map.keySet()) {
                ans *= map.get(s)+1;
            }
            sb.append((ans-1) + "\n");
            
        }
        System.out.println(sb);
    }

}