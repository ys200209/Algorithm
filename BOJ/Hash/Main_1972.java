import java.util.*;
import java.io.*;

public class Main_1972 {
    static Set<String> set;
    static StringBuilder sb = new StringBuilder();
    static boolean isSurprise;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String str = br.readLine();
            String[] list = str.split("");

            if (list[0].equals("*")) break;

            
            isSurprise = true;
            
            for(int step=0; step<=list.length-2; step++) { // step ½Ö
                set = new HashSet<>();
                for(int i=0; i+step+1<list.length; i++) {
                    if(!set.add(list[i] + list[i+step+1])) {
                        sb.append(str + " is NOT surprising.\n");
                        isSurprise = false;
                        break;
                    }
                }
                if (!isSurprise) break;
            }

            if (isSurprise) sb.append(str + " is surprising.\n");

        }
        
        System.out.println(sb);
        
    }

}