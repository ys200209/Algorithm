import java.io.*;
import java.util.*;

public class Main7_5 {
    static int result=0;
    static int[] spell;
    static String[] str;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine().split("");
        spell = new int[26*2];

        for(int i=0; i<str.length; i++) {
            if ((int)str[i].charAt(0) <= 90) {
                spell[(int)str[i].charAt(0) - 'A'] += 1;
            } else {
                spell[26 + (int)str[i].charAt(0) - 'a'] += 1;
            }
        }

        for(int i=1; i<spell.length; i++) {
            if (spell[result] > 1 && spell[result] == spell[i]) {
                System.out.println("?");
                return;
            }
            result = spell[result] < spell[i] ? i : result;
        }

        result = result <= 25 ? result : result - 26;

        System.out.println((char)(65+result));

    }

}
