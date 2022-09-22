package BOJ.Brute_Force;

import java.io.*;
import java.util.*;

public class Main11_17825 {
    static String[] langs = new String[]{"cpp", "java", "python"};
    static String[] positions = new String[]{"backend", "frontend"};
    static String[] careers = new String[]{"junior", "senior"};
    static String[] foods = new String[]{"chicken", "pizza"};
//    static String[] lang = new String[]{"cpp", "java", "python"};
    static Map<String, List<Integer>> developers = new HashMap<>(); // <"java backend junior pizza", [10, 20, 30]>
    static int count = 0;

    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(solution(
                new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"})));
        // [1,1,1,1,2,4]
    }

    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        init(info);

        for(int i=0; i<query.length; i++) {
//            System.out.println("i = " + i);

            String replaceQuery = query[i].replaceAll("and ", "");
            int lastIndex = replaceQuery.lastIndexOf(" ");
            String[] split = replaceQuery.split(" ");
            String str = replaceQuery.substring(0, lastIndex);
            String lang = split[0];
            String position = split[1];
            String career = split[2];
            String food = split[3];
            int score = Integer.parseInt(split[4]);
            count = 0;

            if (developers.get(str) == null) {
                if (lang.equals("-") || position.equals("-") || career.equals("-") || food.equals("-")) {
                    replaceStr(lang, position, career, food, score);
                } else continue;
            } else {
                int minIndex = getScore(0, developers.get(str).size(), developers.get(str), score, (int) 1e9);
//                System.out.println("1 minIndex = " + minIndex);
                count = minIndex == (int)1e9 ? 0 : developers.get(str).size() - minIndex;
            }

//            System.out.println("developers.get(str) = " + developers.get(str));
//            System.out.println("count = " + count);
//            System.out.println();
            answer[i] = count;
        }

        return answer;
    }

    private static void replaceStr(String lang, String position, String career, String food, int score) {
        if (lang.equals("-") || position.equals("-") || career.equals("-") || food.equals("-")) {
            if (lang.equals("-")) {
                for (int i = 0; i < langs.length; i++) {
                    replaceStr(langs[i], position, career, food, score);
                }
            } else if (position.equals("-")) {
                for (int i = 0; i < positions.length; i++) {
                    replaceStr(lang, positions[i], career, food, score);
                }
            } else if (career.equals("-")) {
                for (int i = 0; i < careers.length; i++) {
                    replaceStr(lang, position, careers[i], food, score);
                }
            } else if (food.equals("-")) {
                for (int i = 0; i < foods.length; i++) {
                    replaceStr(lang, position, career, foods[i], score);
                }
            }
        } else {
            String str = lang + " " + position + " " + career + " " + food;
//            System.out.println("str = " + str + ", " + developers.get(str));
//            System.out.println("score = " + score);
            if (developers.get(str) != null) {
                int minIndex = getScore(0, developers.get(str).size(), developers.get(str), score, (int)1e9);
//                System.out.println("minIndex = " + minIndex);
                count += (minIndex != (int)1e9 ? developers.get(str).size() - minIndex : 0);
            }
        }
    }

    private static int getScore(int start, int end, List<Integer> scores, int score, int minIndex) { // 이분 탐색
        if (start >= end) return minIndex;

        int mid = (start + end) / 2;
        if (scores.get(mid) < score) {
            return getScore(mid+1, end, scores, score, minIndex);
        } else {
            minIndex = Math.min(Math.min(minIndex, mid), getScore(start, mid, scores, score, minIndex));
            return minIndex;
        }
    }


    private static void init(String[] info) {
        /*langMap.put("-", new ArrayList<>());
//        positionMap.put("-", new ArrayList<>());
//        careerMap.put("-", new ArrayList<>());
//        foodMap.put("-", new ArrayList<>());

        for(int i=0; i<info.length; i++) {
            String[] split = info[i].split(" ");
            String lang = split[0];
            String position = split[1];
            String career = split[2];
            String food = split[3];
            int score = Integer.parseInt(split[4]);
            Developer developer = new Developer(lang, position, career, food, score);

            if (langMap.get(lang) == null) langMap.put(lang, new ArrayList<>());
            if (positionMap.get(position) == null) positionMap.put(position, new ArrayList<>());
            if (careerMap.get(career) == null) careerMap.put(career, new ArrayList<>());
            if (foodMap.get(food) == null) foodMap.put(food, new ArrayList<>());

            if (!lang.equals("-")) langMap.get("-").add(developer);
//            if (!position.equals("-")) positionMap.get("-").add(developer);
//            if (!career.equals("-")) careerMap.get("-").add(developer);
//            if (!food.equals("-")) foodMap.get("-").add(developer);

            langMap.get(lang).add(developer);
            positionMap.get(position).add(developer);
            careerMap.get(career).add(developer);
            foodMap.get(food).add(developer);
        }*/

        for(int i=0; i<info.length; i++) {
            int lastIndex = info[i].lastIndexOf(" ");
            String str = info[i].substring(0, lastIndex);
//            System.out.println("str = " + str);
//            System.out.println("info[i].substring(lastIndex) = " + info[i].substring(lastIndex+1));
            if (developers.get(str) == null) developers.put(str, new ArrayList<>());

            developers.get(str).add(Integer.parseInt(info[i].substring(lastIndex+1)));
        }

        for (String key : developers.keySet()) {
            Collections.sort(developers.get(key));
        }

    }

    static class Developer {
        String[] stats;
        String lang;
        String position;
        String career;
        String food;
        int score;

        public Developer(String lang, String position, String career, String food, int score) {
            this.lang = lang;
            this.position = position;
            this.career = career;
            this.food = food;
            this.score = score;
        }
    }

}