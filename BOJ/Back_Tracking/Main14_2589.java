package BOJ.Back_Tracking;

import java.io.*;
import java.util.*;

/*
5 7
WWWWWWW
WWWWWWW
WWLWWWW
WWWWWWW
WWWWWWW

 */
public class Main14_2589 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N, M, maxCount = -1, result=0;
    static String[][] board;
    static boolean[][] visited;
    static Queue<Position> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new String[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            String[] split = br.readLine().split("");
            for(int j=0; j<split.length; j++) {
                board[i][j] = split[j];
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if (!visited[i][j] && board[i][j].equals("L")) {
                    System.out.println(i + ", " + j);
                    visited[i][j] = true;
                    maxCount = -1;
                    Position maxPosition = DFS(i, j, 0);
                    visited[i][j] = false;

//                    System.out.println("maxCount = " + maxCount);
//                    System.out.println("(" + maxPosition.x + ", " + maxPosition.y + ")");

//                    return;

                    int distance = BFS(maxPosition);
//                    test();
                    result = Math.max(result, distance);
                }
            }
        }
        System.out.println(result);
    }

    private static int BFS(Position maxPosition) {
        int distance = 0;
        queue.clear();
        queue.offer(maxPosition);
        visited[maxPosition.x][maxPosition.y] = true;

        while(!queue.isEmpty()) {
            Position poll = queue.poll();
            int x = poll.x;
            int y = poll.y;

            distance = Math.max(distance, poll.count);

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if (visited[nx][ny] || board[nx][ny].equals("W")) continue;

                visited[nx][ny] = true;
                queue.offer(new Position(nx, ny, poll.count+1));
            }
        }
        return distance;
    }

    private static void test() {
        System.out.println();
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                System.out.print(visited[i][j] ? "O" : "X");
            }
            System.out.println();
        }
    }

    private static Position DFS(int x, int y, int count) {
        Position pos = null;

        if (maxCount < count) {
            maxCount = count;
            pos = new Position(x, y, 0);
            System.out.println("new Position");
        }


        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

            if (visited[nx][ny] || board[nx][ny].equals("W")) continue;

            visited[nx][ny] = true;
            Position dfs = DFS(nx, ny, count + 1);
            if (dfs != null) pos = dfs;
            visited[nx][ny] = false;
        }

        return pos;
    }

    static class Position {
        int x;
        int y;
        int count;

        public Position(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

}