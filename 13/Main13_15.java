import java.util.*;

class Main13_15 {
    public static int N, M, K, X, pos_x, pos_y, count=0;
    public static int[][] map;
    public static boolean[] visited;
    public static int[] result;
    public static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {

        /*
            어떤 나라에는 1 ~ N번까지의 도시와 M개의 단방향 도로가 존재합니다. 모든 도로의 거리는 1입니다.
            이때 특정한 도시 X로부터 출발하여 도달할 수 있는 모든 도시 중에서, 최단 거리가 정확히 K인 모든 도시의
            번호를 출력하는 프로그램을 작성하세요. 또한 출발 도시 X에서 출발 도시 X로 가는 최단 거리는 항상
            0이라고 가정합니다.
            예를 들어 N = 4, K = 2, X = 1일 때 1번 도시에서 출발하여 도달할 수 있는 도시중에서,
            최단 거리가 2인 도시는 4번 도시뿐입니다. 2번과 3번 도시의 경우, 최단 거리가 1이기 때문에 출력하지 않습니다.

            도시의 개수 N, 도로의 개수 M, 거리 정보 K, 출발 도시의 번호 X.
        */

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt(); // 도시의 개수
        M = scanner.nextInt(); // 도로의 개수
        K = scanner.nextInt(); // 거리 정보
        X = scanner.nextInt(); // 출발 도시의 번호

        map = new int[N+1][N+1];
        result= new int[N+1];
        visited = new boolean[N+1];

        for(int i=0; i<M; i++) {
            pos_x = scanner.nextInt();
            pos_y = scanner.nextInt();

            map[pos_x][pos_y] = 1;
            // map[pos_y][pos_x] = 1;
        }

        BFS();
        System.out.println(queue.poll());
    }

    public static void BFS() {

        queue.offer(X);
        visited[X] = true;

        while(!queue.isEmpty()) {
            int temp = queue.poll();

            count += 1;

            for(int j=1; j<=N; j++) {
                System.out.println("map["+temp+"]["+j+"] = "+ map[temp][j]);
                System.out.println("result["+j+"] = "+ result[j] + ", count : " + count);
                if (map[temp][j] == 1 && visited[j] == false && result[j] == 0) {
                    visited[j] = true;
                    result[j] = count;

                    queue.offer(j);
                    System.out.println("queue.size() = " + queue.size());
                }
            }

            

            if (count == K) {
                System.out.println("(break) queue.size() = " + queue.size());
                break;
            }

        }

    }
    
}