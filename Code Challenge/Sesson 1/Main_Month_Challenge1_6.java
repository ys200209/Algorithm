import java.util.*;

class Main_Month_Challenge1_6 {
    static int zero=0, one=0;
    
    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(new int[][]{{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}})));
        // [4,9]

    }

    public static int[] solution(int[][] arr) {
        int[] answer = new int[2];

        Divide(arr, 0, 0, arr.length);
        
        answer[0] = zero;
        answer[1] = one;

        return answer;
    }

    public static void Divide(int[][] arr, int row, int column, int size) {
        if (checkArr(arr, row, column, size)) {
            if (arr[row][column] == 0) zero++;
            else one++;
            return;
        }

        size /= 2;

        Divide(arr, row, column, size);
        Divide(arr, row+size, column, size);
        Divide(arr, row, column+size, size);
        Divide(arr, row+size, column+size, size);
    }

    public static boolean checkArr(int[][] arr, int row, int column, int size) {
        int check = arr[row][column];

        for(int i=row; i<row+size; i++) {
            for(int j=column; j<column+size; j++) {
                if (check != arr[i][j]) return false;
            }
        }

        return true;
    }

}