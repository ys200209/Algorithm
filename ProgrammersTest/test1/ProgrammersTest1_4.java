import java.util.*;

class ProgrammersTest1_4 {
    static int result = (int)1e9;

    public static void main(String[] args) {

        System.out.println(solution(new int[][]{{0, 1, 0, 0, 0}, {1, 0, 1, 0, 1}, {0, 1, 1, 1, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}},
        new int[][]{{0, 0, 0, 1, 1}, {0, 0, 0, 0, 1}, {0, 0, 1, 0, 1}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 1}}));
        // 5

    }
    
    public static int solution(int[][] beginning, int[][] target) {
        
        DFS(beginning, target, 0, 0, 0);

        return result == (int)1e9 ? -1 : result;
    }

    public static void DFS(int[][] beginning, int[][] target, int row, int column, int count) {
        if (checkArr(beginning, target)) {
            result = Math.min(result, count);
            return;
        }

        for(int i=row; i<beginning.length; i++) {
            for(int j=column; j<beginning[0].length; j++) {
                if (beginning[i][j] != target[i][j]) {
                    DFS(setRow(beginning, i), target, i, j, count+1);
                    DFS(setColumn(beginning, j), target, i, j, count+1);
                }
            }
        }

    }

    public static boolean checkArr(int[][] beginning, int[][] target) {
        for(int i=0; i<beginning.length; i++) {
            for(int j=0; j<beginning[0].length; j++) {
                if (beginning[i][j] != target[i][j]) return false;
            }
        }
        return true;
    }

    public static int[][] setRow(int[][] beginning, int row) {
        int[][] temp = new int[beginning.length][beginning[0].length];

        for(int i=0; i<beginning.length; i++) {
            for(int j=0; j<beginning[0].length; j++) {
                if (i == row) temp[i][j] = (beginning[i][j]+1) % 2;
                else temp[i][j] = beginning[i][j];
            }
        }
        return temp;
    }

    public static int[][] setColumn(int[][] beginning, int column) {
        int[][] temp = new int[beginning.length][beginning[0].length];

        for(int i=0; i<beginning.length; i++) {
            for(int j=0; j<beginning[0].length; j++) {
                if (j == column) temp[i][j] = (beginning[i][j]+1) % 2;
                else temp[i][j] = beginning[i][j];
            }
        }
        return temp;
    }
    
}