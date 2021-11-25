import java.util.*;

public class Main2 {
    
    public static void main(String[] args) {

        System.out.println(solution(new String[]{"119", "97674223", "1195524421"})); // false
        System.out.println(solution(new String[]{"123","456","789"})); // true
        System.out.println(solution(new String[]{"12","123","1235","567","88"})); // false

    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        System.out.println(Arrays.toString(phone_book));        

        return answer;
    }

}
