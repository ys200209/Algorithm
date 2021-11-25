package Hash;

import java.util.*;

public class Main1 {
    public static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {

        System.out.println(solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"})); // leo
        System.out.println(solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"})); // mislav

    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        
        for(int i=0; i<completion.length; i++) {
            if (map.containsKey(completion[i])) {
                map.put(completion[i], map.get(completion[i])+1);
            } else {
                map.put(completion[i], 1);
            }
        }

        for(int i=0; i<participant.length; i++) {
            if (map.containsKey(participant[i])) {
                if (map.get(participant[i]) == 1) {
                    map.remove(participant[i]);
                } else {
                    map.put(participant[i], map.get(participant[i])-1);
                }
            } else {
                return participant[i];
            }
        }

        return answer;
    }
    
}
