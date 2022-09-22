package BOJ.Brute_Force;

import java.io.IOException;
import java.util.*;
import java.util.function.IntFunction;

public class Main11_17825 {
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
//        System.out.println(solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4}));
        // ["AC", "ACDE", "BCFG", "CDE"]

//        System.out.println(solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2, 3, 5}));
        // ["ACD", "AD", "ADE", "CD", "XYZ"]

        System.out.println(solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4}));
        // ["WX", "XY"]
    }

    public static String[] solution(String[] orders, int[] course) {
        for(int i=0; i<course.length; i++) {
            for(int j=0; j<orders.length; j++) {
                String[] menu = orders[j].split("");
                Arrays.sort(menu);
                combination(menu, "", 0, 0, course[i]);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (entry1, entry2) -> {
            if (entry1.getKey().length() == entry2.getKey().length()) return entry2.getValue() - entry1.getValue();
            else return entry1.getKey().length() - entry2.getKey().length();
        });

        List<String> answerList = new ArrayList<>();
        int size = -1;
        int max = -1;
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
            if (entry.getValue() == 1) continue; // 최소 2명 이상의 손님에게서 주문된 구성만 받아야 함

            if (size == entry.getKey().length()) {
                if (max <= entry.getValue()) {
                    answerList.add(entry.getKey());
                    max = entry.getValue();
                }
            } else {
                size = entry.getKey().length();
                max = entry.getValue();
                answerList.add(entry.getKey());
            }
        }

        Collections.sort(answerList);
        String[] answer = answerList.toArray(new String[answerList.size()]);

        System.out.println(Arrays.toString(answer));

        return answer;
    }

    private static void combination(String[] menu, String order, int index, int count, int max) {
        if (count == max) {
            map.put(order, map.getOrDefault(order, 0) + 1);
            return;
        }

        for(int i=index; i<menu.length; i++) {
            combination(menu, order+menu[i], i+1, count+1, max);
        }

    }


}