import java.io.*;
import java.util.*;

public class Main7_7 {
    static String reverse_A="", reverse_B="", result;
    static String[] A, B;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        while(st.hasMoreTokens()) {
            A = st.nextToken().split("");
            B = st.nextToken().split("");
        }
        
        for(int i=2; i>=0; i--) {
            reverse_A += A[i];
            reverse_B += B[i];
        }

        result = Integer.parseInt(reverse_A) > Integer.parseInt(reverse_B) ? reverse_A : reverse_B;

        System.out.println(result);

    }
    
}
