import java.util.*;
import java.io.*;

public class Main11_14939 {
    static int result1=0, result2=0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] board, temp;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new boolean[10][10];
        temp = new boolean[10][10];

        String[] str;
        
        for(int i=0; i<10; i++) {
            str = br.readLine().split("");
            for(int j=0; j<10; j++) {
                temp[i][j] = board[i][j] = str[j].equals("O") ? true : false;
            }
            
        }
        
        System.out.println("------------[temp]------------");
        for(int i=0; i<10; i++) {
            System.out.println(Arrays.toString(temp[i]));
        }

        // 1. ON -> OFF 로 바꾸기 (board)
        // 2. OFF -> ON -> OFF 로 바꾸기 (temp)
        if (checkArray(board)) {
            if (board[0][0]) System.out.println("0");
            else System.out.println("1");
            return;
        }

        for(int i=0; i<10; i++) {
            for(int j=0; j<10; j++) {
                if (board[i][j]) {
                    DFS(board, i, j, true);
                    result1++;
                    if (checkArray(board)) {
                        System.out.println("1");
                        System.out.println(result1);
                        return;
                    }
                }
                
                if (!temp[i][j]) {
                    DFS(temp, i, j, false);
                    result2++;

                    boolean[][] t = new boolean[10][10];
                    System.out.println("----------------[temp]---------------");
                    for(int p=0; p<10; p++) {
                        for(int q=0; q<10; q++) {
                            t[p][q] = temp[p][q];
                        }
                        System.out.println(Arrays.toString(temp[p]));
                    }
                    DFS(t, i, j, true);
                    System.out.println("----------------[t]---------------");
                    for(int k=0; k<10; k++) {
                        System.out.println(Arrays.toString(t[k]));
                    }
                    result2++;
                    if (checkArray(t)) {
                        System.out.println("2");
                        System.out.println(result2);
                        return;
                    }
                    result2--;
                }
            }
        }

        System.out.println("result1 : " + result1 + ", result2 : " + result2);

    }

    public static void DFS(boolean[][] arr, int x, int y, boolean state) {
        arr[x][y] = !state;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= 10 || ny < 0 || ny >= 10) continue;
            
            if (arr[nx][ny] == !state) continue;

            DFS(arr, nx, ny, state);

        }
    }

    public static boolean checkArray(boolean[][] arr) {
        for(int i=0; i<10; i++) {
            for(int j=0; j<10; j++) {
                if (arr[i][j]) return false;
            }
        }
        return true;
    }

}
