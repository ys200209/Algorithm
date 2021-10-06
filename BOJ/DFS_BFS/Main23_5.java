import java.util.*;

class Main23_5 {
    public static int N, M;
    public static String str;
    public static int[][] map;
    public static Queue<Node> queue = new LinkedList<>();
    public static boolean[] visited;
    
    public static void main(String[] args) {

        // 백준 온라인 저지 DFS/BFS(23)의 5번
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        map = new int[N+1][M+1];
        visited = new boolean[101];

        for(int i=1; i<=N; i++) {
            str = scanner.next();

            for(int j=1; j<=M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        BFS(1, 1, 1);

        System.out.println(map[N][M]);

    }

    public static void BFS(int x, int y, int count) {
        if (x < 1 || y < 1 || x > N || y > M) {
            return;
        }

        if (map[x][y] == 0) {
            return;
        }

        queue.offer(new Node(x, y));
        visited[1] = true;

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            for(int j=1; j<=N; j++) {
                if (map[x][y] != 0 && visited[j] == false) {
                    visited[j] = true;
                    map[j][j] = count = count+1;
                    queue.offer(new Node(j, j));
                }
            }
        }

        return;
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
