import java.util.*;
import java.io.*;

public class Main14_12100 {
    static int N, score=0;
    static int[][] board;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j=0;
            while(st.hasMoreTokens()) {
                board[i][j] = Integer.parseInt(st.nextToken());
                score = Math.max(score, board[i][j]);
                j++;
            }
        }
        
        /*System.out.println("--------------------[Base]--------------------");
        for(int i=0; i<N; i++) {
            System.out.println(Arrays.toString(board[i]));
        }

        System.out.println("--------------------[UP]--------------------");
        int[][] temp = UP(board);
        for(int i=0; i<N; i++) {
            System.out.println(Arrays.toString(temp[i]));
        }

        System.out.println("--------------------[UP]--------------------");
        temp = UP(temp);
        for(int i=0; i<N; i++) {
            System.out.println(Arrays.toString(temp[i]));
        }

        System.out.println("--------------------[UP]--------------------");
        temp = UP(temp);
        for(int i=0; i<N; i++) {
            System.out.println(Arrays.toString(temp[i]));
        }

        System.out.println("--------------------[Base]--------------------");
        for(int i=0; i<N; i++) {
            System.out.println(Arrays.toString(board[i]));
        }*/

        DFS(board, 0);

        System.out.println(score);
    }

    public static void DFS(int[][] t, int count) {
        if (count == 5) return; // 최대값을 찾기 위한 getScore() 이런 메서드를 구현 할순있지만 그냥 바로 계산해서 반복을 줄임
        
        DFS(UP(t), count+1); // 상
        DFS(DOWN(t), count+1); // 하
        DFS(LEFT(t), count+1); // 좌
        DFS(RIGHT(t), count+1); // 우

    }

    public static int[][] UP(int[][] t) {
        int[][] temp = new int[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                temp[i][j] = t[i][j];
            }
        }
        
        for(int i=0; i<N; i++) {
            int bingo=0; // [4, 4, 8, 8] 행이 있다고 가정할 때 [8, 16]이 아니라 [16, 8]로 합쳐지는것을 방지하기 위한 변수.
            for(int j=1; j<N; j++) {
                if (temp[j][i] != 0) {
                    for(int k=j-1; k>=bingo; k--) {
                        if (temp[k][i] == temp[j][i]) {
                            temp[k][i] *= 2;
                            temp[j][i] = 0;
                            bingo++;
                            score = Math.max(score, temp[k][i]);
                            break;
                        } else if (temp[k][i] != 0 && temp[k][i] != temp[j][i]) {
                            int num = temp[j][i];
                            temp[j][i] = 0;
                            temp[k+1][i] = num;
                            break;
                        }
                    }
                    if (temp[bingo][i] == 0) {
                        temp[bingo][i] = temp[j][i];
                        temp[j][i] = 0;
                    }
                }
            }
        }
        return temp;
    }

    public static int[][] DOWN(int[][] t) {
        int[][] temp = new int[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                temp[i][j] = t[i][j];
            }
        }

        for(int i=0; i<N; i++) {
            int bingo=0;
            for(int j=N-2; j>=0; j--) {
                if (temp[j][i] != 0) {
                    for(int k=j+1; k<N-bingo; k++) {
                        if (temp[k][i] == temp[j][i]) {
                            temp[k][i] *= 2;
                            temp[j][i] = 0;
                            bingo++;
                            score = Math.max(score, temp[k][i]);
                            break;
                        } else if (temp[k][i] != 0 && temp[k][i] != temp[j][i]) {
                            int num = temp[j][i];
                            temp[j][i] = 0;
                            temp[k-1][i] = num;
                            break;
                        }
                    }
                    if (temp[N-1-bingo][i] == 0) {
                        temp[N-1-bingo][i] = temp[j][i];
                        temp[j][i] = 0;
                    }
                }
            }
        }
        return temp;
    }

    public static int[][] LEFT(int[][] t) {
        int[][] temp = new int[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                temp[i][j] = t[i][j];
            }
        }

        for(int i=0; i<N; i++) {
            int bingo=0; 
            for(int j=1; j<N; j++) {
                if (temp[i][j] != 0) {
                    for(int k=j-1; k>=bingo; k--) {
                        if (temp[i][k] == temp[i][j]) {
                            temp[i][k] *= 2;
                            temp[i][j] = 0;
                            bingo++;
                            score = Math.max(score, temp[i][k]);
                            break;
                        } else if (temp[i][k] != 0 && temp[i][k] != temp[i][j]) {
                            int num = temp[i][j];
                            temp[i][j] = 0;
                            temp[i][k+1] = num;
                            break;
                        }
                    }
                    if (temp[i][bingo] == 0) {
                        temp[i][bingo] = temp[i][j];
                        temp[i][j] = 0;
                    }
                }
            }
        }
        return temp;
    }

    public static int[][] RIGHT(int[][] t) {
        int[][] temp = new int[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                temp[i][j] = t[i][j];
            }
        }

        for(int i=0; i<N; i++) {
            int bingo=0; 
            for(int j=N-2; j>=0; j--) {
                if (temp[i][j] != 0) {
                    for(int k=j+1; k<N-bingo; k++) {
                        if (temp[i][k] == temp[i][j]) {
                            temp[i][k] *= 2;
                            temp[i][j] = 0;
                            bingo++;
                            score = Math.max(score, temp[i][k]);
                            break;
                        } else if (temp[i][k] != 0 && temp[i][k] != temp[i][j]) {
                            int num = temp[i][j];
                            temp[i][j] = 0;
                            temp[i][k-1] = num;
                            break;
                        }
                    }
                    if (temp[i][N-1-bingo] == 0) {
                        temp[i][N-1-bingo] = temp[i][j];
                        temp[i][j] = 0;
                    }
                }
            }
        }
        return temp;
    }
}