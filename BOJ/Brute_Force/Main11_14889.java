package BOJ.Brute_Force;

import java.io.*;
import java.util.*;

public class Main11_14889 {
    static int N, result=(int)1e9;
    static int[][] board;
    static List<Integer> team = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N =Integer.parseInt(br.readLine());
        board = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j=0;
            while(st.hasMoreTokens()) {
                board[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

        DFS(0, 0);

        System.out.println(result);
    }

    private static void DFS(int index, int count) {
        if (count == N/2) {
            result = Math.min(result, getScore());
            return;
        }

        for(int i=index; i<N; i++) {
            team.add(i);
            DFS(i+1, count+1);
            team.remove(count);
        }

    }

    private static int getScore() {
        int score1 = 0;
        int score2 = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if (team.contains(i) && team.contains(j)) {
                    score1 += board[i][j];
                } else if (!team.contains(i) && !team.contains(j)) {
                    score2 += board[i][j];
                }
            }
        }

        return Math.abs(score1 - score2);
    }

}