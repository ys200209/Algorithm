package BOJ.Brute_Force;

import java.io.*;
import java.util.*;

public class Main11_1062 {

    public static void main(String[] args) throws IOException {
        System.out.println(solution(" 3people unFollowed me  a WW")); // "3people Unfollowed Me"
//        System.out.println(solution(new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}})); // 120

    }

    public static String solution(String s) {
        String answer = "";
        int index=0;

        String[] words = s.split(" ");
        for(String word : words) {
            if (word.isBlank()) continue;

            if (index == 0) {
                answer += s.substring(0, s.indexOf(word));
                index += s.indexOf(word);
            } else {
                String blank = s.substring(index, index + s.substring(index).indexOf(word));
                answer += blank;
                index += blank.length();
            }

            String newWord = changeWord(word);
            answer += newWord;

            index += word.length();
        }
        answer += s.substring(index);
        return answer;
    }

    private static String changeWord(String word) {
        if (word.charAt(0) - '0' <= 9) return word.toLowerCase();
        else {
            String lowerCase = word.toLowerCase();
            String upperCase = lowerCase.substring(0, 1).toUpperCase();
            return word.length() == 1 ? upperCase : upperCase + lowerCase.substring(1, lowerCase.length());
        }
    }

}