import java.util.*;

class Main23_5 {
    public static int N, M;
    public static String str;
    public static int[][] map;
    public static Queue<Node> queue = new LinkedList<>();
    public static boolean[][] visited;
    
    public static void main(String[] args) {

        // 백준 온라인 저지 DFS/BFS(23)의 5번
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        map = new int[N+1][M+1];
        visited = new boolean[101][101];

        for(int i=1; i<=N; i++) {
            str = scanner.next();

            for(int j=1; j<=M; j++) {
                map[i][j] = str.charAt(j-1) - '0';
            }
        }

        BFS(1, 1, 1);

        for(int i=0; i<N+1; i++) {
            System.out.println(Arrays.toString(map[i]));
        }

        System.out.println(map[N][M]);

    }
    
    public static void BFS(int x, int y, int count) {
        if (x < 1 || y < 1 || x > N || y > M) {
            return;
        }

        if (map[x][y] == 0) return;

        visited[x][y] = true;
        queue.offer(new Node(x, y));

        while(!queue.isEmpty() && map[N][M] == 1) {
            count += 1;
            Node node = queue.poll();

            for(int j=1; j<=M; j++) {
                if (map[node.getX()][j] != 0) {
                    map[node.getX()][j] = count;
                    queue.offer(new Node(node.getX(), j));
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
