package BOJ.Brute_Force;

import java.io.*;

public class Main11_1062 {

    
    public static void main(String[] args) throws IOException {
        System.out.println(solution("  try    try   world  hello   try")); // "TrY HeLlO WoRlD"

    }

    public static String solution(String s) {
        String answer = "";
        String[] words = s.split(" ");
        int index = 0;
        for (String word : words) {
            if (word.isBlank()) continue;

            if (index != 0) {
                String blank = s.substring(index, index + s.substring(index).indexOf(word));
                answer += blank;
                index += blank.length();
            } else {
                index += s.indexOf(word);
                answer += s.substring(0, index);
                System.out.println("answer = " + answer);
            }

            index += word.length();
            String newWord = changeWord(word);
            answer += newWord;
        }

        answer += s.substring(index);

        return answer;
    }

    private static String changeWord(String word) {
        String newWord = "";

        for(int i=0; i<word.length(); i++) {
            if (i % 2 == 0) {
                newWord += word.substring(i, i+1).toUpperCase();
            } else {
                newWord += word.substring(i, i+1).toLowerCase();
            }
        }
        return newWord;
    }

}