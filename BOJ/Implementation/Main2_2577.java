package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2_2577 {
    static long A, B, C;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        A = Integer.parseInt(br.readLine());
        B = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());

        for(String s : String.valueOf(A*B*C).split("")) {
            int n = Integer.parseInt(s);
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<=9; i++) {
            sb.append((map.get(i) == null ? 0 : map.get(i)) + "\n");
        }

        System.out.println(sb);

    }

}
