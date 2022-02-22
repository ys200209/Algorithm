import java.util.*;
import java.io.*;

public class Main_11478 {
    static String s;
    static Set<String> set = new HashSet<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();

        for(int i=1; i<=s.length(); i++) {
            for(int j=i; j<=s.length(); j++) {
                set.add(s.substring(j-i, j));
            }
        }

        System.out.println(set.size());

    }

}