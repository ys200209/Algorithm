import java.util.*;
import java.io.*;

public class Main23_13460 {
    static int[] dx = {-1, 1, 0, 0}; // ��, ��, ��, ��
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

            if (i == 0 || i == 1) { // [��, ��]
                if (rx == bx) { // ���� x��ǥ �ΰ�?
                    if (i == 0) // [��] �̶��
                        if (ry < by) MOVE(tempBoard, tempRED, i); // ���ʿ� �ִ� ���� ���� ���� �������ش�.
                        else MOVE(tempBoard, tempBLUE, i);
                    else // [��] ���
                        if (ry > by) MOVE(tempBoard, tempRED, i); // �Ʒ��ʿ� �ִ� ���� ���� �Ʒ��� �������ش�.
                        else MOVE(tempBoard, tempBLUE, i);
                } else { // ���� x��ǥ�� �ƴ϶�� ���� ���� �����̵� �������
                    MOVE(tempBoard, tempRED, i);
                    MOVE(tempBoard, tempBLUE, i);
                }
            } else { // [��, ��]
                if (ry == by) { // ���� y��ǥ �ΰ�?
                    if (i == 2) { // [��] ���
                        if (rx < bx) MOVE(tempBoard, tempRED, i); // ���ʿ� �ִ� ���� ���� �������� �������ش�.
                        else MOVE(tempBoard, tempBLUE, i);
                    } else { // [��] ���
                        if (rx > bx) MOVE(tempBoard, tempRED, i); // �����ʿ� �ִ� ���� ���� ���������� �������ش�.
                        else MOVE(tempBoard, tempBLUE, i);
                    }
                } else {
                    // ���� y��ǥ�� �ƴ϶�� ���� ���� �����̵� �������
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
        Who.x = nx - dx[vector]; // while���� ���ؼ� "."�� �ƴ� ��ǥ���� �������� ������ 
        Who.y = ny - dy[vector]; // ���� ������ ���� ������ "."�� �ƴ� �� ��ǥ���� ���ظ�ŭ ������.
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