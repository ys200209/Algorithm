import java.util.*;

class Main12_10 {


    public static void main(String[] args) {

        /*
            2020 카카오 신입 공채 (Level : 3)
            잠겨있는 자물쇠는 격자 한 칸의 크기가 1x1인 NxM 크기의 정사각 격자 형태이고 
            특이한 모양의 열쇠는 MxM 크기인 정사각 격자 형태로 되어있다.
        */

        System.out.println(solution(new int[][]{{0,0,0},{1,0,0},{0,1,1}}, new int[][]{{1,1,1},{1,1,0},{1,0,1}}));

    }

    public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;

        for(int i=0; i<key.length; i++) {
            System.out.println(Arrays.toString(key[i]));
        }
        System.out.println("---------");
        for(int i=0; i<key.length; i++) {
            System.out.println(Arrays.toString(lock[i]));
        }

        System.out.println("answer = " + answer);
        return answer;
    }

    public static int[][] rotateKey(int[][] key) {
        

        return key;
    }

    public static void turn(int[][] key, int[][] lock) {
        // key[1][0] -> key[0][1] -> key[1][2] -> key[2][1]
        // key[2][1] -> key[1][0] -> key[0][1] -> key[1][2]
        // key[2][2] -> key[2][0] -> key[0][0] -> key[0][2]

    }

    public static void move(int[][] key, int[][] lock) {
        

    }
    
}
