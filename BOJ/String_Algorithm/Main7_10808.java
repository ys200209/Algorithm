package BOJ.String_Algorithm;

import java.io.*;

public class Main7_10808 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("");

        int[] count = new int[26];
        for (String s : split) {
            count[s.charAt(0) - 'a'] += 1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<26; i++) {
            sb.append(count[i] + " ");
        }
        System.out.println(sb);
    }
}
