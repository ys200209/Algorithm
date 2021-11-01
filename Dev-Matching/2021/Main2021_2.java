import java.util.*;

class Main2021_2 {
    public static int[] key, lock;
    
    public static void main(String[] args) {

        // 2021 Dev-Matching: 웹 백엔드 개발자 코딩테스트 2번 문제

        // solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}});
        solution(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}, new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}});

    }

    public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;

        System.out.println("- [key] -");
        for(int i=0; i<key.length; i++) {
            System.out.println(Arrays.toString(key[i]));
        }

        // key = rotateKey(key);
        
        System.out.println("- [rotateKey] -");
        for(int i=0; i<key.length; i++) {
            System.out.println(Arrays.toString(key[i]));
        }

        return answer;
    }










































/*
    public static int[][] rotateKey(int[][] key) {

        int N = key.length;
        int[] k = new int[N];
        int[][] list = new int[N][N];

        for(int i=0; i<N; i++) {
            k = key[i];
            for(int j=0; j<N; j++) { // [1][0] -> [0][1]
                list[j][N - i - 1] = key[i][j];
            }
        }

        return list;
  
    }
*/











    /*
    // 2차원 리스트 90도 회전하기
    public static int[][] rotateMatrixBy90Degree(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] result = new int[n][m]; // 결과 리스트
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[j][n - i - 1] = a[i][j]; 
                // a[0][0] = result[0][2];
                // a[2][1] = result[1][0];
            }
        }
        return result;
    }
    */

}
