package BOJ.Brute_Force;

import java.io.IOException;
import java.util.*;

public class Main11_17825 {

    public static void main(String[] args) throws IOException {
//        System.out.println(solution("...!@BaT#*..y.abcdefghijklm")); // bat.y.abcdefghi
        System.out.println(solution("z-+.^.")); // z--
//        System.out.println(solution("=.=")); // aaa
//        System.out.println(solution("123_.def")); // 123_.def
//        System.out.println(solution("abcdefghijklmn.p")); // abcdefghijklmn
    }

    public static String solution(String new_id) {
        String step1 = new_id.toLowerCase();
        String step2 = "";
        for(int i=0; i<step1.length(); i++) {
            char c = step1.charAt(i);
            if ((c-'a' >= 0 && c-'a'<26) || c-'-'==0 || c-'_'==0 || c-'.'==0 || (c-'0' <= 9 && c-'0'>=0)) {
                if (step2.length() >= 1 && c-'.'==0 && step2.charAt(step2.length()-1)-'.'==0) continue; // step3 조건
                step2 += c;
            }
        }

        String step4 = null;
        String start = step2.substring(0, 1);
        String end = step2.length() > 1 ? step2.substring(step2.length()-1) : "";
        if (start.equals(".") && end.equals(".")) step4 = step2.substring(1, step2.length()-1);
        else if (start.equals(".")) step4 = step2.substring(1);
        else if (end.equals(".")) step4 = step2.substring(0, step2.length()-1);
        else step4 = step2;

        String step5 = step4.trim().isBlank() ? "a" : step4;

        String step6 = step5.length() >= 16 ? step5.substring(14, 15).equals(".") ? step5.substring(0, 14) : step5.substring(0, 15) : step5;

        String step7 = step6;
        if (step7.length() <= 2) {
            String last = step7.substring(step7.length()-1);
            while(step7.length() < 3) step7 += last;
        }

        return step7;
    }

}