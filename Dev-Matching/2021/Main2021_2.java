import java.util.*;

public class Main2021_2 {
    static int[][] board;

    public static void main(String[] args) {

        System.out.println(solution(6, 6, new int[][]{{2,2,5,4},{3,3,6,6},{5,1,6,3}}));

    }
    
    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};

        board = new int[rows+1][columns+1];

        for(int i=0; i<rows; i++) {
            for(int j=1; j<=columns; j++) {
                board[i+1][j] = i * rows + j;
            }
            System.out.println(Arrays.toString(board[i]));
        }

        for(int i=0; i<queries.length; i++) {
            int[] arr = queries[i];

            rotate(arr[0], arr[1], arr[2], arr[3]);
        }


        return answer;
    }

    public static void rotate(int x1, int y1, int x2, int y2) {
        System.out.println("(" + x1 + ", " + y1 + ") -> (" + x2 + ", " + y2 + ")");
        show();

        int temp;

        for(int i=x1; i<=x2; i++) {
            for(int j=y1; j<=y2; j++) {
                if (i == x1 || i == x2 || j == y1 || j == y2) {
                    // [0, 0] -> [0, 1]
                    // [0, 1] -> [0, 2]
                    // [0, 2] -> [1, 2]
                    // [1, 2] -> [2, 2]
                    // [2, 2] -> [2, 3]
                    // [2, 3] -> [3, 3]
                    System.out.println("(for) (" + i + ", " + j + ") -> (x"  + ", " + (j+i-1) + ")");
                    // board[i][j] = board[][j+i-1];
                }
            }
        }

        show();
    }

    public static void show() {
        System.out.println("\n-------------[show]------------");
        for(int i=0; i<board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

}