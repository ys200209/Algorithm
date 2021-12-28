import java.util.*;

public class Main2 {
    public static Map<String, Integer> map = new HashMap<>();
    public static Set<String> set = new TreeSet<>();
    
    public static void main(String[] args) {

        System.out.println(solution(new String[]{"119", "97674223", "1195524421"})); // false
        System.out.println(solution(new String[]{"123","456","789"})); // true
        System.out.println(solution(new String[]{"12","123","1235","567","88"})); // false

    }

    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);  

        for(int i=0; i<phone_book.length; i++) {
            for(int j=i+1; j<phone_book.length; j++) {
                if (phone_book[j].startsWith(phone_book[i]) || phone_book[i].startsWith(phone_book[j])) {
                    return false;
                }
            }
        }

        return true;
    }

}
