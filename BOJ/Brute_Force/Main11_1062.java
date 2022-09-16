package BOJ.Brute_Force;

import java.io.*;
import java.util.*;

public class Main11_1062 {
    static int answer=0;

    public static void main(String[] args) throws IOException {
        System.out.println(solution(new int[]{1,3,2,5,4}, 9)); // 3
//        System.out.println(solution(new int[]{2,2,3,3}, 10)); // 4

    }

    public static int solution(int[] d, int budget) {
        Arrays.sort(d);
        System.out.println(Arrays.toString(d));
        DFS(0, 0, d, budget);

        return answer;
    }

    private static void DFS(int index, int count, int[] d, int budget) {
        if (count > answer) {
            answer = count;
        }

        for(int i=index; i<d.length; i++) {
            if (budget >= d[i]) {
                DFS(i+1, count+1, d, budget-d[i]);
                break;
            } else return;
        }
    }

}