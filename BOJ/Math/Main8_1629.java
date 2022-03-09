import java.util.*;
import java.io.*;
import java.math.*;

public class Main8_1629 {
    static String A, C;
    static int B;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        BigDecimal A = new BigDecimal(st.nextToken());
        BigDecimal B = new BigDecimal(st.nextToken());
        BigDecimal C = new BigDecimal(st.nextToken());

        BigDecimal result = A.remainder(C);
        
        for(int i=0; i<B.intValue(); i++) {
            BigDecimal decimal = (result.multiply(A.remainder(C)));
            result.multiply(decimal.divideAndRemainder(C)[1]);
        }

        System.out.println(result.intValue());
        
    }

}