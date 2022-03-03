import java.util.*;
import java.io.*;

public class Main16_11497 {
    static int T, N, result=0;
    static int[] A, B;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            N = Integer.parseInt(br.readLine());
            A = new int[N];
            B = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int i=0;
            while(st.hasMoreTokens()) {
                A[i] = Integer.parseInt(st.nextToken());
                i++;
            }
            
            DFS(0);

        }

    }

    public static void DFS(int count) {

        
    }

}