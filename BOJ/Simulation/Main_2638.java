import java.util.*;
import java.io.*;

public class Main_2638 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static boolean isFuse = true;
    static int result=-1;
    static Queue<Cell> queue = new LinkedList<>();
    static ArrayList<Cell> cheeses;
    
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
                j++;
            }
        }

        solution();

        System.out.println(result);
    }

    public static void solution() {

        while(isFuse) {
            isFuse = false;
            visited = new boolean[N][M];
            cheeses = new ArrayList<>();

            BFS(0, 0);
            fuse();

            /*System.out.println("-------------------------");
            for(int i=0; i<N; i++) {
                System.out.println(Arrays.toString(board[i]));
            }*/

            result++; 
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

                if (board[nx][ny] == 0) {
                    queue.offer(new Cell(nx, ny));
                    visited[nx][ny] = true;
                } else {
                    cheeses.add(new Cell(nx, ny));
                }
            }
        }

    }

    public static void fuse() {
        for(Cell cell : cheeses) {
            int x = cell.x;
            int y = cell.y;
            int count = 0;

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if (visited[nx][ny]) count++;
            }

            if (count >= 2) {
                board[x][y] = 0;
                isFuse = true;
            }
        }
    }

}

class Cell {

    int x;
    int y;
    // boolean isCheese;

    public Cell(int x, int y/*, boolean isCheese*/) {
        this.x = x;
        this.y = y;
        // this.isCheese = isCheese;
    }

}