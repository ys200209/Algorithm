import java.util.*;

class ProgrammersTest2_2 {
    static Map<Integer, Integer> topping1 = new HashMap<>(); // 종류, 갯수
    static Map<Integer, Integer> topping2 = new HashMap<>(); // 종류, 갯수

    public static void main(String[] args) {

        System.out.println(solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2})); // 2

    }
    
    public static int solution(int[] topping) {
        int answer = 0;

        // 처음을 1 : N으로 잘라서 초기화
        topping1.put(topping[0], topping1.getOrDefault(topping[0], 0) + 1);
        for(int i=1; i<topping.length; i++) {
            topping2.put(topping[i], topping2.getOrDefault(topping[i], 0) + 1);
        }

        if (topping1.size() == topping2.size()) answer++;
        
        // N : 1로 잘라가며 확인
        for(int i=1; i<topping.length; i++) {
            topping1.put(topping[i], topping1.getOrDefault(topping[i], 0) + 1);
            topping2.put(topping[i], topping2.get(topping[i]) - 1);

            if (topping2.get(topping[i]) == 0) topping2.remove(topping[i]);

            if (topping1.size() == topping2.size()) answer++;
        }
        return answer;
    }
}
