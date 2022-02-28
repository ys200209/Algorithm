import java.util.*;
import java.io.*;

public class Main16_2810 {
    static int N, holder=1, people=0;
    static String str;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        str = br.readLine();

        int i=0;
        while(i < str.length()) {
            if (str.substring(i, i+1).equals("S")) {
                i++;
            } else {
                i+=2;
            }

            holder++;
        }


        if (holder >= str.length()) System.out.println(str.length());
        else System.out.println(holder);


    }

}
