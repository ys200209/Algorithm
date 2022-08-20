import java.util.*;

class ProgrammersTest3_2 {
    static String bingo = "1231";

    public static void main(String[] args) {

        System.out.println(solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1})); // 2
        // System.out.println(solution(new int[]{1,2,3,1,2,3,1,2,3,1})); // 1

    }
    
    public static int solution(int[] ingredient) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();

        for (int n : ingredient) {
            sb.append(n);
        }

        while(sb.indexOf(bingo) != -1) {
            // int before = str.length();

            System.out.println(sb);
            
            int index = sb.indexOf(bingo);
            // int after = str.length();
            sb = sb.replace(index, index+4, "");

            // int result = before - after;
            answer ++;
        }

        return answer;
    }
    
}