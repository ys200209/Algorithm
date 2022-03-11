import java.util.*;
import java.io.*;

public class Main23_13460 {
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};
    static int N, M, result=0;
    static String[][] board;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new String[N][M];

        Point RED = null, BLUE = null;
        for(int i=0; i<N; i++) {
            board[i] = br.readLine().split("");
            for(int j=0; j<M; j++) {
                if (board[i][j].equals("R")) RED = new Point("R", i, j);
                if (board[i][j].equals("B")) BLUE = new Point("B", i, j);
            }
        }

        DFS(board, 0, RED, BLUE);

    }

    public static void DFS(String[][] b, int count, Point RED, Point BLUE) {
        if (count > 10) {
            result = -1;
            return;
        }

        int rx = RED.x;
        int ry = RED.y;
        int bx = BLUE.x;
        int by = BLUE.y;

        for(int i=0; i<4; i++) {
            String[][] tempBoard = setBoard(b);
            Point tempRED = new Point("R", RED.x, RED.y);
            Point tempBLUE = new Point("B", BLUE.x, BLUE.y);

            if (i == 0 || i == 1) { // [상, 하]
                if (rx == bx) { // 같은 x좌표 인가?
                    if (i == 0) // [상] 이라면
                        if (ry < by) MOVE(tempBoard, tempRED, i); // 위쪽에 있는 구슬 먼저 위로 움직여준다.
                        else MOVE(tempBoard, tempBLUE, i);
                    else // [하] 라면
                        if (ry > by) MOVE(tempBoard, tempRED, i); // 아랫쪽에 있는 구슬 먼저 아래로 움직여준다.
                        else MOVE(tempBoard, tempBLUE, i);
                } else { // 같은 x좌표가 아니라면 누굴 먼저 움직이든 상관없음
                    MOVE(tempBoard, tempRED, i);
                    MOVE(tempBoard, tempBLUE, i);
                }
            } else { // [좌, 우]
                if (ry == by) { // 같은 y좌표 인가?
                    if (i == 2) { // [좌] 라면
                        if (rx < bx) MOVE(tempBoard, tempRED, i); // 왼쪽에 있는 구슬 먼저 왼쪽으로 움직여준다.
                        else MOVE(tempBoard, tempBLUE, i);
                    } else { // [우] 라면
                        if (rx > bx) MOVE(tempBoard, tempRED, i); // 오른쪽에 있는 구슬 먼저 오른쪽으로 움직여준다.
                        else MOVE(tempBoard, tempBLUE, i);
                    }
                } else {
                    // 같은 y좌표가 아니라면 누굴 먼저 움직이든 상관없음
                    MOVE(tempBoard, tempRED, i);
                    MOVE(tempBoard, tempBLUE, i);
                }
            }

            if ((tempRED == null && tempBLUE == null) || (tempRED != null && tempBLUE == null)) {
                System.out.println("-1");
                System.exit(0);
            } else if (tempRED == null && tempBLUE != null) {
                System.out.println(count);
                System.exit(0);
            }

            DFS(tempBoard, count+1, tempRED, tempBLUE);

        }


    }

    public static void MOVE(String[][] temp, Point Who, int vector) {
        int nx = Who.x + dx[vector];
        int ny = Who.y + dy[vector];
        if (temp[nx][ny].equals("O")) {
            Who = null;
            return;
        }

        while(temp[nx][ny].equals(".")) {
            nx += dx[vector];
            ny += dy[vector];
            if (temp[nx][ny].equals("O")) {
                Who = null;
                return;
            }
        }

        temp[Who.x][Who.y] = ".";
        Who.x = nx - dx[vector]; // while문에 의해서 "."이 아닌 좌표까지 움직였기 때문에 
        Who.y = ny - dy[vector]; // 값을 저장할 때는 마지막 "."이 아닌 한 좌표값을 빼준만큼 저장함.
        temp[Who.x][Who.y] = Who.color;
    }

    public static String[][] setBoard(String[][] b) {
        String[][] tempBoard = new String[b.length][b[0].length];

        for(int i=0; i<b.length; i++) {
            for(int j=0; j<b[0].length; j++) {
                tempBoard[i][j] = b[i][j];
            }
        }
        return tempBoard;
    }

}

class Point {

    String color;
    int x;
    int y;

    public Point(String color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

}