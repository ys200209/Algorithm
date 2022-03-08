import java.util.*;
import java.io.*;

public class Main20_2239 {
    static int[][] board, temp;
    static boolean[] numList = new boolean[10];
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[9][9];
        temp = new int[9][9];

        for(int i=0; i<9; i++) {
            String s = br.readLine();
            for(int j=0; j<9; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }

        Divide(0, 0, 9);

        for(int i=0; i<9; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    public static void Divide(int row, int column, int size) { // 분할 정복(Divider_And_Conquer)
        if (size == 3) {
            numList = new boolean[10];
            for(int i=row; i<row+size; i++) {
                for(int j=column; j<column+size; j++) {
                    numList[board[i][j]] = true;
                }
            }

            inputNumber(row, column, size);
            return;
        }

        size /= 3;
        Divide(row, column, size);
        Divide(row, column+size, size);
        Divide(row, column+(size*2), size);
        Divide(row+size, column, size);
        Divide(row+size, column+size, size);
        Divide(row+size, column+(size*2), size);
        Divide(row+(size*2), column, size);
        Divide(row+(size*2), column+size, size);
        Divide(row+(size*2), column+(size*2), size);

    }

    public static boolean inputNumber(int row, int column, int size) {
        
        for(int i=row; i<row+size; i++) {
            for(int j=column; j<column+size; j++) {
                if (board[i][j] == 0) {
                    for(int k=1; k<10; k++) {
                        if (!numList[k]) {
                            //System.out.println("[" + i + ", " + j + "] : " + k);
                            board[i][j] = k;
                            numList[k] = true;
                            if (checkNumber(i, j)) {
                                if (inputNumber(row, column, size)) return true;
                            }
                            numList[k] = false;
                            board[i][j] = 0;
                            //System.out.println("[" + i + ", " + j + "] : " + k + " XXX : " + numList[k]);
                        }
                    }
                }
                
            }
        }
        
        numList[0] = true;
        for(boolean bool : numList) {
            if (!bool) return false;
        }
        return true;
    }

    public static boolean checkNumber(int row, int column) {
        boolean[] visited = new boolean[10];
        for(int i=0; i<9; i++) {
            if (board[row][i] == 0) continue;

            if (visited[board[row][i]]) {
                //System.out.println("false1");
                //System.out.println("[" + row + ", " + i + "] : " + board[row][i]);
                return false;
            }
            visited[board[row][i]] = true;
        }
        Arrays.fill(visited, false);
        for(int i=0; i<9; i++) {
            if (board[i][column] == 0) continue;

            if (visited[board[i][column]]) {
                //System.out.println("[" + i + ", " + column + "] : " + board[i][column]);
                //System.out.println("false2");
                return false;
            }
            visited[board[i][column]] = true;
        }

        return true;
    }

}
