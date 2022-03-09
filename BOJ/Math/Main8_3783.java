import java.util.*;
import java.io.*;
import java.math.*;

public class Main8_3783 {
    static int T;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        String strNum = "999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999";
        System.out.println("size : " + strNum.length());
        BigDecimal decimal = new BigDecimal(strNum + ".0000000000");

        System.out.println("(test) : " + new BigDecimal(Math.cbrt(decimal.doubleValue())).toPlainString());

        System.out.println("(double Value?) : " + decimal.toPlainString());
        BigDecimal calDecimal = new BigDecimal(Math.cbrt(decimal.doubleValue()));


        System.out.println(calDecimal.setScale(10, RoundingMode.DOWN).toPlainString());
        System.out.println(calDecimal.pow(3).toPlainString());
        // 4.641588833612779E49
        // 46415888336127787981891691991638125325160288354304

        
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            BigDecimal num = new BigDecimal(br.readLine()); 
            
            sb.append(BigDecimal.valueOf(Math.cbrt(num.doubleValue())).setScale(10, RoundingMode.DOWN).toPlainString() + "\n");
        }*/

        System.out.println(sb);

    }

}