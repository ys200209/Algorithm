import java.util.*;

public class Main2_2 {
    static String s="";
    static Set<String> set = new HashSet<>();
    static Map<String, Integer> map = new HashMap<>();
    static boolean[] visited;

    public static void main(String[] args) {

        System.out.println(solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4}));
        // System.out.println(solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4}));

    }

    public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        visited = new boolean[10];

        Arrays.sort(orders);
        System.out.println(Arrays.toString(orders));

        

        for(int i=0; i<course.length; i++) {
            for(int j=0; j<orders.length; j++) {
                DFS(0, orders[j], course[i]);
            }

            for(String key : map.keySet()) {
                System.out.println(key + " : " + map.get(key));
            }

            break;
        }

        // ArrayList<String> arrayList

        return answer;
    }

    public static void DFS(int start, String str, int end) {
        if (start == end) {
            if (map.get(s) == null) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
            return;
        }

        for(int i=0; i<str.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                s += str.substring(i, i+1);
                DFS(start+1, str, end);
                s = s.substring(0, s.length()-1);
                visited[i] = false;
            }
        }
    }
}
