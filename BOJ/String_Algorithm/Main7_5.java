import java.io.*;
import java.util.*;

public class Main7_5 {
    static int count=0;
    static String[] S;
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        String answer = "";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine().toUpperCase().split("");

        for(int i=0; i<S.length; i++) {
            if (map.get(S[i]) == null) map.put(S[i], 1);
            else map.put(S[i], map.get(S[i]) + 1);
        }

        for(String str : map.keySet()) {
            if (map.get(str) > count) {
                answer = "";
                answer += str;
                count = map.get(str);
            } else if (map.get(str) == count) {
                answer += str;
            }
        }

        if (answer.length() == 1) System.out.println(answer);
        else System.out.println("?");

    }

}