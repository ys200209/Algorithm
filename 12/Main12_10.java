import java.util.*;

class Main12_10 {
    static int start_x;
    static int start_y;
    static int end_x;
    static int end_y;

    public static void main(String[] args) {

        /*
            2020 īī�� ���� ��ä (Level : 3)
            ����ִ� �ڹ���� ���� �� ĭ�� ũ�Ⱑ 1x1�� NxM ũ���� ���簢 ���� �����̰� 
            Ư���� ����� ����� MxM ũ���� ���簢 ���� ���·� �Ǿ��ִ�.
        */

        System.out.println(solution(new int[][]{{0,0,0},{1,0,0},{0,1,1}}, new int[][]{{1,1,1},{1,1,0},{1,0,1}}));

        // System.out.println(solution(new int[][]{{0,0,0,0},{1,0,0,0},{0,1,1,1},{0,0,0,0}}, new int[][]{{1,1,1,1},{1,1,0,0},{1,0,1,1},{1,0,1,1}}));

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
        // ���� ��ǥ �⺻�� (3, 3). 0, 1, 2, 3.
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
        if(G[0]==0 || G[0]==newLock.length-key.length || 
                    G[1]==0 || G[1]==newLock.length-key.length) {
            return false;
        }
        // G(2, 2) ����, key ����.
        start_x = G[0] <= key.length ? key.length-G[0] : 0; // 1
        start_y = G[1] <= key.length ? key.length-G[1] : 0; // 1 ... (1, 1)
        end_x = G[0] <= key.length ? key.length : G[0]-key.length; // 3
        end_y = G[1] <= key.length ? key.length : G[1]-key.length; // 3 ... (3, 3)

        for(int i=start_x; i<end_x; i++) { // G(2, 3) || G(4, 3) || G(3, 2) || G(3, 4)
            for(int j=start_y; j<end_y; j++) {
                if(key[i][j] == 1 && newLock[i+G[0]][j+G[1]] == 1) { // �����¿� �� ȸ��
                    checkKey(key, newLock, new int[]{G[0]-1, G[1]});
                    checkKey(key, newLock, new int[]{G[0]+1, G[1]});
                    checkKey(key, newLock, new int[]{G[0], G[1]-1});
                    checkKey(key, newLock, new int[]{G[0], G[1]+1}); 
                    rotateKey(key);
                    break;
                }
            }
        } 
        
        // Ž���� �� ���ƴٸ� ������ �ڹ��� �������� �� ������ �����ϴ��� ã�´�.
        for(int i=key.length; i<key.length*2; i++) {
            for(int j=key.length; j<key.length*2; j++) {
                /* ex) 
                0..1..  2 // key.length + (key.length - G[0] - 1) -> 3 + (3 - 2 - 1)
                0..1..  2 // key.length + (key.length - G[0] - 1) -> 3 + (3 - )
                0   1   2
                */
                if(i < G[0]+key.length && j < G[1]+key.length && newLock[i][j] == 0) { // G(2, 3) || G(4, 3) || G(3, 2) || G(3, 4)
                    return false;
                }
            }
        }


        System.out.println("return true...");
        return true;
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
