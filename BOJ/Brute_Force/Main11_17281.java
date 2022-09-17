package BOJ.Brute_Force;

import java.io.*;
import java.util.*;

public class Main11_17281 {
    static Queue<Algorithm> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {

//        System.out.println(solution(10, 10, new int[][]{{10, 15, 2, 1, 2}, {20, 20, 3, 3, 4}})); // 15
        System.out.println(solution(0, 0, new int[][]{{0,0,2,1,2},
                {4,5,3,1,2}, {4,11,4,0,2}, {10,4,0,4,2}})); // 13

    }

    public static int solution(int alp, int cop, int[][] problems) {
        Algorithm algorithm = new Algorithm(alp, cop, 0);

        if (isSuccess(algorithm, problems)) {
            return algorithm.time;
        }
        pq.offer(algorithm);
//        int result = Study(problems);
//        System.out.println("result = " + result);
        return Study(problems);
    }

    private static int Study(int[][] problems) {
        int minTime = (int)1e9;

        while(!pq.isEmpty()) {
            Algorithm poll = pq.poll();
            int alp = poll.alp;
            int cop = poll.cop;
            int time = poll.time;

//            System.out.println("alp = " + alp + ", cop = " + cop + ", time = " + time);

            if (minTime <= time) continue;

            if (isSuccess(poll, problems)) {
//                System.out.println("isSuccess()");
                minTime = Math.min(minTime, time);
//                System.out.println();
                continue;
            }

            for(int i=0; i<problems.length; i++) {
//                System.out.println("i = " + i);

                int alpGap =  problems[i][0] - alp;
                int copGap = problems[i][1] - cop;
//                System.out.println("alpGap = " + alpGap);
//                System.out.println("copGap = " + copGap);

                if (alpGap > 0) pq.offer(new Algorithm(alp + alpGap, cop, time + alpGap));
                if (copGap > 0) pq.offer(new Algorithm(alp, cop + copGap, time + copGap));

                if (alp >= problems[i][0] && cop >= problems[i][1]) {
//                    System.out.println("problem seq : " + i);

                    /*int alpProblemCount = problems[i][2] == 0 ? -1 : problems[i][0] / problems[i][2];
                    int copProblemCount = problems[i][3] == 0 ? -1 : problems[i][1] / problems[i][3];*/

//                    System.out.println("problem count : " + alpProblemCount);

                    pq.offer(new Algorithm(alp + problems[i][2], cop + problems[i][3], time + problems[i][4]));

                    /*if (problems[i][0] - alp > 0 && problems[i][2] > 0) pq.offer(new Algorithm(alp + problems[i][2],
                            cop + problems[i][3], time + problems[i][4]));

                    if (problems[i][1] - cop > 0 && problems[i][3] > 0) pq.offer(new Algorithm(alp + problems[i][2],
                            cop + problems[i][3], time + problems[i][4]));*/
                }

            }
//            System.out.println("pq.size() : " + pq.size());
        }
        return minTime;
    }

    private static boolean isSuccess(Algorithm algorithm, int[][] problems) {
        for(int i=0; i< problems.length; i++) {
            if (algorithm.alp < problems[i][0] || algorithm.cop < problems[i][1]) return false;
        }
        return true;
    }

    static class Algorithm implements Comparable<Algorithm> {

        int alp;
        int cop;
        int time;

        public Algorithm(int alp, int cop, int time) {
            this.alp = alp;
            this.cop = cop;
            this.time = time;
        }

        @Override
        public int compareTo(Algorithm o) {
            return this.time - o.time;
        }
    }

}