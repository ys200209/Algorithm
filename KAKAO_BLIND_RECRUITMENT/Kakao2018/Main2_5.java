import java.util.*;

public class Main2_5 {

    public static void main(String[] args) {

        // System.out.println(solution("KAKAO")); // [11, 1, 27, 15]
        System.out.println(solution("TOBEORNOTTOBEORTOBEORNOT")); // [20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34]
        // System.out.println(solution("ABABABABABABABAB")); // 	[1, 2, 27, 29, 28, 31, 30]

    }

    public static int[] solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();
        Map<String, Integer> dic = new HashMap<>();
        String[] m = msg.split("");
        
        dic.put("0", 0);
        for(int i=0; i<26; i++) {
            dic.put(Character.toString((char)("A".charAt(0) + i)), i+1);
        }
        
        int index=0;
        String str = "";
        while(index < msg.length()) {
            str += m[index];
            System.out.println("str : " + str);
            if (dic.get(str) == null) {
                System.out.println("-----------");
                answer.add(dic.get(str.substring(0, str.length()-1)));
                dic.put(str, dic.size());
                // System.out.println("dic : " + dic);
                str = "";
            } else index++;

        }
        answer.add(dic.get(str));

        System.out.println("answer : " + answer);

        int[] result = new int[answer.size()];

        int j=0;
        for(int num : answer) {
            result[j] = num;
            j++;
        }

        return result;
    }

}
