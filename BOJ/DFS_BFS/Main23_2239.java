import java.util.*;
import java.io.*;

public class Main23_2239 {
    static int[][] board, result;
    
    public static void main(String[] args) throws IOException {

        board = new int[10][10];
        result = new int[10][10];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=1; i<=9; i++) {
            String[] str = br.readLine().split("");
            for(int j=1; j<=9; j++) {
                board[i][j] = Integer.parseInt(str[j-1]);
            }
        }
        
        Divide(1, 1, 9);

        System.out.println("[board]");
        for(int i=1; i<=9; i++) {
            System.out.println(Arrays.toString(board[i]));
        }

    }

    public static void Divide(int row, int column, int size) {
        if (size == 3) {

            int count = 0;
            for(int i=row; i<row+size; i++) {
                for(int j=column; j<column+size; j++) {
                    if (board[i][j] == 0) count++;
                }
            }

            DFS(row, column, 0, count);

            /*System.out.println("[result]");
            for(int i=0; i<=9; i++) {
                System.out.println(Arrays.toString(result[i]));
            }*/

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

    public static boolean DFS(int row, int column, int now, int count) {
        if (now == count) {
            setResult(board);
            return true;
        }


        boolean[] square = getSquare(row, column);
        /*boolean[] w = getWidth(row);
        boolean[] h = getHeight(column);

        System.out.println("row : " + row + ", column " + column);
        System.out.println(Arrays.toString(w));
        System.out.println(Arrays.toString(h));
        System.out.println(Arrays.toString(square));*/

        
        for(int i=row; i<row+3; i++) {
            boolean[] width = null;
            for(int j=column; j<column+3; j++) {
                if (board[i][j] == 0) {
                    width = getWidth(i);
                    boolean[] height = getHeight(j);
                    
                    for(int k=1; k<=9; k++) {
                        if (!width[k] && !height[k] && !square[k]) {
                            // System.out.println("k : " + k);
                            board[i][j] = k;
                            width[k] = true;
                            height[k] = true;
                            square[k] = true;
                            if (DFS(row, column, now+1, count)) return true;
                            width[k] = false;
                            height[k] = false;
                            square[k] = false;
                            board[i][j] = 0;
                        }
                    }
                    

                }
            }
        }


        return false;
    }

    public static boolean[] getWidth(int row) {
        boolean[] v = new boolean[10];
        
        for(int i=1; i<=9; i++) {
            v[board[row][i]] = true;
        }

        return v;
    }

    public static boolean[] getHeight(int column) {
        boolean[] v = new boolean[10];

        for(int i=1; i<=9; i++) {
            v[board[i][column]] = true;
        }
        
        return v;
    }

    public static boolean[] getSquare(int row, int column) {
        boolean[] v = new boolean[10];

        for(int i=row; i<row+3; i++) {
            for(int j=column; j<column+3; j++) {
                v[board[i][j]] = true;
            }
        }
        
        return v;
    }

    public static void setResult(int[][] temp) {
        for(int i=1; i<=9; i++) {
            for(int j=1; j<=9; j++) {
                result[i][j] = temp[i][j];
            }
        }
    }

}
