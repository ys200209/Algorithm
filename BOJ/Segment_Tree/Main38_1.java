import java.io.*;
import java.util.*;

public class Main38_1 {
    static int N, M;
    static int[] number;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        number = new int[N+1];

        st = new StringTokenizer(br.readLine(), " ");
        number[1] = Integer.parseInt(st.nextToken());
        for(int i=2; i<=N; i++) {
            number[i] = number[i-1] + Integer.parseInt(st.nextToken());
        }

        for(int j=0; j<M; j++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append((number[b] - number[a-1]) + "\n");
        }

        System.out.println(sb);
        
    }
    
}