import java.util.*;
import java.io.*;

public class Main_Internship_1 {
    static Map<String, Integer> map = new HashMap<>();
    static String[] list = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    // static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        System.out.println(solution("one4seveneight")); // 1478 
        System.out.println(solution("2three45sixseven")); // 234567 
        System.out.println(solution("123")); // 123 

    }

    public static int solution(String s) {
        String answer = "";

        int i=0;
        for(String str : list) {
            map.put(str, i);
            i++;
        }

        int start = 0;
        int end = 1;
        while(start < s.length()) {
            if (s.charAt(start) - '0' >= 0 && s.charAt(start) - '0' <= 9) {
                answer += (s.charAt(start) - '0');
                start += 1;
                end += 1;
                continue;
            }

            
            if (map.get(s.substring(start, end)) == null) {
                end += 1;
            } else {
                answer += map.get(s.substring(start, end));
                start = end;
                end += 1;
            }

        }

        return Integer.parseInt(answer);
    }

}