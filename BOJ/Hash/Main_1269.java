import java.util.*;
import java.io.*;

public class Main_1269 {
    static int N, M, result=0;
    static Set<Integer> set = new HashSet<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()) {
            if (!set.add(Integer.parseInt(st.nextToken()))) result++;
        }
        
        System.out.println(N + M - (result * 2));



    }

}
