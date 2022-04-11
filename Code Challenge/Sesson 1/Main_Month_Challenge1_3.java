import java.util.*;

class Main_Month_Challenge1_3 {
    
    public static void main(String[] args) {

        System.out.println(solution(new int[]{2,1,3,4,1})); // [2,3,4,5,6,7]

    }

    public static int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        
        for(int i=0; i<numbers.length; i++) {
            for(int j=0; j<numbers.length; j++) {
                if (i == j) continue;
                
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        int[] answer = new int[set.size()];
        
        Iterator iter = set.iterator();
        int i=0;
        while(iter.hasNext()) {
            answer[i] = Integer.parseInt(iter.next().toString());
            i++;
        }

        Arrays.sort(answer);
        
        return answer;
    }

}