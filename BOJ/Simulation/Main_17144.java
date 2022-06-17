import java.util.*;
import java.io.*;

public class Main_17144 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int UP=-1, DOWN=-1;
    static int R, C, T;
    static int[][] board;
    static Queue<Dust> dusts = new LinkedList<>();
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        board = new int[R][C];
        visited = new int[R][C];

        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int j=0;
            while(st.hasMoreTokens()) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if (board[i][j] == -1) {
                    visited[i][j] = true;

                    if (UP == -1) UP = i;
                    else DOWN = i;
                }

                if (board[i][j] != 0 && board[i][j] != -1) {
                    dusts.offer(new Dust(i, j, board[i][j], 0));
                    visited[i][j] = true;
                }
            }
        }

        for(int t=0; t<T; t++) {
            diffuse();

            clean();

            dusts = add();
        }


    }

    public static void diffuse() {
        while(!dusts.isEmpty()) {
            Dust dust = dusts.poll();
            int x = dust.x;
            int y = dust.y;
            int amount = dust.amount;

            if (amount < 5) continue;

            int count=0;

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;

                if (visited[nx][ny]) continue;

                
            }

        }
    }

    public static clean() {

    }

    public static Queue<Dust> add() {

        return new LinkedList<Dust>();
    }

}

class Dust {

    int x;
    int y;
    int amount;
    int BeDeffused;

    public Dust(int x, int y, int amount, int BeDeffused) {
        this.x = x;
        this.y = y;
        this.amount = amount;
        this.BeDeffused = BeDeffused;
    }

}