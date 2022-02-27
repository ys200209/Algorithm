import java.util.*;
import java.io.*;

public class Main16_1543 {
    static int result=0;
    static String str, word;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        str = br.readLine();
        word = br.readLine();

        int index=0;
        while(index < str.length()) {
            if (str.substring(index, str.length()).contains(word)) {
                index = str.indexOf(word, index) + word.length();
                result++;
            } else break;
        }

        System.out.println(result);

    }

}
