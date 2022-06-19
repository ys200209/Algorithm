import java.util.*;
import java.io.*;

public class Main_2636 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static Queue<Cell> queue = new LinkedList<>();
    static int resultHour=-1, resultCount=0;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j=0;
            while(st.hasMoreTokens()) {
                board[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

        solution();

        System.out.println(resultHour + "\n" + resultCount);
    }

    public static void solution() {
        boolean isFuse = true;
        while(isFuse) {
            isFuse = false;
            visited = new boolean[N][M];
            
            BFS(0, 0);
            isFuse = fuse();

            resultHour++;
        }
    }

    public static void BFS(int row, int column) {
        visited[row][column] = true;
        queue.offer(new Cell(row, column));

        while(!queue.isEmpty()) {
            Cell cell = queue.poll();
            int x = cell.x;
            int y = cell.y;

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if (visited[nx][ny]) continue;

                visited[nx][ny] = true;

                if (board[nx][ny] == 1) continue;
                else queue.offer(new Cell(nx, ny));
                
            }
        }
    }

    public static boolean fuse() {
        boolean isFuse = false;
        int count=0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if (board[i][j] == 1 && visited[i][j]) {
                    isFuse = true;
                    board[i][j] = 0;
                    count++;
                }
            }
        }
        
        resultCount = count == 0 ? resultCount : count;

        return isFuse;
    }
}

class Cell {

    int x;
    int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

}