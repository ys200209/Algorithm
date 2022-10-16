package BOJ.String_Algorithm;

import java.io.*;
import java.util.*;

public class Main7_11721 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int index = 0;
        while (index < str.length()) {
            if (index + 10 >= str.length()) break;
            sb.append(str.substring(index, index+10) + "\n");
            index += 10;
        }

        sb.append(str.substring(index));
        System.out.println(sb);

    }

}
