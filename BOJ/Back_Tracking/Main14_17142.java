package BOJ.Back_Tracking;

import java.io.*;
import java.util.*;

public class Main14_17142 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N, M, result=(int)1e9;
    static int[][] board;
    static boolean[][] visited;
    static List<Virus> virusList = new ArrayList<>();
    static Queue<Virus> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j=0;
            while(st.hasMoreTokens()) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 2) {
                    virusList.add(new Virus(i, j, 0));
                    board[i][j] = -1;
                }
                j++;
            }
        }

        /*if (checkAllVirus()) {
            System.out.println("0");
            return;
        }*/

        DFS(0, 0, new ArrayList<>());

        System.out.println((result == (int)1e9 ? -1 : result));
    }

    private static void DFS(int index, int count, List<Virus> list) {
        if (count == M) {
            queue.clear();
            visited = new boolean[N][N];
            for (Virus virus : list) {
                visited[virus.x][virus.y] = true;
                queue.offer(virus);
            }

            int maxTime = BFS();
            System.out.println("maxTime = " + maxTime);
            if (checkAllVirus()) {
                result = Math.min(result, maxTime);
            }
            System.out.println("result = " + result);
            print();


            return;
        }

        for(int i=index; i<virusList.size(); i++) {
            Virus virus = virusList.get(i);
            list.add(virus);
            board[virus.x][virus.y] = 0;
            DFS(i+1, count+1, list);
            board[virus.x][virus.y] = -1;
            list.remove(virus);
        }
    }

    private static void print() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean checkAllVirus() {

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if (!visited[i][j] && board[i][j] == 0) return false;
            }
        }

        return true;
    }

    private static int BFS() {
        int maxTime = 0;
        while(!queue.isEmpty()) {
            Virus poll = queue.poll();
            int x = poll.x;
            int y = poll.y;

            maxTime = Math.max(maxTime, poll.time);

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                if (visited[nx][ny] || board[nx][ny] == 1) continue;

                visited[nx][ny] = true;

                if (board[x][y] == -1 && board[nx][ny] != -1) queue.offer(new Virus(nx, ny, poll.time+2));
                else if (board[x][y] == -1 && board[nx][ny] == -1)
                else if (board[x][y] != -1 && board[nx][ny] == -1) queue.offer(new Virus(nx, ny, poll.time));
                else queue.offer(new Virus(nx, ny, poll.time+1));
            }
        }
        return maxTime;
    }

    static class Virus {
        int x;
        int y;
        int time;

        public Virus(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

}