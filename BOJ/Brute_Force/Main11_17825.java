package BOJ.Brute_Force;

import java.io.IOException;
import java.util.*;

public class Main11_17825 {

    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(solution(3, 2, 5))); // [3,2,2,3]
    }

    public static int[] solution(int n, long left, long right) {
        int size = (int)(right-left) + 1;
        int[] answer = new int[size];

        for(int i=0; i<size; i++) {
            int x = (int)((i+left)/n);
            int y = (int)((i+left)%n);
            answer[i] = Math.max(x+1, y+1);
        }

        return answer;
    }

}