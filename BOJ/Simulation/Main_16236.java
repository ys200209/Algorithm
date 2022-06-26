import java.util.*;
import java.io.*;

public class Main_16236 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N, result = 0;
    static int[][] board;
    static Shark shark;
    static ArrayList<Fish> fishes = new ArrayList<>();
    static Queue<Shark> pq;
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j=0;

            while(st.hasMoreTokens()) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if (board[i][j] == 9) {
                    shark = new Shark(i, j, 2, 0, 0);
                    board[i][j] = 0;
                } else if (board[i][j] != 0) {
                    fishes.add(new Fish(i, j, board[i][j], (int)1e9));
                }

                j++;
            }
        }

        Collections.sort(fishes, (f1, f2) -> {
            return f1.size - f2.size;
        });

        search();
        

        System.out.println(result);

    }

    public static void search() {
        
        while(true) {
            Fish fish = null;

            for(int i=0; i<fishes.size(); i++) {
                if (fishes.get(i).size < shark.size) {
                    visited = new boolean[N][N];
                    pq = new PriorityQueue<>();

                    BFS(fishes.get(i));

                    if (fish == null) fish = fishes.get(i);
                    else {
                        if (fish.distance >= fishes.get(i).distance) {
                            if (fish.distance == fishes.get(i).distance) {
                                if (fish.x >= fishes.get(i).x) {
                                    if (fish.x == fishes.get(i).x) {
                                        if (fish.y > fishes.get(i).y) fish = fishes.get(i);
                                    } else fish = fishes.get(i);
                                }
                            } else fish = fishes.get(i);
                        }
                    }
                } else break;
            }

            if (fish != null) eat(fish);
            else return;
        }

    }

    public static void BFS(Fish fish) {
        pq.offer(shark);
        visited[shark.x][shark.y] = true;

        while(!pq.isEmpty()) {
            Shark shark = pq.poll();
            int x = shark.x;
            int y = shark.y;
            
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue; // 맵을 벗어난 영역이라면 중단

                if (visited[nx][ny]) continue; // 이미 지나갔던 곳이라면 중단

                if (board[nx][ny] > shark.size) continue; // 더 큰 물고기가 가로막고 있다면 중단

                if (nx == fish.x && ny == fish.y) { // 물고기를 만났다면 중지
                    fish.distance = shark.distance + 1;
                    return;
                }

                visited[nx][ny] = true;
                pq.offer(new Shark(nx, ny, shark.size, shark.eat, shark.distance+1));

            }
        }
    }

    public static void eat(Fish fish) {
        shark.x = fish.x;
        shark.y = fish.y;
        shark.eat++;
        if (shark.eat == shark.size) {
            shark.eat = 0;   
            shark.size++;
        }
        shark.distance = 0;

        result += fish.distance;
        board[fish.x][fish.y] = 0;

        fishes.remove(fish);
    }

}

class Shark implements Comparable<Shark> {

    int x;
    int y;
    int size;
    int eat;
    int distance;

    public Shark(int x, int y, int size, int eat, int distance) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.eat = eat;
        this.distance = distance;
    }

    @Override
    public int compareTo(Shark shark) {
        return this.distance - shark.distance;
    }

}

class Fish {

    int x;
    int y;
    int size;
    int distance;

    public Fish(int x, int y, int size, int distance) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.distance = distance;
    }
    
}