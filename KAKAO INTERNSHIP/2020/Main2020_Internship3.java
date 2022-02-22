import java.util.*;

public class Main2020_Internship3 {
    static int result = (int)1e9, len = (int)1e9, MIN=0;
    static Map<String, Integer> map = new HashMap<>(); // <보석명, 보석 인덱스>
    
    public static void main(String[] argrs) {

        //System.out.println(solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"}));
        // [3, 7]
        //System.out.println(solution(new String[]{"AA", "AB", "AC", "AA", "AC"}));
        // [1, 3]
        System.out.println(solution(new String[]{"XYZ", "XYZ", "XYZ"}));
        // [1, 1]
        //System.out.println(solution(new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"}));
        // [1, 5]

    }

    public static int[] solution(String[] gems) {
        int[] answer = new int[2];

        for(int i=0; i<gems.length; i++) {
            if (map.containsKey(gems[i])) { // 이미 리스트에 추가한 보석이라면
                map.put(gems[i], i);
                
                List<Integer> list = new ArrayList<>(map.values());
                list.sort(Integer::compareTo);

                MIN = list.get(0);

                if (result > (i-MIN+1)) {
                    answer[0] = MIN+1;
                    answer[1] = i+1;
                    result = i-MIN+1;
                }
                result = Math.min(result, i-MIN+1);

            } else { // 처음보는 보석을 발견했다면
                result = i - MIN + 1;
                map.put(gems[i], i);
                answer[0] = MIN+1;
                answer[1] = i+1;
            }
        }

        System.out.println(Arrays.toString(answer));

        return answer;
    }

}

class Jewel implements Comparable<Jewel> {

    int index;
    int count;

    public Jewel(int index, int count) {
        this.index = index;
        this.count = count;
    }

    @Override
    public int compareTo(Jewel jewel) {
        return this.count - jewel.count;
    }

}