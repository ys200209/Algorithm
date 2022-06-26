import java.util.*;

public class MainBlind_2 {
    static ArrayList<String> result = new ArrayList<>();
    static Map<String, Integer> map;
    static ArrayList<Map.Entry<String, Integer>> list;

    public static void main(String[] args) {
        
        System.out.println(Arrays.toString(solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2,3,4})));
        // ["AC", "ACDE", "BCFG", "CDE"]

    }

    public static String[] solution(String[] orders, int[] course) {
        for(int i=0; i<course.length; i++) {
            map = new HashMap<>();

            for(int j=0; j<orders.length; j++) {
                String[] menu = orders[j].split("");
                Arrays.sort(menu);

                DFS(0, 0, course[i], menu, "");
            }

            list = new ArrayList<>(map.entrySet());
            Collections.sort(list, (e1, e2) -> {
                return e2.getValue() - e1.getValue();
            });

            int max = -1;
            for(Map.Entry<String, Integer> entry : list) {
                int n = entry.getValue();

                if (n < max || n < 2) break;

                max = n;
                result.add(entry.getKey());
            }
        }
        
        Collections.sort(result);
        String[] answer = new String[result.size()];
        for(int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    public static void DFS(int index, int count, int limit, String[] menu, String now) {
        if (count == limit) {
            map.put(now, map.getOrDefault(now, 0) + 1);
            return;
        }

        for(int i=index; i<menu.length; i++) {
            DFS(i+1, count+1, limit, menu, now + menu[i]);
        }

    }
       
}