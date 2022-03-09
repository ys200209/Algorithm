import java.util.*;
import java.io.*;

public class Main9_1 {
    static int N, count=0;
    static int[] A;
    static boolean[] X;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int i=0;
        while(st.hasMoreTokens()) {
            A[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        X = new boolean[1001];
        X[1] = true;
        for(i=2; i<1001; i++) {
            if (!X[i]) {
                for(int j=i*2; j<1001; j+=i) {
                    X[j] = true;
                }
            }
        }

        for(int num : A) {
            if (!X[num]) count++;
        }

        System.out.println(count);

    }

}
