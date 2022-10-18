package BOJ.String_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main7_11719 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String str = null;
        while((str = br.readLine()) != null) {
            System.out.println();
            sb.append(str + "\n");
            System.out.println(sb);
        }
        System.out.println(sb);
    }
}
