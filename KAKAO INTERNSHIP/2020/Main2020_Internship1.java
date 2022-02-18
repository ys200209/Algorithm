import java.util.*;

public class Main2020_Internship1 {
    static StringBuilder sb = new StringBuilder();
    static Number LEFT = new Number(3, 0);
    static Number RIGHT = new Number(3, 2);
    static Map<String, Number> phone = new HashMap<>();

    public static void main(String[] args) {

        System.out.println(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right")); // "LRLLLRLLRRL"
        // System.out.println(solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left")); // "LRLLRRLLLRR"
        // System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right")); // "LLRLLRLLRL"



    }

    public static String solution(int[] numbers, String hand) {
        String answer = "";
        // String[][] phone = new String[][]{{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}, {"*", "0", "#"}};
        
        

        for(int i=0; i<4; i++) {
            for(int j=0; j<3; j++) {
                String key = Integer.toString((3*i + j) + 1);

                if (i==3) {
                    if (j == 0) phone.put("*", new Number(i, j));
                    else if (j == 1) phone.put("0", new Number(i, j));
                    else if (j == 2) phone.put("#", new Number(i, j));
                } else {
                    phone.put(key, new Number(i, j));
                }
            }
        }
        
        for(int i=0; i<numbers.length; i++) {
            String key = Integer.toString(numbers[i]);

            if (key.equals("1") || key.equals("4") || key.equals("7")) {
                touchLeft(key);
            } else if (key.equals("3") || key.equals("6") || key.equals("9")) {
                touchRight(key);
            } else { // 2, 5, 8, 0
                int left_distance = Math.abs(LEFT.row - phone.get(key).row) + Math.abs(LEFT.column - phone.get(key).column);
                int right_distance = Math.abs(RIGHT.row - phone.get(key).row) + Math.abs(RIGHT.column - phone.get(key).column);

                if (left_distance < right_distance) { // 왼손이 가깝다면
                    touchLeft(key);
                } else if (left_distance > right_distance) { // 오른손이 가깝다면
                    touchRight(key);
                } else { // 거리가 같다면
                    if (hand.equals("right")) touchRight(key);
                    else touchLeft(key);
                }
            }
        }

        return sb.toString();
    }

    public static void touchLeft(String key) {
        sb.append("L");
        LEFT.row = phone.get(key).row;
        LEFT.column = phone.get(key).column;
    }

    public static void touchRight(String key) {
        sb.append("R");
        RIGHT.row = phone.get(key).row;
        RIGHT.column = phone.get(key).column;
    }

}

class Number {
    int row;
    int column;

    public Number(int row, int column) {
        this.row = row;
        this.column = column;
    }

}