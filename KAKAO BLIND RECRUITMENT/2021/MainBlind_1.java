import java.util.*;

public class MainBlind_1 {

    public static void main(String[] args) {

        System.out.println(solution("...!@BaT#*..y.abcdefghi123jklm"));
        /*
        System.out.println(solution("z-+.^."))
        System.out.println(solution("=.="))
        System.out.println(solution("123_.def"))
        System.out.println(solution("abcdefghijklmn.p"))
        */

    }

    public static String solution(String new_id) {
        // 1
        new_id = new_id.toLowerCase();
        // 2
        new_id = new_id.replaceAll("[^\\w\\-_.]*", "");
        // 3
        new_id = new_id.replaceAll("[\\.]+", ".");
        // 4
        new_id = new_id.replaceAll("^\\.|\\.$", "");
        // 5
        new_id = new_id.trim().equals("") ? "a" : new_id;
        // 6
        new_id = new_id.length() >= 16 ? new_id.substring(0, 15) : new_id;
        new_id = new_id.replaceAll("\\.$", "");
        // 7
        if (new_id.length() <= 2) {
            String s = new_id.substring(new_id.length()-1, new_id.length());
            while(new_id.length() <= 2) {
                new_id += s;
            }
        }
        return new_id;
    }
}