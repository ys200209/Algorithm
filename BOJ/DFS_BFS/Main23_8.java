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

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

        BFS();

    }

    public static void BFS() {

        queue.offer(new Node1(1, 1));

        while(!queue.isEmpty()) {
            Node1 node = queue.poll();
            
            

        }

    }
    
}

class Node1{

    private int x, y;

    public Node1(int x, int y) {
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
