import java.util.*;

class Main2021_1 {

    public static void main(String[] args) {

        // 로또의 최고 순위와 최저 순위
        //System.out.println(solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19})); // [3, 5]
        //System.out.println(solution(new int[]{0, 0, 0, 0, 0, 0}, new int[]{38, 19, 20, 40, 15, 25})); // [1, 6]
        //System.out.println(solution(new int[]{45, 4, 35, 20, 3, 9}, new int[]{20, 9, 3, 45, 4, 35})); // [1, 1]
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 2, 3, 5, 4, 6}))); // [1, 1]
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5, 6}, new int[]{7, 8, 9, 10, 11, 12}))); // [1, 1]

    }
    
    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zero = 0;
        int max=7;
        int min=0;
        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i=0; i<lottos.length; i++) {
            arrayList.add(win_nums[i]);
        }
        
        for(int i=0; i<lottos.length; i++) {
            if (arrayList.contains(lottos[i])) {
                System.out.print(lottos[i] + " ");
                max--;
            } 
            
            if (lottos[i] == 0) {
                zero++;
            }
        }

        min = max-zero;
        
        if (min < 1) min = 1;
        if (min > 6) min = 6;
        if (max < 1) max = 1;
        if (max > 6) max = 6;

        answer[0] = min;
        answer[1] = max;

        return answer;
    }
    
}