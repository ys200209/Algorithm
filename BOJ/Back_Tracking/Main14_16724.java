import java.util.*;
import java.io.*;

public class Main14_16724 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M, count=0;
    static String[][] board;
    static boolean[][] visited;
    static Map<String, Integer> map = new HashMap<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new String[N][M];
        visited = new boolean[N][M];
        
        map.put("U", 0);
        map.put("D", 1);
        map.put("L", 2);
        map.put("R", 3);

        for(int i=0; i<N; i++) {
            board[i] = br.readLine().split("");
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if (!visited[i][j]) {
                    DFS(i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    
    public static void DFS(int x, int y) {

        if (visited[x][y]) return;

        visited[x][y] = true;
        
        String c = board[x][y];
        DFS(x + dx[map.get(c)], y + dy[map.get(c)]); // 정상적인 방향

        // 반대 반향
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

            if (visited[nx][ny]) continue;

            String nc = board[nx][ny];
            if (x == (nx + dx[map.get(nc)]) && y == (ny + dy[map.get(nc)])) {
                DFS(nx, ny);
            }

        }
    }

}