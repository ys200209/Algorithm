package BOJ.Simulation;

import java.util.*;
import java.io.*;

public class Main_18405 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, K, S, X, Y;
    static int[][] board;
    static boolean[][] visited;
    static ArrayList<Virus> viruses = new ArrayList<>();
     static Queue<Virus> pq = new PriorityQueue<>();
     static Queue<Virus> queue = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j=1;
            while(st.hasMoreTokens()) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if (board[i][j] != 0) {
                    viruses.add(new Virus(i, j, board[i][j]));
                }

                j++;
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        for(int i=0; i<S; i++) {
            while(!pq.isEmpty()) {
                queue.offer(pq.poll());
            }

//            BFS();
        }

        System.out.println(board[X][Y]);

    }

    public static void BFS(Virus virus) {
        int x = virus.x;
        int y = virus.y;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 1 || nx > N || ny < 1 || ny > N) continue;

            if (board[nx][ny] != 0) continue;

            if (visited[nx][ny]) continue;

            visited[nx][ny] = true;
            board[nx][ny] = virus.number;
            pq.offer(new Virus(nx, ny, virus.number));
        }
    }

    static class Virus /*implements Comparable<Virus> */{

        int x;
        int y;
        int number;

        public Virus(int x, int y, int number) {
            this.x = x;
            this.y = y;
            this.number = number;
        }

    /*@Override
    public int compareTo(Virus virus) {
        return this.number - virus.number;
    }*/

    }

}
