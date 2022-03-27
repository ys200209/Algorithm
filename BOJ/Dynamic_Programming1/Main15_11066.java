import java.util.*;
import java.io.*;

public class Main15_11066 {
    static int T, K;
    static int[] A, dp;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            K = Integer.parseInt(br.readLine());
            A = new int[K+1];
            dp = new int[K+1];

            st = new StringTokenizer(br.readLine(), " ");
            int i=1;
            while(st.hasMoreTokens()) {
                A[i] = Integer.parseInt(st.nextToken());
                i++;
            }

            


        }
        

    }

}
