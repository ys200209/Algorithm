package BOJ.Brute_Force;

import java.io.*;
import java.util.*;

public class Main11_17825 {
    static int INF = (int)1e9;
    static int[][] dp;
//    static List<List<Integer>> graph = new ArrayList<>();


    public static void main(String[] args) throws IOException {
//        System.out.println(solution(6, 4, 6, 2,
//                new int[][]{{4,1,10}, {3,5,24}, {5,6,2}, {3,1,41}, {5,1,24}, {4,6,50}, {2,4,66},{2,3,22}, {1,6,25}}));
//        // 82
        System.out.println(solution(7, 3, 4, 1,
                new int[][]{{5,7,9}, {4,6,4}, {3,6,1}, {3,2,3}, {2,1,6}}));
        // 14
    }

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;

        dp = new int[n+1][n+1];

        /*for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }*/

        for(int i=1; i<=n; i++) {
            Arrays.fill(dp[i], INF);
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if (i == j) dp[i][j] = 0;
            }
        }

        for(int i=0; i<fares.length; i++) {
            int[] fare = fares[i];
            int x = fare[0];
            int y = fare[1];
            int c = fare[2];

            dp[x][y] = c;
            dp[y][x] = c;
//            System.out.println("dp[x][y] = " + dp[x][y]);
        }

        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }

        for(int i=0; i<=n; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        int distance = dp[s][a] + dp[s][b];
        for(int i=1; i<=n; i++) {
//            if (i == s || i == a || i == b) continue;

            int d = dp[s][i] + dp[i][a] + dp[i][b];
            if (d >= (int)1e9 || d < 0) continue;

            distance = Math.min(distance, d);
//            System.out.println("distance = " + distance);
        }

        distance = Math.min(distance, Math.min(dp[s][a] + dp[a][b], dp[s][b] + dp[b][a]));

        return distance;
    }

}