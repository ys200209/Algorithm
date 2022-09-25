package KAKAO_BLIND_RECRUITMENT.Kakao2023;

import java.util.*;

public class MainKakao2023_3 {
    static int limit, resultJoin=0, resultMoney=0;
    static int[] discountPercent = new int[]{10, 20, 30, 40};
    static List<User> userList = new ArrayList<>();
    static List<Emoticon> emoticonList = new ArrayList<>();

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(new int[][]{{40, 10000}, {25, 10000}}, new int[]{7000, 9000})));
        // [1, 5400]

        System.out.println(Arrays.toString(solution(
                new int[][]{{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}},
                new int[]{1300, 1500, 1600, 4900})));
        // [4, 13860]
    }

    public static int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];

        limit = emoticons.length;
        for(int i=0; i<users.length; i++) {
            userList.add(new User(users[i][0], users[i][1]));
        }

        for(int i=0; i<emoticons.length; i++) {
            emoticonList.add(new Emoticon(emoticons[i], 0));
        }

        selectDiscount(0, 0);


        answer[0] = resultJoin;
        answer[1] = resultMoney;
        return answer;
    }

    private static void selectDiscount(int index, int count) { // 할인률을 정하는 메서드
        if (count == limit) {
            // 각 이모티콘별 할인률 및 사용자가 원하는 할인률을 기준으로 계산

            System.out.println();
            for (Emoticon emoticon : emoticonList) {
                System.out.print(emoticon.percent + " ");
            }
            System.out.println();
            buy();

            return;
        }

        for(int i=index; i<limit; i++) {
            for(int j=0; j<4; j++) {
                emoticonList.get(i).percent = discountPercent[j];
                selectDiscount(i+1, count+1);
//                emoticonList.get(i).price = 0;
            }
        }

    }

    private static void buy() { // 이모티콘 구매 메서드
        int join = 0;
        int money = 0;

        for(int i=0; i<userList.size(); i++) {
            User user = userList.get(i);
            int emoticonMoney = 0;

            for(int j=0; j<emoticonList.size(); j++) {
                Emoticon emoticon = emoticonList.get(j);
                if (user.percent <= emoticon.percent) { // 이모티콘 할인이 유저가 원하는 할인 이상이라면
                    emoticonMoney += (emoticon.price / 100 * (100 - emoticon.percent));
                    System.out.println("buy emo : " + j + ", " + emoticonMoney);
                }
            }

            System.out.println((i+1) + " buy : " + emoticonMoney);

            if (user.money > emoticonMoney) money += emoticonMoney; // 살 수 있다면 (Tlqkf >=)
            else join++; // 없다면
        }

        if (resultJoin < join) {
            resultJoin = join;
            resultMoney = money;
        } else if (resultJoin == join) {
            if (resultMoney < money) resultMoney = money;
        }

    }

    static class User {
        int percent;
        int money;

        public User(int percent, int money) {
            this.percent = percent;
            this.money = money;
        }
    }

    static class Emoticon {
        int price;
        int percent;

        public Emoticon(int price, int percent) {
            this.price = price;
            this.percent = percent;
        }
    }

}