package BOJ.Implementation;

import java.io.*;
import java.util.*;

public class Main2_2573 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N, M, result=0;
    static Ice[][] board;
    static List<Ice> iceList = new ArrayList<>();
    static Queue<Ice> removeQueue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new Ice[N][M];

        for(int i=0; i<N ;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j=0;
            while(st.hasMoreTokens()) {
                int height = Integer.parseInt(st.nextToken());
                board[i][j] = height == 0 ? null : new Ice(i, j, height);
                if (board[i][j] != null) iceList.add(board[i][j]);
                j++;
            }
        }

        while (nextYear() < 2) {
            remove();

            if (iceList.isEmpty()) {
                System.out.println("0");
                return;
            }

            result++;
        }
        System.out.println(result);
        return;
    }

    private static void remove() {
        for(Ice ice : iceList) {
            if (ice.amount <= 0) {
                removeQueue.offer(ice);
            }
        }

        while(!removeQueue.isEmpty()) {
            Ice poll = removeQueue.poll();
            board[poll.x][poll.y] = null;
            iceList.remove(poll);
        }
    }

    private static int nextYear() {
        boolean[][] visited = new boolean[N][M];
        Queue<Ice> queue = new LinkedList<>();

        int count=0; // 빙하 덩어리 갯수.
        for(Ice ice : iceList) {

            if (!visited[ice.x][ice.y]) {
                count++;
                queue.offer(ice);

                while(!queue.isEmpty()) {
                    Ice pollIce = queue.poll();
                    int x = pollIce.x;
                    int y = pollIce.y;
                    visited[x][y] = true;
                    int fuseCount = 0; // 빙하를 녹일 횟수.

                    for(int i=0; i<4; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];

                        if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                        if (board[nx][ny] == null) {
                            fuseCount++;
                            continue;
                        }

                        if (visited[nx][ny]) continue;

                        visited[nx][ny] = true;

                        queue.offer(board[nx][ny]);
                    }
                    pollIce.amount -= fuseCount;
                }
            }
        }
        return count;
    }

}

class Ice {

    int x;
    int y;
    int amount;

    public Ice(int x, int y, int amount) {
        this.x = x;
        this.y = y;
        this.amount = amount;
    }

}