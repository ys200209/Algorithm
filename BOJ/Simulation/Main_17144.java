import java.util.*;
import java.io.*;

public class Main_17144 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int R, C, T, A1=-1, A2=-1;
    static Dust[][] board;
    // static AirCleaner ac;
    static Queue<Dust> queue;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        board = new int[R][C];

        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j=0;
            while(st.hasMoreTokens()) {
                int amount = Integer.parseInt(st.nextToken());
                board[i][j] = amount == 0 ? null : new Dust(i, j, amount, 0);
                // if (board[i][j].now > 0) queue.offer(new Dust(board[i][j]));

                if (board[i][j] == -1) {
                    if (A1 == -1) A1 = i;
                    else A2 = i;
                    board[i][j] = 0; // 공기 청정기가 있는 곳의 먼지를 0으로 만들어주기 (공기 청정기 동작을 쉽게 하려고)
                } 

                j++;
            }
        }

        for(int i=0; i<T; t++) {
            checkDust(); // 확산시킬 미세먼지들을 큐에 담아주기
            BFS(); // 확산
            onClean(); // 공기 청정기 작동
        }

    }

    public static void checkDust() {
        queue = new LinkedList<>();

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if (board[i][j] != null) queue.offer(board[i][j]);
            }
        }
    }

    public static void BFS() {
        while(!queue.isEmpty()) {
            Dust dust = queue.poll();
            int x = dust.x;
            int y = dust.y;
            int diffuse = 0; // 퍼진 횟수
            int amount = dust.now / 5; // 퍼지는 양

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;

                if (board[nx][ny] == -1) continue; // 확산 지역에 공기 청정기가 존재한다면 중지

                if (board[nx][ny] == null) board[nx][ny] = new Dust(nx, ny, 0, amount);
                else board[nx][ny].add += amount;

                diffuse++; // 퍼진 횟수
            }

            board[x][y].now -= (amount * diffuse);
        }

        for(int i=0; i<R; i++) { // 확산 적용해주기
            for(int j=0; j<C; j++) {
                if (board[i][j] != null) {
                    board[i][j].now += board[i][j].add;
                    board[i][j].add = 0;
                }
            }
        }
    }

    public static void onClean() {
        Dust[][] temp = copyArray();

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                System.out.println(board[i][j].now + " ");
            }
            System.out.println();
        }

        for(int i=1; i<C; i++) { // 가로
            temp[0][C-i-1] = board[0][C-i]; // 1행
            temp[A1][i] = board[A1][i-1]; // A1 행
            temp[A2][i] = board[A2][i-1]; // A2 행
            temp[R-1][C-i-1] = board[R-1][C-i]; // R 행
        }

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                System.out.println(temp[i][j] != null ? (temp[i][j].now : " ") + " ");
            }
            System.out.println();
        }

        for(int i=0; i<R; i++) { // 세로

        }

        // 공기 청정기로 들어간 먼지 없애기
        board[A1][0] = null;
        board[A2][0] = null;
    }

    public static Dust[][] copyArray() {
        return new Dust[R][C];
    }

}

class Dust {

    int x;
    int y;
    int now;
    int add;

    public Dust(int x, int y, int now, int add) {
        this.x = x;
        this.y = y;
        this.now = now;
        this.add = add;
    }

}

/*class AirCleaner {

    int p1;
    int p2;

    public AirCleaner(int p1, int p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

}*/