import java.util.*;
import java.io.*;

public class Main_16234 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static boolean isUnion = true;
    static Queue<Country> unionQueue = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int j=0;
            while(st.hasMoreTokens()) {
                map[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }
        
        System.out.println(move());

    }

    public static int move() {
        
        int count = 0;
        while(isUnion) {
            isUnion = false;

            visited = new boolean[N][N];

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if (!visited[i][j]) {
                        BFS(i, j);
                    }
                }
            }

            if (!isUnion) break;

            count++;
        }

        return count;
    }

    public static void BFS(int row, int column) {
        visited[row][column] = true;

        Queue<Country> queue = new LinkedList<>();
        queue.offer(new Country(row, column));

        int sum = map[row][column];
        int count = 1;
        unionQueue.offer(new Country(row, column));

        while(!queue.isEmpty()) {
            Country country = queue.poll();
            int x = country.x;
            int y = country.y;

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                if (visited[nx][ny]) continue;

                int diff = Math.abs(map[x][y] - map[nx][ny]);

                if (diff >= L && diff <= R) {
                    isUnion = true;

                    visited[nx][ny] = true;
                    sum += map[nx][ny];
                    count++;
                    queue.offer(new Country(nx, ny));
                    unionQueue.offer(new Country(nx, ny));
                }
            }
        }
        
        while(!unionQueue.isEmpty()) {
            Country country = unionQueue.poll();
            map[country.x][country.y] = sum/count;
        }
    }

}

class Country {

    int x;
    int y;

    public Country(int x, int y) {
        this.x = x;
        this.y = y;
    }

}