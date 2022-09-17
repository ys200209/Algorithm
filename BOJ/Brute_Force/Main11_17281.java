package BOJ.Brute_Force;

import java.io.*;
import java.util.*;

public class Main11_17281 {
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        System.out.println(solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5})); // TCMA

    }

    public static String solution(String[] survey, int[] choices) {
        String answer = "";

        for(int i=0; i< survey.length; i++) {
            String s = survey[i];
            String[] split = s.split("");
            String A = split[0];
            String B = split[1];
            int choice = choices[i];

            MBTI(A, B, choice);
        }

        answer += getMBTI("R", "T");
        answer += getMBTI("C", "F");
        answer += getMBTI("J", "M");
        answer += getMBTI("A", "N");

        return answer;
    }

    public static void MBTI(String A, String B, int choice) {
        if (choice < 4) {
            map.put(A, map.getOrDefault(A, 0) + (4 - choice));
        } else if (choice > 4) {
            map.put(B, map.getOrDefault(B, 0) + (choice - 4));
        }
    }

    public static String getMBTI(String A, String B) {
        if (map.get(A) == null && map.get(B) == null) {
            if (A.charAt(0) > B.charAt(0)) return B;
            else return A;
        } else if (map.get(A) == null) {
            return B;
        } else if (map.get(B) == null) {
            return A;
        } else {
            if (map.get(A) > map.get(B)) return A;
            else if (map.get(A) == map.get(B)) {
                if (A.charAt(0) > B.charAt(0)) return B;
                else return A;
            }
            else return B;
        }
    }

}