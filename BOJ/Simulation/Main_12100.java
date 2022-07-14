import java.util.*;
import java.io.*;

public class Main_12100 {
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};
    static int N, result=0;
    static int[][] board;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j=0;
            while(st.hasMoreTokens()) {
                board[i][j] = Integer.parseInt(st.nextToken());
                result = Math.max(result, board[i][j]);
                j++;
            }
        }

        // DFS(board, 0);

        int[][] temp = UP(board);
        for(int i=0; i<N; i++) {
            System.out.println(Arrays.toString(temp[i]));
        }
        
        System.out.println(result);
        
    }

    public static void DFS(int[][] copyBoard, int count) {
        if (count >= 5) {

            return;
        }

        DFS(UP(copyBoard), count+1);
        DFS(DOWN(copyBoard), count+1);
        DFS(RIGHT(copyBoard), count+1);
        DFS(LEFT(copyBoard), count+1);

    }

    public static int[][] copyArray(int[][] array) {
        int[][] temp = new int[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                temp[i][j] = array[i][j];
            }
        }

        return temp;
    }

    public static int[][] UP(int[][] copyBoard) {
        int[][] temp = copyArray(copyBoard);
        

        for(int i=0; i<N; i++) { // 가로
            int bingo = 0;

            for(int j=0; j<N; j++) { // 세로
                if (temp[j][i] != 0) {
                    int nx = j;

                    while(true) {
                        nx--;

                        if (nx < 0+bingo || nx >= N) break;

                        if (temp[nx][i] == 0) {
                            temp[nx][i] = temp[nx+1][i];
                            temp[nx+1][i] = 0;
                        } else {
                            if (temp[nx][i] == temp[nx+1][i]) {
                                temp[nx+1][i] = 0;
                                temp[nx][i] *= 2;
                                result = Math.max(result, temp[nx][i]);
                                bingo++;
                            } else break;
                        }
                    }

                }
            }
        }

        return temp;
    }

    public static int[][] DOWN(int[][] copyBoard) {
        int[][] temp = copyArray(copyBoard);

        for(int i=0; i<N; i++) { // 가로
            int bingo = 0;

            for(int j=N-1; j>=0; j--) { // 세로
                if (temp[j][i] != 0) {
                    int nx = j;

                    while(true) {
                        nx++;

                        if (nx < 0 || nx >= N-bingo) break;

                        if (temp[nx][i] == 0) {
                            temp[nx][i] = temp[nx-1][i];
                            temp[nx-1][i] = 0;
                        } else {
                            if (temp[nx][i] == temp[nx-1][i]) {
                                temp[nx-1][i] = 0;
                                temp[nx][i] *= 2;
                                result = Math.max(result, temp[nx][i]);
                                bingo++;
                            } else break;
                        }
                    }

                }
            }
        }

        return temp;
    }

    public static int[][] RIGHT(int[][] copyBoard) {
        int[][] temp = copyArray(copyBoard);

        for(int i=0; i<N; i++) { // 세로
            int bingo = 0;

            for(int j=N-1; j>=0; j--) { // 가로
                if (temp[i][j] != 0) {
                    int ny = j;

                    while(true) {
                        ny++;

                        if (ny < 0 || ny >= N-bingo) break;

                        if (temp[i][ny] == 0) {
                            temp[i][ny] = temp[i][ny-1];
                            temp[i][ny-1] = 0;
                        } else {
                            if (temp[i][ny] == temp[i][ny-1]) {
                                temp[i][ny-1] = 0;
                                temp[i][ny] *= 2;
                                result = Math.max(result, temp[i][ny]);
                                bingo++;
                            } else break;
                        }
                    }

                }
            }
        }

        return temp;
    }

    public static int[][] LEFT(int[][] copyBoard) {
        int[][] temp = copyArray(copyBoard);

        for(int i=0; i<N; i++) { // 세로
            int bingo = 0;

            for(int j=0; j<N; j++) { // 가로
                if (temp[i][j] != 0) {
                    int ny = j;

                    while(true) {
                        ny--;

                        if (ny < 0+bingo || ny >= N) break;

                        if (temp[i][ny] == 0) {
                            temp[i][ny] = temp[i][ny+1];
                            temp[i][ny+1] = 0;
                        } else {
                            if (temp[i][ny] == temp[i][ny+1]) {
                                temp[i][ny+1] = 0;
                                temp[i][ny] *= 2;
                                result = Math.max(result, temp[i][ny]);
                                bingo++;
                            } else break;
                        }
                    }

                }
            }
        }

        return temp;
    }

    


}