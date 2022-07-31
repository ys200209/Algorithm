import java.util.*;
import java.io.*;

public class Main16_1343 {
    static String S; 
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        String A = "AAAA";
        String B = "BB";

        S = S.replaceAll("XXXX", A);
        S = S.replaceAll("XX", B);

        if (S.contains("X")) System.out.println("-1");
        else System.out.println(S);
    }
}
