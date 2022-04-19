import java.util.*;

class Main2020_Internship_1 {
    static Map<Integer, Key> keyMap = new HashMap<>();
    static Hand left, right;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        System.out.println(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
        // LRLLLRLLRRL

    }

    public static String solution(int[] numbers, String hand) {

        for(int i=1; i<=9; i++) {
            keyMap.put(i, new Key((i-1)/3, (i-1)%3));
        }
        keyMap.put(0, new Key(3, 1)); 

        left = new Hand(3, 0);
        right = new Hand(3, 2);


        for(int i=0; i<numbers.length; i++) {
            int num = numbers[i];

            if (num == 1 || num == 4 || num == 7) {
                left.hand_x = keyMap.get(num).key_x;
                left.hand_y = keyMap.get(num).key_y;
                sb.append("L");
            } else if (num == 3 || num == 6 || num == 9) {
                right.hand_x = keyMap.get(num).key_x;
                right.hand_y = keyMap.get(num).key_y;
                sb.append("R");
            } else {
                int left_dis = distance(left, num);
                int right_dis = distance(right, num);

                if (left_dis > right_dis) {
                    right.hand_x = keyMap.get(num).key_x;
                    right.hand_y = keyMap.get(num).key_y;
                    sb.append("R");
                } else if (left_dis < right_dis) {
                    left.hand_x = keyMap.get(num).key_x;
                    left.hand_y = keyMap.get(num).key_y;
                    sb.append("L");
                } else {
                    if (hand.equals("left")) {
                        left.hand_x = keyMap.get(num).key_x;
                        left.hand_y = keyMap.get(num).key_y;
                        sb.append("L");
                    } else {
                        right.hand_x = keyMap.get(num).key_x;
                        right.hand_y = keyMap.get(num).key_y;
                        sb.append("R");
                    }
                }
            }
        }

        return sb.toString();
    }

    public static int distance(Hand hand, int num) {
        int dis=0;
        
        dis = Math.abs(hand.hand_x - keyMap.get(num).key_x) + 
        Math.abs(hand.hand_y - keyMap.get(num).key_y);

        return dis;
    }

}

class Hand {

    int hand_x;
    int hand_y;

    public Hand(int hand_x, int hand_y) {
        this.hand_x = hand_x;
        this.hand_y = hand_y;
    }
}

class Key {

    int key_x;
    int key_y;

    public Key(int key_x, int key_y) {
        this.key_x = key_x;
        this.key_y = key_y;
    }
}