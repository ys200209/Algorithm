package BOJ.String_Algorithm;

import java.io.*;

public class Main7_1259 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String[] split = br.readLine().split("");
            if (split[0].equals("0")) break;

            int i=0;
            for(i=0; i<split.length; i++) {
                if (!split[i].equals(split[split.length-i-1])) break;
            }

            if (i == split.length) sb.append("yes\n");
            else sb.append("no\n");
        }
        System.out.println(sb);
    }

}
