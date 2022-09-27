package BOJ.Brute_Force;

import java.util.*;
import java.io.*;

public class Main11_2589 {
    static int N, M;
    static String[][] map;
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new String[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            map[i] = br.readLine().split("");
        }

        


        


    }

    static class Position {
        int x;
        int y;
        String str;

        public Position(int x, int y, String str) {
            this.x = x;
            this.y = y;
            this.str = str;
        }
    }

}
