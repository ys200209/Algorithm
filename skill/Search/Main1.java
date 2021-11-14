package Search;

import java.util.*;

public class Main1 {

    public static void main(String[] args) {

        // 모의 고사 (1)
        System.out.println(Arrays.toString(solution(new int[]{1,2,3,4,5}))); // [1]
        System.out.println(Arrays.toString(solution(new int[]{1,3,2,4,2}))); // [1, 2, 3]
        System.out.println(Arrays.toString(solution(new int[]{2, 3, 1, 3, 1}))); // [2, 3]

        
    }
    
    public static int[] solution(int[] answers) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] answer;
        int[] student1 = new int[]{1, 2, 3, 4, 5};
        int[] student2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] scores = new int[]{0, 0, 0};

        for(int i=0; i<answers.length; i++) {
            if (student1[i%5] == answers[i]) scores[0] += 1;
            if (student2[i%8] == answers[i]) scores[1] += 1;
            if (student3[i%10] == answers[i]) scores[2] += 1;
        }

        int max = scores[0];
        list.add(1);

        for(int i=1; i<3; i++) {
            if (max < scores[i]) {
                list.clear();
                list.add(i+1);
                max = scores[i];
            } else if (max == scores[i]) {
                list.add(i+1);
            }
        }

        answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

}
