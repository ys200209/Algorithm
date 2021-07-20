import java.util.*;

class Main13_17 {
    static int N, K, S, X, Y;
    static int[][] map;
    static PriorityQueue<Virus> pq; // 우선순위 큐
    static Queue<Virus> q; // 일반 큐
    static Virus virus;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        
        map = new int[N+1][N+1];
        pq = new PriorityQueue<>();
        q = new LinkedList<>();

        for(int i=1; i<=N; i++) { 
            for(int j=1; j<=N; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] != 0) {
                    pq.offer(new Virus(map[i][j], new int[]{i, j})); // 바이러스가 위치한 곳의 좌표를 저장한다.
                }
            }
        }

        S = sc.nextInt();
        X = sc.nextInt();
        Y = sc.nextInt();

        System.out.println("pq.size() = " + pq.size());
        int size = pq.size();
        for(int i=0; i<size; i++) {
            System.out.println("값 이동 pq.peek().virus_number = " + pq.peek().virus_number);
            q.offer(pq.poll());
        }

        System.out.println("pq.size() = " + pq.size());
        System.out.println("q.size() = " + q.size());
        for(int i=1; i<=S; i++) { // 특정 시간초만큼 전염시킨다.
            for(int j=1; j<=K; j++) {
                virus = q.poll();
                BFS(virus.virus_position[0] - 1, virus.virus_position[1], virus.virus_number);
                BFS(virus.virus_position[0] + 1, virus.virus_position[1], virus.virus_number);
                BFS(virus.virus_position[0], virus.virus_position[1] - 1, virus.virus_number);
                BFS(virus.virus_position[0], virus.virus_position[1] + 1, virus.virus_number);
                q.offer(virus);
            }
            System.out.println(i + "초 경과...");
            for(int a=0; a<=N; a++) {
                System.out.println(Arrays.toString(map[a]));
            }
            System.out.println();
        }

        System.out.println("pq.size() = " + pq.size());
        System.out.println("pq.peek()? = " + pq.peek().virus_number);
    }

    public static void BFS(int dx, int dy, int number) {
        System.out.println("("+ dx + "," + dy+ "), number = " + number);
        if(dx <= 0 || dx > N || dy <= 0 || dy > N) {
            return;
        }

        if(map[dx][dy] == 0) {
            map[dx][dy] = number;
        }

    }
    
}

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

    /*// 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
    @Override
    public int compareTo(Node other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }*/

}
