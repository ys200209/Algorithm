package BOJ.Brute_Force;

import java.io.*;
import java.util.*;

public class Main11_17281 {
    static int N, result=0;
    static int[][] game;
    static List<Integer> numbers = new ArrayList<>();
    static boolean[] visited;
    static int[] field = new int[3];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        game = new int[N+1][10];
        visited = new boolean[10];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j=1;
            while(st.hasMoreTokens()) {
                game[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

        visited[1] = true;
        numbers.add(1);
        DFS(0);


    }

    private static void DFS(int count) {
        if (count == 9) {
            int score = getScore();


            return;
        }

        for(int i=2; i<=N; i++) {
            if(!visited[i]) {
                numbers.add(i);
                visited[i] = true;
                DFS(count+1);
                visited[i] = false;
                numbers.remove(i);

            }


        }

    }

    private static int getScore() {
        Arrays.fill(field, 0);
        int score = 0;
        int inning = 1;
        int out=0;
        int index = 0;

        while(inning < N) {

            while(out < 3) {
                for(int i=index; i<9; i++) {
                    index = i;
                    int num = game[inning][i];
                    if (num == 0) out++;

                    if (out == 3) break;

                    for(int j=3; j>=1; j--) {
                        if (field[j] + num > 3) {
                            field[j] = 0;
                            score++;
                        }

                        if (field[j] != 0) {
                            int f = field[j];
                            field[j] = 0;
                            field[f]++;
                        }
                    }
                }
            }

            out = 0;
            inning++;
        }


        return score;
    }

}