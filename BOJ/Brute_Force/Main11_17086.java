package BOJ.Brute_Force;

import java.io.*;
import java.util.*;

public class Main11_17086 {
    static int N, M, result=0;
    static int[][] board;
    static List<Shark> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j=0;
            while(st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    list.add(new Shark(i, j));
                    board[i][j] = 1;
                }
                j++;
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if (board[i][j] != 1) {
                    int distance = getDistance(i, j);
                    result = Math.max(result, distance);
                }
            }
        }

        System.out.println(result);
    }

    private static int getDistance(int i, int j) {
        int result = (int)1e9;

        for (Shark shark : list) {
            int distance = 0;

            int x = shark.x;
            int y = shark.y;
            int nx = i;
            int ny = j;
            int dx=0;
            int dy=0;

            while(x != nx || y != ny) {
                if (x != nx && y != ny) { // 둘 다 안맞을 때 (대각선)
                    if (x < nx) dx = -1;
                    else dx = 1;
                    if (y < ny) dy = -1;
                    else dy = 1;
                } else if (x != nx && y == ny) {
                    if (x < nx) dx = -1;
                    else dx = 1;
                    dy = 0;
                } else if (x == nx && y != ny) {
                    dx = 0;
                    if (y < ny) dy = -1;
                    else dy = 1;
                }

                nx += dx;
                ny += dy;
                distance++;
            }
            result = Math.min(result, distance);
        }
        return result;
    }

    static class Shark {
        int x;
        int y;

        public Shark(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}