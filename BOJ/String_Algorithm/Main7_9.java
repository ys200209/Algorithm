import java.io.*;
import java.util.*;

public class Main7_9 {
    static int result=0;
    static String str;
    static String[] spell = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        List<String> list = Arrays.asList(spell);

        int i=0;
        while(i < str.length()) {
            boolean isContains = false;

            for(int j=3; j>1; j--) {
                int index = i + j;
                if (index <= str.length()) {
                    if (list.contains(str.substring(i, i+j))) {
                        isContains = true;
                        result++;
                        i += j;
                        break;
                    }
                }
            }

            if (!isContains) {
                result++;
                i++;
            }
        }

        System.out.println(result);

    }
    
}