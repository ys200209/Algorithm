import java.util.*;
import java.io.*;

public class Main16_14659 {
    static int N, MAX=0;
    static int[] A, count;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        count = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int i=0;
        while(st.hasMoreTokens()) {
            A[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        for(i=0; i<N; i++) {
            for(int j=i+1; j<N; j++) {
                if (A[i] > A[j]) count[i]++;
                else break;
            }
            MAX = Math.max(MAX, count[i]);
        }

        System.out.println(MAX);

    }

}