package BOJ.Brute_Force;

import java.util.*;

public class Main11_1799 {
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"})); // 2
    }

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        String[] split = skill.split("");
        for(int i=0; i<split.length; i++) {
            map.put(split[i], i+1);
        }

        for(int i=0; i<skill_trees.length; i++) {
            split = skill_trees[i].split("");
            if (checkSkill(split)) answer++;
        }

        return answer;
    }

    private static boolean checkSkill(String[] split) {
        int number=0
                ;
        for(int i=0; i<split.length; i++) {
            if (map.get(split[i]) == null) continue;

            if (map.get(split[i]) == number+1) number++;
            else return false;
        }
        return true;
    }

}