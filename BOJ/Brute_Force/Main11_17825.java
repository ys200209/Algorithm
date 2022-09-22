package BOJ.Brute_Force;

import java.io.IOException;
import java.util.*;
import java.util.function.IntFunction;

public class Main11_17825 {
    static Map<String, List<Developer>> langMap = new HashMap<>();
    static Map<String, List<Developer>> positionMap = new HashMap<>();
    static Map<String, List<Developer>> careerMap = new HashMap<>();
    static Map<String, List<Developer>> foodMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(solution(
                new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"})));
        // [1,1,1,1,2,4]
    }

    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        init(info);

        for(int i=0; i<query.length; i++) { // 요청 사항 쿼리
            String[] split = query[i].split(" and ");
            String lang = split[0];
            String position = split[1];
            String career = split[2];
            String[] foodAndScore = split[3].split(" ");
            String food = foodAndScore[0];
            int score = Integer.parseInt(foodAndScore[1]);
            int count = 0;

            for (Developer langDev : langMap.get(lang)) {
//                if (positionMap.get(position) == null || careerMap.get(career) == null || foodMap.get(food) == null) break;

                if (positionMap.get(position).contains(langDev) && careerMap.get(career).contains(langDev)
                        && foodMap.get(food).contains(langDev) && langDev.score >= score) count++;
            }
            answer[i] = count;
        }

        return answer;
    }

    private static void init(String[] info) {
        langMap.put("-", new ArrayList<>());
        positionMap.put("-", new ArrayList<>());
        careerMap.put("-", new ArrayList<>());
        foodMap.put("-", new ArrayList<>());

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
            if (!position.equals("-")) positionMap.get("-").add(developer);
            if (!career.equals("-")) careerMap.get("-").add(developer);
            if (!food.equals("-")) foodMap.get("-").add(developer);

            langMap.get(lang).add(developer);
            positionMap.get(position).add(developer);
            careerMap.get(career).add(developer);
            foodMap.get(food).add(developer);
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