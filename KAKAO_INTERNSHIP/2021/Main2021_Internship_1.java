import java.util.*;

class Main2021_Internship_1 {
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {

        System.out.println(solution("2three45sixseven")); // 234567

    }
    
    public static int solution(String s) {
        String answer = "";

        setNumber();
        
        int start = 0;
        int end = 0;
        while(end < s.length()) {
            if (s.charAt(start) - '0' < 10) {
                answer += (s.charAt(start) - '0');
                start++;
                end++;
            } else {
                end++;

                if (map.get(s.substring(start, end)) != null) {
                    answer += map.get(s.substring(start, end));
                    start = end;
                }
            }
        }
        

        return Integer.parseInt(answer);
    }

    public static void setNumber() {
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
    }

}