import java.util.*;
import java.io.*;

public class Main7_5052 {
    static int T, N;
    static String[] list;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            N = Integer.parseInt(br.readLine());
            list = new String[N];
            boolean isSearch = false;

            for(int i=0; i<N; i++) {
                list[i] = br.readLine();
            }

            Arrays.sort(list);

            for(int i=0; i<N-1; i++) {
                if (list[i].startsWith(list[i+1]) || list[i+1].startsWith(list[i])) {
                    isSearch = true;
                    break;
                }
            }

            // System.out.println("list : " + Arrays.toString(list));

            if (isSearch) sb.append("NO\n");
            else sb.append("YES\n");
        }
        System.out.println(sb);
    }
}