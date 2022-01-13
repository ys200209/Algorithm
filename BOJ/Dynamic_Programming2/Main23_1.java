import java.io.*;
import java.util.*;

public class Main23_1 {
    public static int T, K, result=(int)1e9;
    public static int[] A;
    public static Integer[] d;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            K = Integer.parseInt(br.readLine());
            A = new int[K+1];
            d = new Integer[K+1];
            
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int j=1;
            while(st.hasMoreTokens()) {
                A[j] = Integer.parseInt(st.nextToken());
                j++;
            }

            d[1] = A[1];

            for(j=1; j<=K; j++) {
                for(int x=1; x<=K; x++) {
                    if (d[j] == null) {
                        d[j] = d[j-1] + A[j];
                    } else {
                        d[j] = Math.min(d[j], d[j-1]+A[j]);
                    }
                }
            }

            System.out.println("d : " + Arrays.toString(d));
        }

    }




}