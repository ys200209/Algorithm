import java.util.*;
import java.io.*;

public class Main_2776 {
    static int T, N, M;
    static Set<Integer> set;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            set = new HashSet<>();
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()) {
                set.add(Integer.parseInt(st.nextToken()));
            }

            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                if (set.contains(num)) sb.append("1\n");
                else sb.append("0\n"); 
            }
        }
        System.out.println(sb);

    }

}
