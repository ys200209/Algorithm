import java.io.*;
import java.util.*;

public class Main23_1 {
    static int T, K;
    static int[] d;
    static ArrayList<Integer> A;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            K = Integer.parseInt(br.readLine());
            A = new ArrayList<>();
            d = new int[K+1];
            A.add(0);

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int j=0;
            while(st.hasMoreTokens()) {
                A.add(Integer.parseInt(st.nextToken()));
                j++;
            }

            Collections.sort(A, Collections.reverseOrder());
            

            d[1] = A.get(1);

            for(j=2; j<=K; j++) {
                d[j] = d[j-1] + A.get(j);
            }

            System.out.println(Arrays.toString(d));

        }
        


    }
    
}
