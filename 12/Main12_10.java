import java.util.*;

class Main12_10 {
    static int start_x;
    static int start_y;
    static int end_x;
    static int end_y;

    public static void main(String[] args) {

        /*
            2020 카카오 신입 공채 (Level : 3)
            잠겨있는 자물쇠는 격자 한 칸의 크기가 1x1인 NxM 크기의 정사각 격자 형태이고 
            특이한 모양의 열쇠는 MxM 크기인 정사각 격자 형태로 되어있다.
        */

        System.out.println(solution(new int[][]{{0,0,0},{1,0,0},{0,1,1}}, new int[][]{{1,1,1},{1,1,0},{1,0,1}}));

        // System.out.println(solution(new int[][]{{0,0,0,0},{1,0,0,0},{0,1,1,1},{0,0,0,0}}, new int[][]{{1,1,1,1},{1,1,0,0},{1,0,1,1},{1,0,1,1}}));

    }

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

    // 자물쇠의 중간 부분이 모두 1인지 확인
    public static boolean check(int[][] newLock) {
        int lockLength = newLock.length / 3;
        for (int i = lockLength; i < lockLength * 2; i++) {
            for (int j = lockLength; j < lockLength * 2; j++) {
                if (newLock[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean solution(int[][] key, int[][] lock) {
        int n = lock.length;
        int m = key.length;
        // 자물쇠의 크기를 기존의 3배로 변환
        int[][] newLock = new int[n * 3][n * 3];
        // 새로운 자물쇠의 중앙 부분에 기존의 자물쇠 넣기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newLock[i + n][j + n] = lock[i][j];
            }
        }

        System.out.println("---------- [Lock] ----------");
        for(int i=0; i<newLock.length; i++) {
            System.out.println(Arrays.toString(newLock[i]));
        }

        System.out.println("--------- [Key] ---------");
        for(int i=0; i<newLock.length; i++) {
            System.out.println(Arrays.toString(key[i]));
        }

        // 4가지 방향에 대해서 확인
        for (int rotation = 0; rotation < 4; rotation++) {
            key = rotateMatrixBy90Degree(key); // 열쇠 회전
            for (int x = 0; x < n * 2; x++) {
                for (int y = 0; y < n * 2; y++) {
                    // 자물쇠에 열쇠를 끼워 넣기
                    System.out.println("x = " + x + ", y = " + y);
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.println("key["+i+"]["+j+"] = " + key[i][j]);
                            System.out.println("newLock["+x+"+"+i+"]["+y+"+"+j+"] = " + newLock[x + i][y + j]);
                            newLock[x + i][y + j] += key[i][j];
                            
                        }
                    }
                    // 새로운 자물쇠에 열쇠가 정확히 들어 맞는지 검사

                    for(int i=0; i<newLock.length; i++) {
                        System.out.println(Arrays.toString(newLock[i]));
                    }

                    if (check(newLock)) return true;
                    // 자물쇠에서 열쇠를 다시 빼기
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            newLock[x + i][y + j] -= key[i][j];
                        }
                    }
                    System.out.println("finish");
                }
            }
        }
        return false;
    }
    
}
