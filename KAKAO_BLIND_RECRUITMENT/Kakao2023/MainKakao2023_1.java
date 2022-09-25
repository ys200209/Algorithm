package KAKAO_BLIND_RECRUITMENT.Kakao2023;

import java.util.*;

public class MainKakao2023_1 {
    static Map<String, Integer> termMap = new HashMap<>();

    public static void main(String[] args) {
//        System.out.println(solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"}));
        // [1, 3]

        System.out.println(solution("2015.01.16", new String[]{"A 58"}, new String[]{"2010.02.15 A"}));
        //

//        System.out.println(solution("2015.05.15", new String[]{"A 14"}, new String[]{"2014.03.15 A"}));
        //

    }

    public static int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer;

        List<Integer> list = new ArrayList<>();
        String[] todaySplit = today.split("\\.");
        int nowYear = Integer.parseInt(todaySplit[0]);
        int nowMonth = Integer.parseInt(todaySplit[1]);
        int nowDay = Integer.parseInt(todaySplit[2]);

        System.out.println("nowYear = " + nowYear + ", nowMonth : " + nowMonth + ", nowDay : " + nowDay);

        for(int i=0; i<terms.length; i++) {
            String[] split = terms[i].split(" ");
            termMap.put(split[0], Integer.parseInt(split[1]));
        }

        for(int i=0; i<privacies.length; i++) {
            String[] split = privacies[i].split(" ");
            String[] date = split[0].split("\\.");
            int year = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int day = Integer.parseInt(date[2]);
            System.out.println("(before) year = " + year + ", month = " + month + ", day : " + day);


            int limit = termMap.get(split[1]);
            int addYear = limit/12;
            int addMonth = month + (limit%12);
            month = addMonth > 12 ? addMonth%12 : addMonth;
            year += addMonth > 12 ? addYear+1 : addYear;
//            month = month + limit > 12 ? (month+limit)-(12*addYear) : month+limit;
//            year += month + limit > 12 ? addYear : 0;
            System.out.println("(after) year = " + year + ", month = " + month + ", day : " + day);

            if (nowYear > year) list.add(i+1);
            else if (nowYear == year) {
                if (nowMonth > month) list.add(i+1);
                else if (nowMonth == month) {
                    if (nowDay >= day) list.add(i+1);
                }
            }
        }

        System.out.println("list = " + list);
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

}