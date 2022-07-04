import java.util.*;
import java.io.*;

public class Main_17144 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int R, C, T, A1=-1, A2=-1;
    static Dust[][] board;
    static Queue<Dust> queue;
    
    public static void main(String[] args) throws IOException {

        init();

        for(int t=0; t<T; t++) {
            checkDust(); // 확산시킬 미세먼지들을 큐에 담아주기
            BFS(); // 확산
            board = onClean(); // 공기 청정기 작동
        }

        int result = getDust();

        System.out.println(result);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        board = new Dust[R][C];

        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j=0;
            while(st.hasMoreTokens()) {
                int amount = Integer.parseInt(st.nextToken());
                board[i][j] = amount == 0 ? null : new Dust(i, j, amount, 0);

                if (board[i][j] != null && board[i][j].now == -1) {
                    if (A1 == -1) A1 = i;
                    else A2 = i;
                    board[i][j] = null; // 공기 청정기가 있는 곳의 먼지를 0으로 만들어주기 (공기 청정기 동작을 쉽게 하려고)
                } 

                j++;
            }
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

            if (amount < 1) continue; // 확산할 양이 안되면 무시

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;

                if ((nx == A1 || nx == A2) && ny == 0) continue; // 확산 지역에 공기 청정기가 존재한다면 중지

                if (board[nx][ny] == null) board[nx][ny] = new Dust(nx, ny, 0, amount);
                else board[nx][ny].add += amount;

                diffuse++; // 퍼진 횟수
            }

            dust.now -= (amount * diffuse);
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

    public static Dust[][] onClean() {
        Dust[][] temp = new Dust[R][C];

        for(int i=1; i<A1; i++) { // 공기 청정기가 동작되지 않는 부분에 먼지 주입 (상단)
            for(int j=1; j<C-1; j++) {
                temp[i][j] = board[i][j];
            }
        }

        for(int i=A2+1; i<R-1; i++) { // 공기 청정기가 동작되지 않는 부분에 먼지 주입 (하단)
            for(int j=1; j<C-1; j++) {
                temp[i][j] = board[i][j];
            }
        }

        for(int i=1; i<C; i++) { // 가로
            temp[0][C-i-1] = board[0][C-i]; // 1행
            if (temp[0][C-i-1] != null) temp[0][C-i-1].y = C-i-1;
            temp[A1][i] = board[A1][i-1]; // A1 행
            if (temp[A1][i] != null) temp[A1][i].y = i;
            temp[A2][i] = board[A2][i-1]; // A2 행
            if (temp[A2][i] != null) temp[A2][i].y = i;
            temp[R-1][C-i-1] = board[R-1][C-i]; // R 행
            if (temp[R-1][C-i-1] != null) temp[R-1][C-i-1].y = C-i-1;
        }

        for(int i=0; i<A1; i++) { // 상단 세로
            temp[i+1][0] = board[i][0]; // 1열
            if (temp[i+1][0] != null) temp[i+1][0].x = i+1;
            temp[A1-i-1][C-1] = board[A1-i][C-1]; // C열
            if (temp[A1-i-1][C-1] != null) temp[A1-i-1][C-1].x = A1-i-1;
        }

        for(int i=A2; i<R-1; i++) { // 하단 세로
            temp[i][0] = board[i+1][0]; // 1열
            if (temp[i][0] != null) temp[i][0].x = i;
            temp[i+1][C-1] = board[i][C-1]; // C열
            if (temp[i+1][C-1] != null) temp[i+1][C-1].x = i+1;
        }

        // 공기 청정기로 들어간 먼지 없애기
        temp[A1][0] = null;
        temp[A2][0] = null;

        return temp;
    }

    public static int getDust() {
        int result = 0;

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if (board[i][j] != null && board[i][j].now > 0) result += board[i][j].now;
            }
        }

        return result;
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