import java.util.*;
import java.io.*;

public class Main14_1175 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N, M, result=(int)1e9;
    static String[][] board;
    static Integer[][][] minBoard;
    static Queue<Minsic> pq = new PriorityQueue<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new String[N][M];
        minBoard = new Integer[2][N][M];

        for(int i=0; i<N; i++) {
            board[i] = br.readLine().split("");

            for(int j=0; j<M; j++) {
                if (board[i][j].equals("S")) {
                    pq.offer(new Minsic(i, j, -1, 0, 0));
                    minBoard[0][i][j] = 0;
                }
            }
        }
        BFS();
        System.out.println(result == (int)1e9 ? -1 : result);

        /*for(int i=0; i<2; i++) {
            for(int j=0; j<N; j++) {
                System.out.println(Arrays.toString(minBoard[i][j]));
            }
            System.out.println("-------------------");
        }*/
    }

    public static void BFS() {
        
        while(!pq.isEmpty()) {
            Minsic m = pq.poll();
            int x = m.x;
            int y = m.y;

            if (m.count == 2) {
                result = Math.min(result, m.time);
                return;
            }

            for(int i=0; i<4; i++) {
                if (m.before == i) continue;

                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if (board[nx][ny].equals("#")) continue;

                moveMinsic(m, nx, ny, i); // 처음 방문하는 위치라면

                /*if (minBoard[m.count][nx][ny] == null) moveMinsic(m, nx, ny, i); // 처음 방문하는 위치라면
                else { // 이전에 방문 이력이 존재한다면
                    if (minBoard[m.count][nx][ny] >= m.time+1) moveMinsic(m, nx, ny, i); // 더 빨리 방문한 이력만 기록
                }*/
            }
        }
    }

    public static void moveMinsic(Minsic m, int nx, int ny, int vector) {
        if (board[nx][ny].equals("C")) {  
            pq.offer(new Minsic(nx, ny, vector, m.count+1, m.time+1));
            board[nx][ny] = "#";
        } else pq.offer(new Minsic(nx, ny, vector, m.count, m.time+1));


        /*if (board[nx][ny].equals("C")) { // 배달 수행
            if (m.count == 1) { // 마지막 배달을 다 수행했다면 결과 반환
                result = Math.min(result, m.time+1);
                return;
            } else { // 첫 번째 배달이라면 다시 큐에 삽입
                pq.offer(new Minsic(nx, ny, vector, m.count + 1, m.time + 1));
                minBoard[m.count][nx][ny] = m.time+1;
                minBoard[m.count+1][nx][ny] = m.time+1;
            }
        } else {
            pq.offer(new Minsic(nx, ny, vector, m.count, m.time + 1));
            minBoard[m.count][nx][ny] = m.time+1;
        }*/
    }

}

class Minsic implements Comparable<Minsic> {

    int x;
    int y;
    int before;
    int count;
    int time;

    public Minsic(int x, int y, int before, int count, int time) {
        this.x = x;
        this.y = y;
        this.before = before;
        this.count = count;
        this.time = time;
    }

    @Override
    public int compareTo(Minsic m) {
        return this.time - m.time;
        
        /*if (this.count == m.count) {
            return this.time - m.time;
        } else {
            return m.count - this.count;
        }*/
    }

}