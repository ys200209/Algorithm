import java.util.*;

class ProgrammersTest1_2 {
    static Map<String, Integer> wantMap = new HashMap<>();
    static Map<String, Integer> discountMap = new HashMap<>();

    public static void main(String[] args) {

        // System.out.println(solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3, 2, 2, 2, 1}, 
        // new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}));
        // // 3

        System.out.println(solution(new String[]{"banana"}, new int[]{10}, 
        new String[]{"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"}));
        // 0

    }
    
    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        for(int i=0; i<want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        int index = 0;
        boolean isBreak = false;
        while(index <= discount.length-10) {
            isBreak = false;
            System.out.println("index : " + index);
            
            discountMap.clear();

            for(int i=index; i<index+10; i++) {
                System.out.println("i : " + i);
                if (wantMap.get(discount[i]) == null) {
                    index = i+1;
                    isBreak = true;
                    break;
                }
                
                discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0) + 1);

                if (discountMap.get(discount[i]) > wantMap.get(discount[i])) {
                    index++;
                    isBreak = true;
                    break;
                }
            }
            if (!isBreak) {
                answer++;
                index++;
            }

        }
        // System.out.println("index : " + index);
        
        return answer;
    }
    
}