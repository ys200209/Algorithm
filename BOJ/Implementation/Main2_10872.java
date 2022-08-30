package BOJ.Implementation;

import java.io.*;
import java.util.*;

public class Main2_10872 {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(factorial(n));
    }

    public static long factorial(int n) {
        if (n <= 1) return 1;
        else return n * factorial(n-1);
    }

}
