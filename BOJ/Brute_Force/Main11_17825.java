package BOJ.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main11_17825 {

    public static void main(String[] args) throws IOException {

//        System.out.println(solution(5)); // 2
        System.out.println(solution(5000)); // 5
//        System.out.println(solution(10000)); //


    }

    public static int solution(int n) {
        return recursive(n);
    }

    private static int recursive(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        if (n % 2 == 0) return recursive(n/2);
        else return recursive(n/2) + 1;
    }

}