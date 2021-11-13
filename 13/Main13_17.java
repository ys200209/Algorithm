import java.util.*;

class Main13_17 {
    public static int N, K, S, X, Y;
    public static int[][] map;
    public static Queue<Virus> queue = new LinkedList<>();
    public static Queue<Virus> pq = new PriorityQueue<>();

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
        map = new int[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                map[i][j] = scanner.nextInt();
                if (map[i][j] != 0) {
                    pq.offer(new Virus(i, j, map[i][j]));
                }
            }
        }

        S = scanner.nextInt();
        X = scanner.nextInt();
        Y = scanner.nextInt();

        while(!pq.isEmpty()) {
            queue.offer(pq.poll()); // 1, 2, 3번 순서대로만 정렬한 후 큐에 담아 연산 시작.
        }

        for(int i=0; i<S; i++) {
            BFS(queue.size());
        }

        System.out.println("result : " + map[X-1][Y-1]);

    }

    public static void BFS(int size) {

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for(int i=0; i<size; i++) {
            Virus virus = queue.poll();

            for(int j=0; j<4; j++) {
                int nx = virus.getX() + dx[j];
                int ny = virus.getY() + dy[j];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (map[nx][ny] == 0) {
                        map[nx][ny] = virus.getNumber();
                        queue.offer(new Virus(nx, ny, virus.getNumber()));
                    }
                }
            }
        }
    }
}

class Virus implements Comparable<Virus>{

    private int x;
    private int y;
    private int number;

    public Virus(int x, int y, int number) {
        this.x = x;
        this.y = y;
        this.number = number;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(Virus v1) {
        if (this.number > v1.number) {
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
