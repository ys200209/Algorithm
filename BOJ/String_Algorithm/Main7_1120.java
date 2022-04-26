import java.util.*;
import java.io.*;

public class Main7_1120 {
    static int MIN = (int)1e9;
    static String A, B;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        A = st.nextToken();
        B = st.nextToken();
        
        for(int i=0; i<=B.length()-A.length(); i++) {
            int n = A.length();
            for(int j=0; j<A.length(); j++) {
                if (A.charAt(j) == B.charAt(i+j)) n--;
            }

            MIN = Math.min(MIN, n);
        }

        System.out.println(MIN);
    }
}