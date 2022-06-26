import java.util.*;

class Main2022_Internship_5 {
    static int r, c;

    public static void main(String[] args) {

        System.out.println(solution(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 
        new String[]{"Rotate", "ShiftRow"}));
        /*
        [[8, 9, 6], 
        [4, 1, 2], 
        [7, 5, 3]]
        */

    }
    
    public static int[][] solution(int[][] rc, String[] operations) {
        r = rc.length;
        c = rc[0].length;

        for(int i=0; i<operations.length; i++) {
            if (operations[i].equals("Rotate")) rc = Rotate(rc);
            else rc = ShiftRow(rc);
        }

        for(int i=0; i<rc.length; i++) {
            System.out.println(Arrays.toString(rc[i]));
        }

        return rc;
    }

    public static int[][] ShiftRow(int[][] rc) {
        int[][] temp = arrayCopy(rc);

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                temp[i][j] = rc[(r+i-1)%r][j];
            }
        }

        return temp;
    }

    public static int[][] Rotate(int[][] rc) {
        int[][] temp = arrayCopy(rc);

        for(int i=1; i<c; i++) {
            temp[0][i] = rc[0][i-1]; // 상
            temp[r-1][c-i-1] = rc[r-1][c-i]; // 하
        }

        for(int i=1; i<r; i++) {
            temp[r-i-1][0] = rc[r-i][0]; // 좌
            temp[i][c-1] = rc[i-1][c-1]; // 우
        }

        return temp;
    }

    public static int[][] arrayCopy(int[][] rc) {
        int[][] temp = new int[r][c];

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                temp[i][j] = rc[i][j]; // 값 복사
            }
        }

        return temp;
    }

}

/*
    Q1 : 
*/ 