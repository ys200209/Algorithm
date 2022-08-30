import java.util.*;
import java.io.*;

public class Main11_17142 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N, M, zeroCount=0, result=(int)1e9;
    static int[][] board;
    static ArrayList<Virus> virusList = new ArrayList<>();
    static ArrayList<Virus> virusSelect = new ArrayList<>();
    static boolean[][] visited;
    static Queue<Virus> pq = new PriorityQueue<>();
    
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
                if (board[i][j] == 2) virusList.add(new Virus(i, j, 0));
                if (board[i][j] == 0) zeroCount++;
                j++;
            }
        }

        DFS(0, 0);

        if (result == (int)1e9) System.out.println("-1");
        else System.out.println(result);
    }

    public static void DFS(int index, int count) {
        if (count == M) {
            visited = new boolean[N][N];
            for(Virus v : virusSelect) {
                visited[v.x][v.y] = true;
                pq.offer(v);
            }

            BFS();

            return;
        }

        for(int i=index; i<virusList.size(); i++) {
            virusSelect.add(virusList.get(i));
            DFS(i+1, count+1);
            virusSelect.remove(virusSelect.size()-1);
        }
    }

    public static void BFS() {
        int time = 0;
        int zero = 0;

        while(!pq.isEmpty()) {
            Virus virus = pq.poll();
            int x = virus.x;
            int y = virus.y;

            time = virus.count;

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                if (visited[nx][ny]) continue;

                if (board[nx][ny] == 1) continue;

                visited[nx][ny] = true;
                if (board[nx][ny] == 2) continue;

                pq.offer(new Virus(nx, ny, virus.count+1));
                zero++;
            }
        }
        if (zeroCount == zero) result = Math.min(result, time);
    }

    static class Virus implements Comparable<Virus> {

        int x;
        int y;
        int count=0;

        public Virus(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public int compareTo(Virus v1) {
            return this.count - v1.count;
        }

    }

}

