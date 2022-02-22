import java.util.*;
import java.io.*;

public class Main_ICPC_1 {
    static int C, MAX=0;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        C = Integer.parseInt(br.readLine());

        for(int i=0; i<C; i++) {
            String str = br.readLine();
            int result = 0;
            int index = 0;
            while(index < str.length()) {
                if (index+3 <= str.length()) {
                    if (str.substring(index, index+3).equals("for")) {
                        index += 3;
                        result++;
                        continue;
                    }
                }

                if (index+5 <= str.length()) {
                    if (str.substring(index, index+5).equals("while")) {
                        index += 5;
                        result++;
                        continue;
                    }
                }
                index++;
            }
            MAX = Math.max(MAX, result);
        }
        System.out.println(MAX);
    }

}