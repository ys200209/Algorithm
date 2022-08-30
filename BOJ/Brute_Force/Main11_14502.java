import java.util.*;
import java.io.*;

public class Main11_14502 {
    static int N, M, result=0;
    static int[][] map, temp;
    static Queue<Virus> virusQueue = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j=0;
            while(st.hasMoreTokens()) {
                map[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }
        
        DFS(0);

        System.out.println(result);
    }

    public static void DFS(int wall) {
        if (wall == 3) {
            temp = new int[N][M];
            
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    temp[i][j] = map[i][j];
                    if (temp[i][j] == 2) virusQueue.offer(new Virus(i, j));
                }
            }
            
            spreadVirus();
            
            result = Math.max(result, getScore());

            return;
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    wall += 1;
                    DFS(wall);
                    wall -= 1;
                    map[i][j] = 0;
                }
            }
        }

    }

    public static void spreadVirus() {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while(!virusQueue.isEmpty()) {
            Virus virus = virusQueue.poll();
            int x = virus.getX();
            int y = virus.getY();

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if (temp[nx][ny] == 0) {
                    temp[nx][ny] = 2;
                    virusQueue.offer(new Virus(nx ,ny));
                }

            }
        }
    }

    public static int getScore() {
        int score=0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if (temp[i][j] == 0) score++;
            }
        }

        return score;
    }

    static class Virus {

        private int x;
        private int y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

    }

}

