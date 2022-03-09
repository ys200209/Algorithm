import java.util.*;
import java.io.*;

public class Main9_2 {
    static int N, M, MIN=(int)1e9, result=0;
    static boolean[] A;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        M = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());

        A = new boolean[10001];
        A[1] = true;
        for(int i=2; i<=N; i++) {
            for(int j=i*2; j<=N; j+=i) {
                A[j] = true;
            }
        }

        for(int i=M; i<=N; i++) {
            if (!A[i]) {
                MIN = Math.min(MIN, i);
                result += i;
            }
        }

        if (MIN == (int)1e9) System.out.println("-1");
        else System.out.println(result + "\n" + MIN);

    }

}