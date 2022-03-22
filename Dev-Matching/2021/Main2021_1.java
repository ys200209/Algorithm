import java.util.*;

public class Main2021_1 {
    
    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(new int[]{44, 1, 0, 0, 31, 25},
        new int[]{31, 10, 45, 1, 6, 19}))); // [3, 5]

    }
    
    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        int bingo = 0;
        int zero = 0;

        ArrayList<Integer> win = new ArrayList<>();
        for(int lot : win_nums) {
            win.add(lot);
        }

        for(int lot : lottos) {
            if (lot == 0) zero++;
            
            if (win.contains(lot)) bingo++;
        }

        int MAX = bingo + zero;
        int MIN = bingo;

        answer[0] = MAX >= 2 ? 7 - MAX : 6;
        answer[1] = MIN < 2 ? 6 : 7 - MIN;

        return answer;
    }

}