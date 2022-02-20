import java.util.*;
import java.io.*;

public class Main_4195 {
    static int T, F;
    static Map<String, Integer> friend; // 
    static Set<String> set;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            friend = new HashMap<>();

            F = Integer.parseInt(br.readLine());
            for(int i=0; i<F; i++) {
                set = new HashSet<>();
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String A = st.nextToken();
                String B = st.nextToken();
                
                friend.put(A, friend.getOrDefault(A, 0) + 1);
                friend.put(B, friend.getOrDefault(B, 0) + 1);
                int total = (friend.get(A) + (1 - friend.get(A))) + (friend.get(B) - (1 - friend.get(B)));
                sb.append(total + "\n");

                friend.put(A, total);
                friend.put(B, total);

            }
        }
        System.out.println("---------------");
        System.out.println(sb);
    }
}