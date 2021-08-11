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

    // 2���� ����Ʈ 90�� ȸ���ϱ�
    public static int[][] rotateMatrixBy90Degree(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] result = new int[n][m]; // ��� ����Ʈ
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[j][n - i - 1] = a[i][j]; 
                // a[0][0] = result[0][2];
                // a[2][1] = result[1][0];
            }
        }
        return result;
    }

    // �ڹ����� �߰� �κ��� ��� 1���� Ȯ��
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
        // �ڹ����� ũ�⸦ ������ 3��� ��ȯ
        int[][] newLock = new int[n * 3][n * 3];
        // ���ο� �ڹ����� �߾� �κп� ������ �ڹ��� �ֱ�
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

        // 4���� ���⿡ ���ؼ� Ȯ��
        for (int rotation = 0; rotation < 4; rotation++) {
            key = rotateMatrixBy90Degree(key); // ���� ȸ��
            for (int x = 0; x < n * 2; x++) {
                for (int y = 0; y < n * 2; y++) {
                    // �ڹ��迡 ���踦 ���� �ֱ�
                    System.out.println("x = " + x + ", y = " + y);
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.println("key["+i+"]["+j+"] = " + key[i][j]);
                            System.out.println("newLock["+x+"+"+i+"]["+y+"+"+j+"] = " + newLock[x + i][y + j]);
                            newLock[x + i][y + j] += key[i][j];
                            
                        }
                    }
                    // ���ο� �ڹ��迡 ���谡 ��Ȯ�� ��� �´��� �˻�

                    for(int i=0; i<newLock.length; i++) {
                        System.out.println(Arrays.toString(newLock[i]));
                    }

                    if (check(newLock)) return true;
                    // �ڹ��迡�� ���踦 �ٽ� ����
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
