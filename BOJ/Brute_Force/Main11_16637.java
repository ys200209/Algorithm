package BOJ.Brute_Force;

import java.io.*;
import java.util.*;

public class Main11_16637 {
    static int N;
    static List<Integer> numbers = new ArrayList<>();
    static List<String> cals = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        String[] split = br.readLine().split("");
        for(int i=0; i<N; i++) {
            if (i % 2 == 0) numbers.add(Integer.parseInt(split[i]));
            else cals.add(split[i]);
        }

        System.out.println("numbers = " + numbers);




    }

}