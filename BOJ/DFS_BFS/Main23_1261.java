import java.util.*;
import java.io.*;

public class Main23_1261 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N, M;
    static String[][] map;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new String[N][M];

        for(int i=0; i<N; i++) {
            map[i] = br.readLine().split("");
        }

        BFS(0, 0);
    }

    public static void BFS(int row, int column) {
        Queue<Cell> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[N][M];
        visited[row][column] = true;
        pq.offer(new Cell(row, column, 0, visited));

        while(!pq.isEmpty()) {
            Cell cell = pq.poll();
            int x = cell.x;
            int y = cell.y;
            boolean[][] v = cell.visited;

            if (x == N-1 && y == M-1) {
                System.out.println(cell.count);
                return;
            }

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if (cell.visited[nx][ny]) continue;

                v[nx][ny] = true;
                if (map[nx][ny].equals("1")) pq.offer(new Cell(nx, ny, cell.count+1, v));
                else pq.offer(new Cell(nx, ny, cell.count, v));
            }

        }
    }

}

class Cell implements Comparable<Cell> {

    int x;
    int y;
    int count;
    boolean[][] visited;

    public Cell(int x, int y, int count, boolean[][] visited) {
        this.x = x;
        this.y = y;
        this.count = count;
        this.visited = visited;
    }

    @Override
    public int compareTo(Cell cell) {
        return this.count - cell.count;
    }

}