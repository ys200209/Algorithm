import java.util.*;

class Main13_17 {
    public static int N, K, S, X, Y;
    public static int[][] map;
    public static Queue<Virus> pri_Queue = new PriorityQueue<>();
    public static Queue<Virus> queue = new LinkedList<>();

    public static void main(String[] args) {
/*
3 3
1 0 2
0 0 0
3 0 0
2 3 2
(3)

3 3
1 0 2
0 0 0
3 0 0
1 2 2
(0)
*/        

        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();

        map = new int[N+1][N+1];

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                map[i][j] = scanner.nextInt();
                if (map[i][j] != 0) {
                    queue.offer(new Virus(map[i][j], i, j));
                }
            }
        }

        S = scanner.nextInt();
        X = scanner.nextInt();
        Y = scanner.nextInt();

        BFS();

        System.out.println("map(" + X + ", " + Y + ") = " + map[X][Y]);

    }

    public static void BFS() {

        while(!pri_Queue.isEmpty()) {
            queue.offer(pri_Queue.poll());
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for(int t=0; t<S; t++) {
            int size = queue.size();
            for(int k=0; k<size; k++) {
                Virus virus = queue.poll();
    
                for(int i=0; i<4; i++) {
                    int nx = virus.getX() + dx[i];
                    int ny = virus.getY() + dy[i];
    
                    if (nx < 1 || nx > N || ny < 1 || ny > N) continue;
    
                    if (map[nx][ny] == 0) {
                        map[nx][ny] = virus.getVirusNum();
                        queue.offer(new Virus(map[nx][ny], nx, ny));
                    }
    
                }
            }
        }
    }
}

class Virus implements Comparable<Virus> {

    private int virusNum;
    private int x;
    private int y;

    public Virus(int virusNum, int x, int y) {
        this.virusNum = virusNum;
        this.x = x;
        this.y = y;
    }

    public int getVirusNum() {
        return this.virusNum;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public int compareTo(Virus v1) {
        if (this.virusNum < v1.getVirusNum()) {
            return -1;
        }
        return 1;
    }

}