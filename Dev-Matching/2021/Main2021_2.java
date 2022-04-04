import java.util.*;

public class Main2021_2 {
    static int[][] board;

    public static void main(String[] args) {

        // System.out.println(Arrays.toString(solution(6, 6, new int[][]{{2,2,5,4},{3,3,6,6},{5,1,6,3}})));
        System.out.println(Arrays.toString(solution(3, 5, new int[][]{{1,1,2,2}, {2,3,3,4}, {1,2,3,4}, {1,1,3,4}, {2,2,3,5}})));

    }
    
    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        board = new int[rows+1][columns+1];

        for(int i=0; i<rows; i++) {
            for(int j=1; j<=columns; j++) {
                board[i+1][j] = i * columns + j;
            }
        }

        for(int i=0; i<board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }

        for(int i=0; i<queries.length; i++) {
            int[] arr = queries[i];

            answer[i] = rotate(arr[0], arr[1], arr[2], arr[3]);
        }


        return answer;
    }

    public static int rotate(int x1, int y1, int x2, int y2) {
        System.out.println("(" + x1 + ", " + y1 + ") -> (" + x2 + ", " + y2 + ")");
        int MIN = (int)1e9;

        int[][] temp = new int[x2-x1+1][y2-y1+1];
        for(int i=0; i<=x2-x1; i++) {
            for(int j=0; j<=y2-y1; j++) {
                temp[i][j] = board[i+x1][j+y1];
            }
        }
        // show(temp);

        for(int i=1; i<temp[0].length; i++) { // 가로 위 아래 회전
            temp[0][i] = board[x1][y1+i-1];
            temp[temp.length-1][temp[0].length-i-1] = board[x2][y2-i+1];
            MIN = Math.min(MIN, temp[0][i]);
            MIN = Math.min(MIN, temp[temp.length-1][temp[0].length-i-1]);
        }

        for(int i=1; i<temp.length; i++) { // 세로 왼쪽 아래쪽 회전
            temp[i][temp[0].length-1] = board[x1+i-1][y2];
            temp[temp.length-i-1][0] = board[x2-i+1][y1];
            MIN = Math.min(MIN, temp[i][temp[0].length-1]);
            MIN = Math.min(MIN, temp[temp.length-i-1][0]);
        }

        for(int i=x1; i<=x2; i++) {
            for(int j=y1; j<=y2; j++) {
                board[i][j] = temp[i-x1][j-y1];
            }
        }

        show(board);
        return MIN;
    }

    public static void show(int[][] t) {
        System.out.println("-------------[show]------------");
        for(int i=0; i<t.length; i++) {
            System.out.println(Arrays.toString(t[i]));
        }
    }

}