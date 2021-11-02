import java.util.*;

public class Main1 {

    public static void main(String[] args) {

        System.out.println(solution(new int[]{1,2,3,4,6,7,8,0}));

    }

    public static int solution(int[] numbers) {
        int answer = 0;

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<numbers.length; i++) {
            list.add(numbers[i]);
        }

        for(int i=1; i<=9; i++) {
            if (!list.contains(i)) {
                answer += i;
            }
        }


        return answer;
    }
    
}
