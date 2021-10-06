import java.util.*;

class Main23_6 {
    public static int N, M, result=0, state;
    public static int[][] map;
    public static Queue<Tomato> queue = new LinkedList<>();
    public static Queue<Tomato> readyQueue = new LinkedList<>();
    
    public static void main(String[] args) {
        
        // 백준 온라인 저지 DFS/BFS(23)의 6번
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        map = new int[M][N];

        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                state = scanner.nextInt(); // 1인 토마토의 위치는 따로 큐에 담아둔다.
                if (state == 1) {
                    queue.offer(new Tomato(i, j));
                }
                map[i][j] = state;
            }
        }

        for(int i=0; i<M; i++) {
            System.out.println(Arrays.toString(map[i]));
        }

        BFS();

        

        if (result==0) { // 토마토가 원래 모두 익어있다면
            System.out.println("0"); 
        } else { 
            for(int i=0; i<M; i++) {
                for(int j=0; j<N; j++) {
                    if (map[i][j] == 0) {
                        System.out.println(-1); // 만약 다 익지 못했다면 -1을 출력
                        return;
                    }
                }
            }
            
            System.out.println(result);
        }

    }

    public static void BFS() {

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        while(!queue.isEmpty()) {
            int count = queue.size();
            result += 1;
            System.out.println("count = " + count);

            for(int i=0; i<count; i++) { // 현재 1인 토마토의 갯수만큼 반복
                Tomato tomato = queue.poll();
                int x = tomato.getX();
                int y = tomato.getY();

                for(int j=0; j<4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue; // 상자 범위를 벗어나면 중지.

                    if (map[nx][ny] != 0) continue; // 토마토가 없거나 이미 익었다면 중지.

                    map[nx][ny] = 1;
                    queue.offer(new Tomato(nx, ny));
                    
                }
            }
        }

        result -= 1; // 맨 마지막 토마토가 익은 시간을 하나 뺀다.
    }
}

class Tomato {

    private int x, y;

    public Tomato(int x, int y) {
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