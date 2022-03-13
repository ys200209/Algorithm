import java.util.*;
import java.io.*;

public class Main23_17141 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N, M, result = (int)1e9;
    static int[][] board;
    static ArrayList<Virus> virusList = new ArrayList<>();
    static boolean[] visited;
    static Queue<Virus> virusQueue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j=0;
            while(st.hasMoreTokens()) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 2) {
                    virusList.add(new Virus(i, j, 0));
                    board[i][j] = 0;
                }
                j++;
            }
        }
        visited = new boolean[virusList.size()];

        DFS(0, 0);

        if (result == (int)1e9) System.out.println("-1");
        else System.out.println(result);

    }

    public static void DFS(int start, int count) {
        if (count == M) {
            int[][] temp = new int[N][N];
            virusQueue.clear();

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    temp[i][j] = board[i][j];
                    if (temp[i][j] == 2) {
                        virusQueue.offer(new Virus(i, j, 0));
                    }
                }
            }
            BFS(temp);
            return;
        }

        for(int i=start; i<virusList.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                board[virusList.get(i).x][virusList.get(i).y] = 2;
                DFS(i+1, count+1);
                board[virusList.get(i).x][virusList.get(i).y] = 0;
                visited[i] = false;
            }
        }

    }

    public static void BFS(int[][] t) {
        int virusTime = 0;

        while(!virusQueue.isEmpty()) {
            Virus virus = virusQueue.poll();
            int x = virus.x;
            int y = virus.y;

            virusTime = Math.max(virusTime, virus.time);

            if (result <= virusTime) return;

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                if (t[nx][ny] != 0) continue;

                t[nx][ny] = virus.time+1;

                virusQueue.offer(new Virus(nx, ny, virus.time+1));
            }
        }

        if (checkVirus(t)) {
            result = Math.min(result, virusTime);
        }

    }

    public static boolean checkVirus(int[][] t) {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if (t[i][j] == 0) return false;
            }
        }

        return true;
    }

}

class Virus {

    int x;
    int y;
    int time;

    public Virus(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }

}