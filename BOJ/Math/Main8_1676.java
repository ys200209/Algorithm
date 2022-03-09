import java.util.*;
import java.io.*;
import java.math.BigDecimal;

public class Main8_1676 {
    static int N, result=0;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        BigDecimal decimal = new BigDecimal("1");

        for(int i=1; i<=N; i++) {
            decimal = decimal.multiply(new BigDecimal(Integer.toString(i)));
        }

        String str = decimal.toPlainString();
        //System.out.println(str);
        for(int i=str.length()-1; i>=0; i--) {
            if (str.charAt(i) - '0' != 0) break;
            result++;
        }

        System.out.println(result);

    }

}