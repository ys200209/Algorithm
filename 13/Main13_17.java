import java.util.*;

class Main13_17 {
    public static int N, K, S, X, Y, count = 0;
    public static int[][] map;
    public static PriorityQueue<Virus> queue = new PriorityQueue<>();
    public static Queue<Virus> readyQueue = new LinkedList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        K = scanner.nextInt();
        
        map = new int[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                map[i][j] = scanner.nextInt();
                if (map[i][j] != 0 ) {
                    queue.offer(new Virus(i, j, map[i][j]));
                }
            }
        }
        S = scanner.nextInt();
        X = scanner.nextInt();
        Y = scanner.nextInt();

        System.out.println("S : " + S + ", X : " + X + ", Y : " + Y);

        System.out.println(BFS());

        System.out.println("-----------------");
        for(int i=0; i<N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }

    }

    public static int BFS() {

        while(!queue.isEmpty()) {
            while(!queue.isEmpty()) {
                Virus virus = queue.poll();
                int virus_x = virus.getX();
                int virus_y = virus.getY();
                int virus_number = virus.getNumber();
    
                exclusive(virus_x, virus_y, virus_number);
            }
            
            count++;

            if (count == S) {
                break;
            }

            while(!readyQueue.isEmpty()) {
                queue.offer(readyQueue.poll());
            }
        }

        return map[X][Y];

    }

    public static void exclusive(int x, int y, int virus_number) {

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

            if (map[nx][ny] != 0) continue;

            map[nx][ny] = virus_number;

            readyQueue.offer(new Virus(nx, ny, virus_number));
        }

    }

    
        
}

class Virus implements Comparable<Virus>{

    private int x, y, virus_number;

    public Virus(int x, int y, int virus_number) {
        this.x = x;
        this.y = y;
        this.virus_number = virus_number;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getNumber() {
        return virus_number;
    }

    @Override
    public int compareTo(Virus o) {
        if (this.virus_number > o.virus_number) {
            return 1;
        }
        return -1;
    }

}



















/*
class Virus implements Comparable<Virus> {
    public int virus_number;
    public int[] virus_position;

    public Virus(int virus_number, int[] virus_position) {
        this.virus_number = virus_number;
        this.virus_position = virus_position;
    }

    @Override
    public int compareTo(Virus v) {
        if (this.virus_number < v.virus_number) {
            return -1;
        }
        return 1;
    }

    // // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
    // @Override
    // public int compareTo(Node other) {
    //     if (this.distance < other.distance) {
    //         return -1;
    //     }
    //     return 1;
    // }

} */
