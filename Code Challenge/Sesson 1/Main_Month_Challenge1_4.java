import java.util.*;

class Main_Month_Challenge1_4 {
    static int count = 1, row=-1, column=0, N;
    static int[][] board;

    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(4))); // [1,2,9,3,10,8,4,5,6,7]
        // System.out.println(Arrays.toString(solution(2))); // [1,2,9,3,10,8,4,5,6,7]

    }

    public static int[] solution(int n) {
        int[] answer;
        N = n;
        board = new int[N][N];
        
        while(true) {
            int before = count;

            Lower();

            int after = count;
            
            if (before == after) break;
        }

        answer = new int[count-1];
        
        int index=0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<=i; j++) {
                answer[index++] = board[i][j];
            }
        }
        return answer;
    }

    public static void Lower() {
        while(true) {
            if (row >= N-1) break;
            
            if (board[row+1][column] != 0) break;

            board[row+1][column] = count++;
            row++;
        }
        Right();
    }

    public static void Right() {
        while(true) {
            if (column >= row) break;

            if (board[row][column+1] != 0) break;

            board[row][column+1] = count++;
            column++;
        }
        Upper();
    }

    public static void Upper() {
        while(true) {
            if (row <= 0 || column <= 0) break;

            if (board[row-1][column-1] != 0) break;

            board[row-1][column-1] = count++;
            row--;
            column--;
        }
    }
}