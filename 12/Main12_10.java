import java.util.*;

class Main12_10 {


    public static void main(String[] args) {

        /*
            2020 īī�� ���� ��ä (Level : 3)
            ����ִ� �ڹ���� ���� �� ĭ�� ũ�Ⱑ 1x1�� NxM ũ���� ���簢 ���� �����̰� 
            Ư���� ����� ����� MxM ũ���� ���簢 ���� ���·� �Ǿ��ִ�.
        */

        System.out.println(solution(new int[][]{{0,0,0},{1,0,0},{0,1,1}}, new int[][]{{1,1,1},{1,1,0},{1,0,1}}));

    }

    public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;

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
        /*
            [0, 0, 0]
            [1, 0, 0]
            [0, 1, 1]
        */
        


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

    public static int[][] moveKey(int[][] key) {
        int[][] move_key = new int[key.length][key[0].length];

        return move_key;
    }

    public static void checkKey(int[][] key, int[][] lock) {
        for(int i=0; i<key.length; i++) {
            for(int j=0; j<key[0].length; j++) {
                if (key[i][j] == 0 && lock[i][j] == 1) {
                    continue;
                } else if (key[i][j] == 1 && lock[i][j] == 0) {
                    continue;
                }
                else {
                    
                }
            }
        }
    }
    
}
