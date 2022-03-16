import java.util.*;
import java.io.*;

public class Main23_2239 {
    static int[][] board, result;
    static int zero = 0;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        board = new int[9][9];
        result = new int[9][9];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<9; i++) {
            String[] str = br.readLine().split("");
            for(int j=0; j<9; j++) {
                board[i][j] = Integer.parseInt(str[j]);
                if (board[i][j] == 0) zero++;
            }
        }

        for(int i=0; i<9; i++) {
            // System.out.println(Arrays.toString(board[i]));
        }

        DFS(0);
        
    }

    public static void DFS(int count) {
        if (count == zero) {
            for(int i=0; i<9; i++) {
                for(int j=0; j<9; j++) {
                    sb.append(board[i][j]);
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if (board[i][j] == 0) {
                    for(int k=1; k<=9; k++) {
                        if (Row(j, k) && Column(i, k) && Square(i, j, k)) {
                            board[i][j] = k;
                            DFS(count+1);
                            board[i][j] = 0;
                        }
                    }
                    return;
                }
            }
        }
    }

    public static boolean Row(int column, int num) {
        
        for(int i=0; i<9; i++) {
            if (board[i][column] == num) return false;
        }
        return true;
    }

    public static boolean Column(int row, int num) {
        for(int i=0; i<9; i++) {
            if (board[row][i] == num) return false;
        }
        return true;
    }

    public static boolean Square(int row, int column, int num) {
        for(int i=row/3*3; i<row/3*3+3; i++) {
            for(int j=column/3*3; j<column/3*3+3; j++) {
                // System.out.println("i : " + i + ", j : " + j + ", num : " + num);
                if (board[i][j] == num) return false;
            }
        }

        return true;
    }

}