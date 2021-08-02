import java.util.*;

class Main12_10 {
    static int UP = 0;
    static int DOWN = 0;
    static int LEFT = 0;
    static int RIGHT = 0;

    public static void main(String[] args) {

        /*
            2020 īī�� ���� ��ä (Level : 3)
            ����ִ� �ڹ���� ���� �� ĭ�� ũ�Ⱑ 1x1�� NxM ũ���� ���簢 ���� �����̰� 
            Ư���� ����� ����� MxM ũ���� ���簢 ���� ���·� �Ǿ��ִ�.
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
        // ���� ��ǥ �⺻�� (4, 4)
        answer = checkKey(key, newLock, new int[]{width, width}); // �� �������� ��� �κ��� Ž���� ��, ȸ������ �ٽ� Ž�� �ݺ�.






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

        System.out.println("---------"); // ȸ�� �� key��.
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

    public static boolean checkKey(int[][] key, int[][] newLock, int[] G) { // key�� �ڹ���, ���� ��ǥ G. (x, y) 
        // ���� ��ǥ G : (key.length, key.length) : (3, 3)


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
        if ( (RIGHT > 0 && position[1][0] == -1) || lock.length/3 - 1 == RIGHT ) return false; // �������ϰų� ��Ż�ϸ� �ߴ�.

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
