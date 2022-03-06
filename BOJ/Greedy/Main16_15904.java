import java.util.*;
import java.io.*;

public class Main16_15904 {
    static int ucpcIndex;
    static String[] str, UCPC;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine().split("");

        UCPC = new String[]{"U", "C", "P", "C"};

        for(String s : str) {
            if (ucpcIndex > 3) break;

            if (s.equals(UCPC[ucpcIndex])) ucpcIndex++;
        }

        if (ucpcIndex > 3) System.out.println("I love UCPC");
        else System.out.println("I hate UCPC");

    }

}
