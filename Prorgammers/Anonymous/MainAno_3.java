import java.util.*;

class MainAno_3 {

    public static void main(String[] args) {

        //System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
        System.out.println(Arrays.toString(solution(4, new int[]{4,4,4,4,4})));

    }
    
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Map<Integer, Double> failMap = new HashMap<>();
        
        Arrays.sort(stages);
        
        int stage = 1;
        int index = 0;
        int total = stages.length;

        while(stage <= N) {
            double count = 0.0;

            while(index < stages.length && stages[index] <= stage) {
                index++;
                count += 1.0;
            }
            
            if (count == 0) failMap.put(stage, 0.0);
            else {
                failMap.put(stage, count/total);
            }
            
            total -= (int)count;
            stage++;
        }
        
        ArrayList<Map.Entry<Integer, Double>> list = new ArrayList<>(failMap.entrySet());
        Collections.sort(list, (entry1, entry2) -> {
            if (entry1.getValue().equals(entry2.getValue())) {
                return entry1.getKey() - entry2.getKey();
            } else {
                return entry2.getValue() > entry1.getValue() ? 1 : -1;
            }
        });

        int i=0;
        for(Map.Entry<Integer, Double> entry : list) {
            answer[i++] = entry.getKey();
        }
        
        return answer;
    }

}