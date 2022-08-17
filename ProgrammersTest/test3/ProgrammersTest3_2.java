import java.util.*;

class ProgrammersTest3_2 {
    static String search = "1231";
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {

        System.out.println(solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1})); // 2

    }
    
    public static int solution(int[] ingredient) {
        int answer = 0;

        StringBuilder sb = new StringBuilder();
        for(int n : ingredient) {
            sb.append(n);
        }

        String str = sb.toString();
        while(str.contains(search)) {
            str = str.replaceFirst(search, "");
            answer++;
        }

        return answer;
    }

}