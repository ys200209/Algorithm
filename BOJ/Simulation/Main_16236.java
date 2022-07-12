import java.util.*;
import java.io.*;

public class Main_16236 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M, result=0;
    static int[][] board;
    static Queue<Shark> queue = new PriorityQueue<>();
    static ArrayList<Fish> fishes = new ArrayList<>();
    static boolean[][] visited;
    static Shark s;
    
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
                    s = new Shark(i, j, 2, 0, 0);
                    board[i][j] = 0;
                } else if (board[i][j] != 0) fishes.add(new Fish(i, j, board[i][j]));

                j++;
            }
        }

        Collections.sort(fishes, (fish1, fish2) -> {
            return fish1.size - fish2.size;
        });

        while(true) {
            Fish fish = isEat();
            if (fish == null) break;

            s.x = fish.x;
            s.y = fish.y;
            s.eatCount++;

            if (s.eatCount == s.size) {
                s.eatCount = 0;
                s.size++;
            }

            board[fish.x][fish.y] = 0;
            fishes.remove(fish);
        }

        System.out.println(result);

    }

    public static Fish isEat() {
        Fish fish = null;
        int distance = (int)1e9;

        for (Fish f : fishes) {
            if (s.size > f.size) {
                int dis = BFS(f);

                if (fish == null) {
                    if (dis != (int)1e9) {
                        distance = dis;
                        fish = f;
                    }
                } else {
                    if (distance > dis) {
                        distance = dis;
                        fish = f;
                    } else if (distance == dis) { // 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기를 먹는다.
                        if (fish.x > f.x) fish = f;
                        else if (fish.x == f.x) { // 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.
                            if (fish.y > f.y) fish = f;
                        }
                    }
                }
                
            }
        }

        result += (distance == (int)1e9 ? 0 : distance);
        return fish;
    }

    public static int BFS(Fish fish) {
        queue.clear();
        visited = new boolean[N][N];
        s.time = 0;

        queue.offer(s);
        visited[s.x][s.y] = true;

        while(!queue.isEmpty()) {
            Shark shark = queue.poll();
            int x = shark.x;
            int y = shark.y;

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                if (visited[nx][ny]) continue; // 이미 지나갔던 자리라면 지나갈 수 없음.
                if (board[nx][ny] > shark.size) continue; // 자신보다 크기가 큰 물고기는 지나갈 수 없음.

                if (fish.x == nx && fish.y == ny) return shark.time+1; // 물고기를 최단 시간에 발견했다면 종료

                visited[nx][ny] = true;
                queue.offer(new Shark(nx, ny, shark.size, shark.eatCount, shark.time+1));

            }
        }

        return (int)1e9;
    }

}

class Shark implements Comparable<Shark> {

    int x;
    int y;
    int size;
    int eatCount;
    int time;

    public Shark(int x, int y, int size, int eatCount, int time) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.eatCount = eatCount;
        this.time = time;
    }

    @Override
    public int compareTo(Shark s) {
        return this.time - s.time;
    }

}

class Fish {

    int x;
    int y;
    int size;

    public Fish(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }
}