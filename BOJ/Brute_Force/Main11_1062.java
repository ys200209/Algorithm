package BOJ.Brute_Force;

import java.io.*;
import java.util.*;

public class Main11_1062 {

    public static void main(String[] args) throws IOException {
//        System.out.println(Arrays.toString(solution(10, 2))); // "3people Unfollowed Me"
//        System.out.println(Arrays.toString(solution(80, 1))); // "3people Unfollowed Me"
        System.out.println(Arrays.toString(solution(18, 6))); // "3people Unfollowed Me"
//        System.out.println(solution(new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}})); // 120

    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int sum = brown+yellow;
        int width = 3;
        int diff = (int)1e9;
        while(true) {
            if (width > sum/2) return answer;

            if (sum % width == 0) {
                int h = sum / width;

                if (Math.abs(width - h) < diff && (width-2)*(h-2) == yellow) {
                    diff = Math.abs(width - h);
                    if (h > width) {
                        answer[0] = h;
                        answer[1] = width;
                    } else {
                        answer[0] = width;
                        answer[1] = h;
                    }
                }
            }
            width++;
        }
    }

}