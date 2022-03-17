import java.util.*;
import java.io.*;

public class Main11_17142 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N, M, zeroCount=0, result=(int)1e9;
    static int[][] board;
    static ArrayList<Virus> virusList = new ArrayList<>(); // 모든 바이러스의 위치를 담은 리스트
    static ArrayList<Virus> virusSelect = new ArrayList<>(); // 선택한 최대 M개의 바이러스 객체가 담긴 리스트
    static Queue<Virus> virusQueue;
    
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

        for(int i=0; i<N; i++) {
            System.out.println(Arrays.toString(board[i]));
        }

        System.out.println("zeroCount : " + zeroCount);
        DFS(0, 0);

        System.out.println("result : " + result);
    }

    public static void DFS(int index, int count) {
        if (count == M) {
            // 바이러스 확산
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
        boolean[][] visited = new boolean[N][N];
        virusQueue = new LinkedList<>();
        for(Virus virus : virusSelect) {
            virusQueue.offer(virus);
            visited[virus.x][virus.y] = true;
        }

        int zero=0;
        int second=0;

        while(!virusQueue.isEmpty()) {
            Virus virus = virusQueue.poll();
            int x = virus.x;
            int y = virus.y;

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                if (visited[nx][ny]) continue;

                if (board[nx][ny] == 0) {
                    virusQueue.offer(new Virus(nx, ny, virus.count+1));
                    visited[nx][ny] = true;
                    second = virus.count+1;
                    zero++;
                }

                
            }
        }

        if (zero != zeroCount && result == (int)1e9) result = -1;
        else result = Math.min(result, second);

    }

}

class Virus/* implements Comparable<Virus> */{

    int x;
    int y;
    int count;

    public Virus(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
/*
    @Override
    public int compareTo(Virus v1) {
        return this.count - v1.count;
    }
*/
}