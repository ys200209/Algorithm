package BOJ.Brute_Force;

import java.io.*;
import java.util.*;

public class Main11_17825 {
    static Map<String, User> map = new HashMap<>();
    static Map<String, Integer> reportCount = new HashMap<>();

    public static void main(String[] args) throws IOException {
//        System.out.println(Arrays.toString(solution(
//                new String[]{"muzi", "frodo", "apeach", "neo"},
//                new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"},
//                2))); // [2,1,1,0]

        System.out.println(Arrays.toString(solution(
                new String[]{"con", "ryan"},
                new String[]{"ryan con", "ryan con", "ryan con", "ryan con"},
                3))); // [0,0]
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        for(int i=0; i<id_list.length; i++) {
            map.put(id_list[i], new User(new ArrayList<>(), new ArrayList<>()));
        }

        for(int i=0; i<report.length; i++) {
            String[] split = report[i].split(" ");
            if (map.get(split[0]).report.contains(split[1])) continue;

            map.get(split[0]).report.add(split[1]);
            map.get(split[1]).beReported.add(split[0]);
        }

        for (String key : map.keySet()) {
            if (map.get(key).beReported.size() >= k) {
                for (String name : map.get(key).beReported) {
                    reportCount.put(name, reportCount.getOrDefault(name, 0) + 1);
                }
            }
        }

        for(int i=0; i<answer.length; i++) {
            answer[i] = reportCount.get(id_list[i]) == null ? 0 : reportCount.get(id_list[i]);
        }

        return answer;
    }

    static class User {
        List<String> report;
        List<String> beReported;

        public User(List<String> report, List<String> beReported) {
            this.report = report;
            this.beReported = beReported;
        }
    }

}