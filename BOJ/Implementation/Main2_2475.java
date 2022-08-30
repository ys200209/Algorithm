package BOJ.Implementation;

import java.io.*;
import java.util.*;

public class Main2_2475 {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int sum = 0;
        while(st.hasMoreTokens()) {
            sum += Math.pow(Double.parseDouble(st.nextToken()), 2);
        }

        System.out.println(sum%10);

    }
}

