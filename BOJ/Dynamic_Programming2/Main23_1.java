import java.io.*;
import java.util.*;

public class Main23_1 {
    static int result=0;
    static int[] A;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = new int[3];

        int i=0;
        while(st.hasMoreTokens()) {
            A[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        Arrays.sort(A);

        if (A[0] == A[1] && A[1] == A[2]) {
            result = 10000 + A[0]*1000;
        } else if (A[0] == A[1] || A[1] == A[2]) {
            result = 1000 + A[1]*100;
        } else {
            result = A[2]*100;
        }
        
        System.out.println(result);
    }
}