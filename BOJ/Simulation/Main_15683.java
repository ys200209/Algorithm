import java.util.*;
import java.io.*;

public class Main_15683 {
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int N, M;
    static int[][] board;
    static ArrayList<CCTV> list = new ArrayList<>();
    static int result = (int)1e9;
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int j=0;
            while(st.hasMoreTokens()) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if (board[i][j] != 0 && board[i][j] != 6) {
                    list.add(new CCTV(i, j, board[i][j], 1));
                }

                j++;
            }
        }

        DFS(0, 0);

        System.out.println(result);
    }

    public static void DFS(int index, int count) {
        if (count == list.size()) {
            
            visited = new boolean[N][M];

            for(int i=0; i<list.size(); i++) {
                CCTV cctv = list.get(i);

                if (cctv.number == 1) {
                    observe(cctv, cctv.vector);
                } else if (cctv.number == 2) {
                    observe(cctv, cctv.vector);
                    observe(cctv, (cctv.vector+2)%4);
                } else {
                    for(int j=0; j<cctv.number-1; j++) {
                        observe(cctv, (cctv.vector+j)%4);
                    }
                }
            }

            result = Math.min(result, safe());
            return;
        }

        for(int i=index; i<list.size(); i++) {
            CCTV cctv = list.get(i);
            int loop = 4;

            if (cctv.number == 2) {
                loop = 2;
            } else if (cctv.number == 5) {
                loop = 1;
            }

            for(int j=0; j<loop; j++) {
                cctv.vector = j;
                DFS(i+1, count+1);
            }
        }

    }

    public static void observe(CCTV cctv, int vector) {
        int nx = cctv.x;
        int ny = cctv.y;
        visited[nx][ny] = true;

        while(true) {
            nx += dx[vector];
            ny += dy[vector];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) break;

            if (board[nx][ny] == 6) break;

            visited[nx][ny] = true;
        }
    }

    public static int safe() {
        int count = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if (board[i][j] != 6 && !visited[i][j]) count++;
            }
        }

        return count;
    }

}

class CCTV {

    int x;
    int y;
    int number;
    int vector;

    public CCTV(int x, int y, int number, int vector) {
        this.x = x;
        this.y = y;
        this.number = number;
        this.vector = vector;
    }

}