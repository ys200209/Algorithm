import java.util.*;
import java.io.*;

public class Main_4158 {
    static int N, M;
    static Set<Integer> set;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int count=0;
            set = new HashSet<>();

            if (N==0 && M==0) break;

            for(int i=0; i<N; i++) {
                set.add(Integer.parseInt(br.readLine()));
            }

            for(int i=0; i<M; i++) {
                int num = Integer.parseInt(br.readLine());
                if (set.contains(num)) count++;
            }
            sb.append(count + "\n");
        }
        


        System.out.println(sb);

    }
    
}