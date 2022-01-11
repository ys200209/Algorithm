import java.io.*;
import java.util.*;

public class Main7_8 {
    static int index, count, result=0;
    static int[] ASCII, dial;
    static String str;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        ASCII = new int[26];
        dial = new int[10];
        dial[1] = 2;

        for(int i=2; i<10; i++) {
            dial[i] = dial[i-1] + 1;
        }

        for(int i=2; i<10; i++) {
            if (i == 7 || i == 9) count = 4;
            else count = 3;

            for(int j=0; j<count; j++) {
                ASCII[index] = dial[i];
                index++;
            }
        }
        
        for(int i=0; i<str.length(); i++) {
            result += ASCII[str.charAt(i) - 'A'];
        }

        System.out.println(result);

    }
    
}
