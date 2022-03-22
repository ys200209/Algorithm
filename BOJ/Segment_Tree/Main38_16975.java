import java.util.*;
import java.io.*;

public class Main38_16975 {
    static int N, M;
    static int[] A, tree;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        tree = new int[N*4];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int i=0;
        while(st.hasMoreTokens()) {
            A[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        init(1, N, 1);
        
        M = Integer.parseInt(br.readLine());

        for(i=0; i<M; i++) {
            
        }

    }

}
