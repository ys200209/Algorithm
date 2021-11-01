import java.util.*;

public class MainBlind_1 {
    public static ArrayList<String> list = new ArrayList<>();
    public static String[] str;
    public static String filter;

    public static void main(String[] args) {

        System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
        /*
        System.out.println(solution("z-+.^."))
        System.out.println(solution("=.="))
        System.out.println(solution("123_.def"))
        System.out.println(solution("abcdefghijklmn.p"))
        */

    }

    public static String solution(String new_id) {
        String answer = "";

        // Step 1.
        str = new_id.toLowerCase().split(" ");

        System.out.println((int)"z".charAt(0));
        System.out.println(Arrays.toString(str));
        System.out.print("str = ");
        // Step 2.
        for(int i=0; i<str.length; i++) {
            System.out.print(str[i] + " ");

            // Step 4.
            if ((i == 0 || i == new_id.length()-1) && str[i].equals(".")) {
                continue;
            }
            if (str[i].equals("-") || str[i].equals("_")
                    || ((int)new_id.charAt(i) >= 0 && (int)new_id.charAt(i) <= 9) 
                        || ((int)new_id.charAt(i) >= 97 && (int)new_id.charAt(i) <= 122))  {

                            list.add(str[i]);

            }

            // Step 3.
            if (str[i].equals(".")) {
                if (str[i-1].equals(".")) {
                    continue;
                }
                else {
                    list.add(str[i]);
                }
            }

        }

        System.out.println("\nlist = " + list);
        // Step 5.
        if (list.isEmpty()) {
            list.add("a");
        }

        // Step 6.
        if (list.size() >= 16) {
            for(int i=16; i<list.size(); i++) {
                list.remove(16);
            }

            if (list.get(15).equals(".")) {
                list.remove(15);
            }
        }
        
        // Step 7.
        if (list.size() <= 2) {
            for(int i=list.size(); i<=3; i++) {
                list.add(list.get(list.size()-1));
            }
        }

        for(int i=0; i<list.size(); i++) {
            answer += list.get(i);
        }

        return answer;
    }

    

}