package BOJ.Brute_Force;

import java.io.*;
import java.util.*;

public class Main11_1799 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int answer = 0;

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String binaryString = Integer.toBinaryString(N);
        System.out.println("Integer.toBinaryString(N) = " + binaryString);

        int binary = Integer.parseInt(binaryString, 2);
        System.out.println("binary = " + binary);

        while(Integer.bitCount(N) > K) {
            answer++;

            N++;
        }

        System.out.println("answer = " + answer);

    }
}