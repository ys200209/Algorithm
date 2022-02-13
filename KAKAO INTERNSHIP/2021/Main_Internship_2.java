import java.util.*;

public class Main_Internship_2 {
    static int N, M;
    static String[][] room;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
        {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}})));
        // [1, 0, 1, 1, 1]

    }

    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        N = places.length;
        M = places[0].length;

        room = new String[N][M];

        for(int k=0; k<places.length; k++) {
            room = new String[N][M];
            

            for(int i=0; i<N; i++) {
                room[i] = places[k][i].split("");
            }

            if (checkRoom()) answer[k] = 1;
            else answer[k] = 0;
        }

        return answer;
    }

    public static boolean checkRoom() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if (room[i][j].equals("P")) {
                    visited = new boolean[N][M];
                    if (!BFS(i, j)) return false;
                }
            }
        } 

        return true;
    }

    public static boolean BFS(int i, int j) {
        Queue<Ps> queue = new LinkedList<>();
        queue.offer(new Ps(i, j));

        while(!queue.isEmpty()) {
            Ps ps = queue.poll();

            int x = ps.getX();
            int y = ps.getY(); 
            visited[x][y] = true;

            for(int k=0; k<4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;

                if (Math.abs(i - nx) + Math.abs(j - ny) <= 2 && room[nx][ny].equals("P")) return false;

                if (Math.abs(i - nx) + Math.abs(j - ny) > 2 || room[nx][ny].equals("X")) continue;

                queue.offer(new Ps(nx, ny));
            }

        }

        return true;
    }

}

class Ps {

    private int x;
    private int y;

    public Ps(int x, int y) {
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