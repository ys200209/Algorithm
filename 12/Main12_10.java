import java.util.*;

class Main12_10 {
    public static int newSize;
    public static int[][] resultKey, newLock, newKey;
    public static boolean bingo;

    public static void main(String[] args) {

        /*
            2020 카카오 신입 공채 (Level : 3)
            잠겨있는 자물쇠는 격자 한 칸의 크기가 1x1인 NxM 크기의 정사각 격자 형태이고 
            특이한 모양의 열쇠는 MxM 크기인 정사각 격자 형태로 되어있다.
        */

        System.out.println(solution(new int[][]{{0,0,0},{1,0,0},{0,1,1}}, new int[][]{{1,1,1},{1,1,0},{1,0,1}}));

        // System.out.println(solution(new int[][]{{0,0,0,0},{1,0,0,0},{0,1,1,1},{0,0,0,0}}, new int[][]{{1,1,1,1},{1,1,0,0},{1,0,1,1},{1,0,1,1}}));

    }

    public static boolean solution(int[][] key, int[][] lock) {
        newSize = lock.length;
        newLock = new int[newSize * 3][newSize * 3];
        
        resultKey = new int[newSize][newSize];
        
        for(int i=0; i<lock.length; i++) {
            for(int j=0; j<lock.length; j++) {
                newLock[newSize+i][newSize+j] = lock[i][j];
                resultKey[i][j] = key[i][j];
            }
        }

        for(int i=1; i < newSize * 2 + 1; i++) {
            for(int j=1; j < newSize * 2 + 1; j++) {
                if (insertKey(i, j, key, newLock)) return true;
            }
        }

        return false;
    }

    public static int[][] rotateKey90(int[][] key) {
        int[][] rotKey = new int[key.length][key[0].length];

        for(int i=0; i<key.length; i++) {
            for(int j=0; j<key.length; j++) {
                rotKey[j][key.length - i - 1] = key[i][j];
            }
        }

        return rotKey;
    }

    public static boolean insertKey(int x, int y, int[][]key, int[][] lock) {

        for(int k=0; k<4; k++) {
            bingo = true;
            resultKey = rotateKey90(resultKey);
            newKey = new int[newSize * 3][newSize * 3];

            for(int i=0; i<resultKey.length; i++) {
                for(int j=0; j<resultKey.length; j++) {
                    newKey[i+x][j+y] = resultKey[i][j];
                }
            }

            for(int i=key.length; i<key.length * 2; i++) {
                for(int j=key.length; j<key.length * 2; j++) {
                    if (lock[i][j] == 0 && newKey[i][j] == 0) {
                        bingo = false;
                        break;
                    }
                    else if (lock[i][j] == 1 && newKey[i][j] == 1) {
                        bingo = false;
                        break;
                    }
                }
            }
            if (bingo) return true;
        }

        return false;
    }
    
}