package BOJ.Implementation;

import java.io.*;
import java.util.*;

public class Main2_19237 {
    static int[] dx = {0, -1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, 0, -1, 1};
    static int N, M, K, result=0, sharkCount;
    static Shark[][] board;
    static List<Shark> smells = new ArrayList<>();
    static Shark[] sharks;

    public static void main(String[] args) throws IOException {
        
        init();

        startGame();



    }

    private static void startGame() {

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new Shark[N][N];
        sharks = new Shark[M+1];
        sharkCount = M;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j=0;
            while(st.hasMoreTokens()) {
                int number = Integer.parseInt(st.nextToken());

                if (number != 0) {
                    Shark shark = new Shark(i, j, number, K);
                    sharks[number] = shark;
                    board[i][j] = shark;
                    smells.add(shark);
                } else board[i][j] = null;

                j++;
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        int i = 1;
        while(st.hasMoreTokens()) {
            sharks[i].vector = Integer.parseInt(st.nextToken());
            i++;
        }

        for(i=1; i<=M; i++) {
            for(int j=1; j<=4; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                sharks[i].vectorList.put(j, new ArrayList<>(Arrays.asList(a, b, c, d)));
            }
        }
    }

    static class Shark implements Comparable<Shark> {
        int x;
        int y;
        int number;
        int count;
        int vector;
        Map<Integer, List<Integer>> vectorList;

        public Shark(int x, int y, int number, int count) {
            this.x = x;
            this.y = y;
            this.number = number;
            this.count = count;
        }

        @Override
        public int compareTo(Shark o) {
            return this.count - o.count;
        }
    }

}
