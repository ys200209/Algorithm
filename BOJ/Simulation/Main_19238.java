import java.util.*;
import java.io.*;

public class Main_19238 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M, E;
    static int[][] board;
    static Taxi taxi;
    static ArrayList<Passenger> passes = new ArrayList<>();
    static Queue<Taxi> pq = new PriorityQueue<>();
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {

        init();

        drive();

        if (passes.isEmpty()) System.out.println(E);
        else System.out.println("-1");

    }

    public static void drive() {
        while(true) {
            Passenger passenger = startSearch();

            if (passenger == null) return;
    
            if (!endSearch(passenger)) return; // 승객을 제대로 데려다주지 못했다면
        }
    }

    public static Passenger startSearch() {
        Passenger passenger = null;
        int distance = (int)1e9;

        for(int i=0; i<passes.size(); i++) {
            // 현재 택시 위치와 같으면 0 아니면 BFS()
            int dis = BFS(passes.get(i), true);

            if (dis == (int)1e9) return null;

            if (passenger == null) {
                passenger = passes.get(i);
                distance = dis;
            } else {
                if (distance > dis) {
                    passenger = passes.get(i);
                    distance = dis;
                } else if (distance == dis) {
                    if (passenger.start_x > passes.get(i).start_x) {
                        passenger = passes.get(i);
                        distance = dis;
                    } else if (passenger.start_x == passes.get(i).start_x) {
                        if (passenger.start_y > passes.get(i).start_y) {
                            passenger = passes.get(i);
                            distance = dis;
                        }
                    }
                }
            }
        }

        if (distance != (int)1e9) E -= distance;
        return passenger;
    }

    public static boolean endSearch(Passenger passenger) {
        taxi.x = passenger.start_x;
        taxi.y = passenger.start_y;
        taxi.move = 0;

        int dis = BFS(passenger, false);

        if (E - dis < 0) return false;

        E += dis;
        taxi.x = passenger.end_x;
        taxi.y = passenger.end_y;
        taxi.move = 0;
        passes.remove(passenger);

        return true;
    }

    public static int BFS(Passenger passenger, boolean isStart) {
        pq.clear();
        pq.offer(taxi);
        visited = new boolean[N+1][N+1];
        visited[taxi.x][taxi.y] = true;

        while(!pq.isEmpty()) {
            Taxi tx = pq.poll();
            int x = tx.x;
            int y = tx.y;

            if (isStart) {
                if (x == passenger.start_x && y == passenger.start_y) return tx.move;
            }

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 1 || nx > N || ny < 1 || ny > N) continue;

                if (visited[nx][ny]) continue;

                if (board[nx][ny] == 1) continue;

                if (isStart) {
                    if (nx == passenger.start_x && ny == passenger.start_y) return tx.move+1;
                } else {
                    if (nx == passenger.end_x && ny == passenger.end_y) return tx.move+1;
                }

                visited[nx][ny] = true;
                pq.offer(new Taxi(nx, ny, tx.move+1));
                
            }
        }

        return (int)1e9;
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        board = new int[N+1][N+1];
        
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j=1;
            while(st.hasMoreTokens()) {
                board[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        taxi = new Taxi(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            passes.add(new Passenger(
                Integer.parseInt(st.nextToken()), 
                Integer.parseInt(st.nextToken()), 
                Integer.parseInt(st.nextToken()), 
                Integer.parseInt(st.nextToken())));
        }
    }
}

class Taxi implements Comparable<Taxi> {
    
    int x;
    int y;
    int move;

    public Taxi(int x, int y, int move) {
        this.x = x;
        this.y = y;
        this.move = move;
    }

    @Override
    public int compareTo(Taxi taxi) {
        return this.move - taxi.move;
    }

}

class Passenger {

    int start_x;
    int start_y;
    int end_x;
    int end_y;

    public Passenger(int start_x, int start_y, int end_x, int end_y) {
        this.start_x = start_x;
        this.start_y = start_y;
        this.end_x = end_x;
        this.end_y = end_y;
    }
    
}