import java.util.*;

class Main2020_Internship_3 {
    static Map<String, Integer> jewelMap = new HashMap<>();

    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"})));
        // [3, 7]

    }

    public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        answer[0] = 0;
        answer[1] = 100001;

        int start = 0;
        int end = 100001;
        int index=0;
        while(index < gems.length) {
            // System.out.println("index : " + index);
            if (jewelMap.get(gems[index]) == null) {
                jewelMap.put(gems[index], 1);
                answer[1] = index;

            } else jewelMap.put(gems[index], jewelMap.get(gems[index]) + 1);

            end = index;
            
            while(true) {
                String jewel = gems[start];
                if (jewelMap.get(jewel) == 1) break;

                jewelMap.put(jewel, jewelMap.get(jewel) - 1);
                start++;
            }

            /*System.out.println("ansewr[0] : " + answer[0] + ", answer[1] : " + answer[1]);
            System.out.println("start : " + start + ", end : " + end);*/

            if (end - start < answer[1] - answer[0]) {
                answer[0] = start;
                answer[1] = end;
            }

           
            index++;
        }

        answer[0]++;
        answer[1]++;

        return answer;
    }

}