import java.util.*;

class Main23_8 {
    public static int N, M;
    public static String str;
    public static int[][] map;

    public static Queue<Node1> queue = new LinkedList<>();

    public static void main(String[] args) {

        // 백준 온라인 저지 DFS/BFS(23)의 7번
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        map = new int[1001][1001];

        for(int i=1; i<=N; i++) {
            str = scanner.next();
            
            for(int j=1; j<=M; j++) {
                map[i][j] = str.charAt(j-1) - '0';
            }
        }

        BFS();

        if (map[N][M] != 0) {
            System.out.println(map[N][M]);
        } else {
            System.out.println("-1");
        }

    }

    public static void BFS() {
        map[1][1] = 1;
        queue.offer(new Node1(1, 1, 0));
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while(!queue.isEmpty()) {
            Node1 node = queue.poll();
            int x = node.getX();
            int y = node.getY();
            int pass = node.getPass();

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 1 || ny < 1 || nx > N || ny > M) continue; // 맵 밖으로 지나가지 못하게 한다.

                if ( (nx == N && ny == M && map[nx][ny] < map[x][y]+1) && map[N][M] != 0 ) {
                    continue;
                }

                if ( (map[nx][ny] != 0 && map[nx][ny] != 1) || map[nx][ny] > map[x][y] + 1) { 
                    // 처음으로 지나가는 길이 아니고, 또한 이미 더 최단거리로 지나간 기록이 있다면 중지하라.
                    continue;
                }
                
                if ( map[nx][ny] == 1 && pass == 0) { // 벽을 처음으로 만났다면 부수고 지나간다.
                    queue.offer(new Node1(nx, ny, 1)); // ( x좌표, y좌표, 벽을 부순 횟수 )
                    map[nx][ny] = map[x][y] + 1;
                    continue;

                } else if ( map[nx][ny] == 1 && pass == 1) continue; // 벽을 만났지만 이미 한번 부쉈다면 지나가지 못한다.
                
                queue.offer(new Node1(nx, ny, pass)); // 벽이 아니라면 현재의 벽을 부순 여부를 저장하고 그대로 지나간다.
                map[nx][ny] = map[x][y] + 1;

            }
        }

    }
    
}

class Node1{

    private int x, y, pass;

    public Node1(int x, int y, int pass) {
        this.x = x;
        this.y = y;
        this.pass = pass;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getPass() {
        return pass;
    }

}
