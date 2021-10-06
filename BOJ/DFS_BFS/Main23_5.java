import java.util.*;

class Main23_5 {
    public static int N, M;
    public static String str;
    public static int[][] map;
    public static Queue<Node> queue = new LinkedList<>();
    
    public static void main(String[] args) {

        // 백준 온라인 저지 DFS/BFS(23)의 5번
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        map = new int[N+1][M+1];

        for(int i=1; i<=N; i++) {
            str = scanner.next();

            for(int j=1; j<=M; j++) {
                map[i][j] = str.charAt(j-1) - '0';
            }
        }

        BFS();

        System.out.println(map[N][M]);

    }

    public static void BFS() {
        queue.offer(new Node(1, 1));

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.getX();
            int y = node.getY();

            // 상, 하, 좌, 우 이동
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 1 || ny < 1 || nx > N || ny > M) continue; // 맵 밖으로 이동을 시도하면 취소.

                if (map[nx][ny] == 0) continue; // 벽으로 이동하려고 하면 취소.

                if (map[nx][ny] == 1) {
                    map[nx][ny] = map[x][y] + 1;
                    queue.offer(new Node(nx, ny));
                }
            }

        }
    }

}

class Node {

    private int x, y;

    public Node(int x, int y) {
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
