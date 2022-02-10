import java.util.*;
import java.io.*;

public class Main7_10 {
    static int N, result=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            Map<String, Integer> map = new HashMap<>();

            String before = "";

            int j;
            for(j=0; j<str.length(); j++) {
                if (str.substring(j, j+1).equals(before)) continue;

                before = str.substring(j, j+1);

                if (map.get(before) != null) break;

                map.put(before, 1);
            }

            if (j == str.length()) result++;

        }

        System.out.println(result);


    }
    
}