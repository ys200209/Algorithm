package BOJ.Back_Tracking;

import java.io.*;
import java.util.*;

public class Main14_16946 {
    static int[] dx = {-1, 0, 1, 0}; // 상, 좌, 하, 우
    static int[] dy = {0, -1, 0, 1};
    static int N, M;
    static Place[][] board;
    static List<Wall> wallList = new ArrayList<>();
    static int[][] result;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new Place[N][M];
        result = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            String[] split = br.readLine().split("");
            for(int j=0; j<split.length; j++) {
                int number = Integer.parseInt(split[j]);
                if (number == 0) {
                    board[i][j] = null;
                    result[i][j] = 0;
                } else {
                    board[i][j] = new Place(0);
                    visited[i][j] = true;
                    wallList.add(new Wall(i, j));
                }
            }
        }

        // 빈 공간 계산
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if (!visited[i][j] && board[i][j] == null) {
                    Place place = new Place(0);
                    int count = DFS(i, j, place);
                    place.count = count + 1;
//                    System.out.println("(" + i + ", " + j + ") : " + place.count);
                }
            }
        }

        // 결과
        for(int i=0; i< wallList.size(); i++) {
            int sum = 0;
            Set<Place> set = new HashSet<>();
            Wall wall = wallList.get(i);
            int x = wall.x;
            int y = wall.y;
            for(int j=0; j<4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if (set.add(board[nx][ny])) {
                    sum += board[nx][ny].count;
                }
            }
            result[x][y] = (sum+1)%10;
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                sb.append(result[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int DFS(int row, int column, Place place) {
        visited[row][column] = true;
        board[row][column] = place;
        int count = 0;

        for(int i=0; i<4; i++) {
            int nx = row + dx[i];
            int ny = column + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

            if (visited[nx][ny]) continue;

            if (board[nx][ny] != null) continue;

            count += 1;
            count += (DFS(nx, ny, place) % 10);
        }

        return count % 10;
    }

    static class Wall {
        int x;
        int y;

        public Wall(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Place {
        // Place 클래스를 만든 이유는 (x1, y1)의 좌표와 (x2, y2)의 좌표가 하나의 공간으로 뚫려있을 때,
        // 벽을 기준으로 공간을 더하는 방식의 로직 상, 두 좌표 공간이 동일하다는 것을 나타내야 했다.
        // 따라서 하나의 객체를 여러 다른 공간에 똑같이 넣어서, 최종적으로 공간을 더하다가 만약 같은 객체가 나오면 이들은 하나의 공간으로 생각해서 계산하지 않게 하려고.
        int count; // 이동할 수 있는 칸의 갯수

        public Place(int count) {
            this.count = count;
        }
    }

}