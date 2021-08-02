import java.util.*;

class Main12_10 {
    static int UP = 0;
    static int DOWN = 0;
    static int LEFT = 0;
    static int RIGHT = 0;

    public static void main(String[] args) {

        /*
            2020 카카오 신입 공채 (Level : 3)
            잠겨있는 자물쇠는 격자 한 칸의 크기가 1x1인 NxM 크기의 정사각 격자 형태이고 
            특이한 모양의 열쇠는 MxM 크기인 정사각 격자 형태로 되어있다.
        */

        // System.out.println(solution(new int[][]{{0,0,0},{1,0,0},{0,1,1}}, new int[][]{{1,1,1},{1,1,0},{1,0,1}}));

        System.out.println(solution(new int[][]{{0,0,0,0},{1,0,0,0},{0,1,1,1},{0,0,0,0}}, new int[][]{{1,1,1,1},{1,1,0,0},{1,0,1,1},{1,0,1,1}}));

    }

    public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;

        int width = key.length; // ex) 3
        // int height = key[0].length; // ex) 3

        int[][] newLock = new int[width * 3][width * 3];

        for(int i=width; i<width+width; i++) {
            for(int j=width; j<width+width; j++) {
                newLock[i][j] = lock[i-width][j-width];
            }
        }

        for(int i=0; i<newLock.length; i++) {
            System.out.println(Arrays.toString(newLock[i]));
        }
        // 기준 좌표 기본값 (4, 4)
        answer = checkKey(key, newLock, new int[]{width, width}); // 한 방향으로 모든 부분을 탐색한 뒤, 회전시켜 다시 탐색 반복.






        /*
        System.out.println("  [key]  ");
        for(int i=0; i<key.length; i++) {
            System.out.println(Arrays.toString(key[i]));
        }
        System.out.println("---------");
        System.out.println("  [lock]   ");
        for(int i=0; i<key.length; i++) {
            System.out.println(Arrays.toString(lock[i]));
        }

        key = rotateKey(key);

        System.out.println("---------"); // 회전 후 key값.
        System.out.println("  [key]  ");
        for(int i=0; i<key.length; i++) {
            System.out.println(Arrays.toString(key[i]));
        }
        */
        /*
            [0, 0, 0]
            [1, 0, 0]
            [0, 1, 1]
        */
        // answer = checkKey(key, lock, new int[][]{{0,0},{0,0}});
        System.out.println("answer = " + answer);
        return answer;
    }
    
    public static int[][] rotateKey(int[][] key) {
        int[][] rot_key = new int[key.length][key[0].length];

        for(int i=0; i<rot_key.length; i++) {
            for(int j=0; j<rot_key[0].length; j++) {
                rot_key[j][key.length-i-1] = key[i][j]; // [0][2] -> [2][2], [2][2] -> [2][0], [0][1] -> [1][2], [1][2] -> [2][1]
            }
        }

        return rot_key;
    }

    public static boolean checkKey(int[][] key, int[][] newLock, int[] G) { // key와 자물쇠, 기준 좌표 G. (x, y) 
        // 기준 좌표 G : (key.length, key.length) : (3, 3)


        return false;
    }

/*
    public static int[][] moveKey(int[][] key) {
        int[][] move_key = new int[key.length][key[0].length];

        return move_key;
    }

    public static boolean checkKey(int[][] key, int[][] lock, int[][] position) { 
        if ( (UP < 0 && position[0][1] == 1) || lock.length/3 - 1 == UP ) return false;
        if ( (DOWN > 0 && position[0][0] == -1) || lock.length/3 - 1 == DOWN ) return false;
        if ( (LEFT < 0 && position[1][1] == 1) || lock.length/3 - 1 == LEFT ) return false;
        if ( (RIGHT > 0 && position[1][0] == -1) || lock.length/3 - 1 == RIGHT ) return false; // 역주행하거나 이탈하면 중단.

        UP += position[0][0];
        DOWN += position[0][1];
        LEFT += position[1][0];
        RIGHT += position[1][1];

        

        for(int i=0; i<key.length; i++) {
            for(int j=0; j<key[0].length; j++) {
                
            }
        }

        return true;
    }
*/
}
