import java.util.*;
import java.io.*;

public class Main16_2864 {
    static String A, B;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        A = st.nextToken().replace('6', '5');
        B = st.nextToken().replace('6', '5');
        System.out.print(Integer.parseInt(A) + Integer.parseInt(B));

        A = A.replace('5', '6');
        B = B.replace('5', '6');
        System.out.print(" " + (Integer.parseInt(A) + Integer.parseInt(B)));

    }

}
