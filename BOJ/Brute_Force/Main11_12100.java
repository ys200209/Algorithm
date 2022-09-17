package BOJ.Brute_Force;

import java.io.*;
import java.util.*;

public class Main11_12100 {
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};
    static int N, score=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j=0;
            while(st.hasMoreTokens()) {
                board[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

        DFS(0, board);

        /*for(int i=0; i<4; i++) {
            if (i == 0) print(UP(i, board));
            else if (i == 1) print(DOWN(i, board));
            else if (i == 2) print(LEFT(i, board));
            else print(RIGHT(i, board));
        }*/

        System.out.println(score);
    }

    private static void DFS(int count, int[][] board) {
        if (count == 5) {
            score = Math.max(score, getScore(board));
            return;
        }

        for(int i=0; i<4; i++) {
            if (i == 0) DFS(count+1, UP(i, board));
            else if (i == 1) DFS(count+1, DOWN(i, board));
            else if  (i == 2) DFS(count+1, LEFT(i, board));
            else DFS(count+1, RIGHT(i, board));
        }
    }

    /*private static void print(int[][] temp) {
        System.out.println();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(temp[i][j] + " ");
            }
            System.out.println();
        }
    }*/

    private static int[][] UP(int vector, int[][] board) {
        int[][] temp = copyArr(board);

        for(int column=0; column<N; column++) {
            int limit = 1;
            for(int row=1; row<N; row++) {
                if (temp[row][column] == 0) continue;

                int now = row;
                boolean isMove = false;
                while(now >= limit) {
                    if (temp[now + dx[vector]][column] == temp[row][column]) { // 블록을 합치던 중, 같은 블록을 발견
                        temp[row][column] = 0;
                        temp[now + dx[vector]][column] *= 2;
                        isMove = true;
                        limit = now + 1; // 합친 블록에는 (now+dx[vector])로 조차 접근해서는 안된다. (+1)
                        break;
                    } else if (temp[now + dx[vector]][column] != 0) { // 블록을 움직이던 중, 다른 블록에게 막혔다면
                        int num = temp[row][column];
                        temp[row][column] = 0;
                        temp[now][column] = num;
                        limit = now; // 옮긴 블록에는 새로운 블록이 합쳐질 가능성을 열어둔다.
                        isMove = true;
                        break;
                    }
                    now += dx[vector];
                }

                if (!isMove) {
                    temp[now][column] = temp[row][column];
                    temp[row][column] = 0;
                }
            }
        }
        return temp;
    }

    private static int[][] DOWN(int vector, int[][] board) {
        int[][] temp = copyArr(board);

        for(int column=0; column<N; column++) {
            int limit = N-2;
            for(int row=N-2; row>=0; row--) {
                if (temp[row][column] == 0) continue;

                int now = row;
                boolean isMove = false;
                while(now <= limit) {
                    if (temp[now + dx[vector]][column] == temp[row][column]) { // 블록을 합치던 중, 같은 블록을 발견
                        temp[row][column] = 0;
                        temp[now + dx[vector]][column] *= 2;
                        isMove = true;
                        limit = now - 1; // 합친 블록에는 (now+dx[vector])로 조차 접근해서는 안된다. (-1)
                        break;
                    } else if (temp[now + dx[vector]][column] != 0) { // 블록을 움직이던 중, 다른 블록에게 막혔다면
                        int num = temp[row][column];
                        temp[row][column] = 0;
                        temp[now][column] = num;
                        limit = now; // 옮긴 블록에는 새로운 블록이 합쳐질 가능성을 열어둔다.
                        isMove = true;
                        break;
                    }
                    now += dx[vector];
                }

                if (!isMove) {
                    temp[now][column] = temp[row][column];
                    temp[row][column] = 0;
                }
            }
        }
        return temp;
    }

    private static int[][] LEFT(int vector, int[][] board) {
        int[][] temp = copyArr(board);

        for(int row=0; row<N; row++) {
            int limit = 1;
            for (int column=1; column<N; column++) {
                if (temp[row][column] == 0) continue;

                int now = column;
                boolean isMove = false;
                while(now >= limit) {
                    if (temp[row][now + dy[vector]] == temp[row][column]) { // 블록을 합치던 중, 같은 블록을 발견한다면
                        temp[row][column] = 0;
                        temp[row][now + dy[vector]] *= 2;
                        isMove = true;
                        limit = now + 1; // 합친 블록에는 (now+dx[vector])로 조차 접근해서는 안된다.
                        break;
                    } else if (temp[row][now + dy[vector]] != 0) { // 블록을 움직이던 중, 다른 블록에게 막혔다면
                        int num = temp[row][column];
                        temp[row][column] = 0;
                        temp[row][now] = num;
                        limit = now;
                        isMove = true;
                        break;
                    }
                    now += dy[vector];
                }

                if (!isMove) {
                    temp[row][now] = temp[row][column];
                    temp[row][column] = 0;
                }
            }
        }
        return temp;
    }

    private static int[][] RIGHT(int vector, int[][] board) {
        int[][] temp = copyArr(board);

        for(int row=0; row<N; row++) {
            int limit = N-2;
            for (int column=N-2; column>=0; column--) {
                if (temp[row][column] == 0) continue;

                int now = column;
                boolean isMove = false;
                while(now <= limit) {
                    if (temp[row][now + dy[vector]] == temp[row][column]) { // 블록을 합치던 중, 같은 블록을 발견
                        temp[row][column] = 0;
                        temp[row][now + dy[vector]] *= 2;
                        isMove = true;
                        limit = now - 1; // 합친 블록에는 (now+dx[vector])로 조차 접근해서는 안된다. (+1)
                        break;
                    } else if (temp[row][now + dy[vector]] != 0) { // 블록을 움직이던 중, 다른 블록에게 막혔다면
                        int num = temp[row][column];
                        temp[row][column] = 0;
                        temp[row][now] = num;
                        limit = now; // 옮긴 블록에는 새로운 블록이 합쳐질 가능성을 열어둔다.
                        isMove = true;
                        break;
                    }
                    now += dy[vector];
                }

                if (!isMove) {
                    temp[row][now] = temp[row][column];
                    temp[row][column] = 0;
                }
            }
        }
        return temp;
    }

    private static int[][] copyArr(int[][] board) {
        int[][] temp = new int[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                temp[i][j] = board[i][j];
            }
        }
        return temp;
    }

    private static int getScore(int[][] board) {
        int score = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                score = Math.max(score, board[i][j]);
            }
        }
        return score;
    }
}