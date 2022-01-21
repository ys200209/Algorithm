import java.io.*;
import java.util.*;

public class Main23_10 {
    static int T, I;
    static int[][] map;
    static Queue<Knight> queue = new LinkedList<>();
    static Knight finish;
    static StringBuilder sb = new StringBuilder();
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            I = Integer.parseInt(br.readLine());
            map = new int[I][I];
            visited = new boolean[I][I];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            Knight now = new Knight(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
            queue.offer(now);

            st = new StringTokenizer(br.readLine(), " ");
            finish = new Knight(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), (int)1e9);

            if (now.getX() == finish.getX() && now.getY() == finish.getY()) {
                sb.append("0\n");
                continue;
            }

            sb.append(BFS() + "\n");
        }

        System.out.println(sb);
    }

    public static int BFS() {
        int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
        int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
        
        while(!queue.isEmpty()) {
            Knight knight = queue.poll();

            int x = knight.getX();
            int y = knight.getY();
            
            for(int i=0; i<8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= I || ny < 0 || ny >= I) continue;

                if (visited[nx][ny]) continue;

                map[nx][ny] = knight.getMoveCount()+1;
                queue.offer(new Knight(nx, ny, map[nx][ny]));
                visited[nx][ny] = true;
            }
        }
        return map[finish.getX()][finish.getY()];
    }
    
}

class Knight {

    private int x;
    private int y;
    private int moveCount;

    public Knight(int x, int y, int moveCount) {
        this.x = x;
        this.y = y;
        this.moveCount = moveCount;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getMoveCount() {
        return moveCount;
    }

}