import java.io.*;
import java.util.*;

public class Main7_6 {
    static int result=0;
    static String str;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        while(st.hasMoreTokens()) {
            st.nextToken();
            result += 1;
        }

        System.out.println(result);

    }
    
}
