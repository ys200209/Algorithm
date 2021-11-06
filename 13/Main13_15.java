import java.util.*;

class Main13_15 {
    public static int N, M, K, X, pos_x, pos_y, count=0;
    public static int[][] map;
    public static boolean[] visited;
    public static int[] result;
    public static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {

        /*
            � ���󿡴� 1 ~ N�������� ���ÿ� M���� �ܹ��� ���ΰ� �����մϴ�. ��� ������ �Ÿ��� 1�Դϴ�.
            �̶� Ư���� ���� X�κ��� ����Ͽ� ������ �� �ִ� ��� ���� �߿���, �ִ� �Ÿ��� ��Ȯ�� K�� ��� ������
            ��ȣ�� ����ϴ� ���α׷��� �ۼ��ϼ���. ���� ��� ���� X���� ��� ���� X�� ���� �ִ� �Ÿ��� �׻�
            0�̶�� �����մϴ�.
            ���� ��� N = 4, K = 2, X = 1�� �� 1�� ���ÿ��� ����Ͽ� ������ �� �ִ� �����߿���,
            �ִ� �Ÿ��� 2�� ���ô� 4�� ���û��Դϴ�. 2���� 3�� ������ ���, �ִ� �Ÿ��� 1�̱� ������ ������� �ʽ��ϴ�.

            ������ ���� N, ������ ���� M, �Ÿ� ���� K, ��� ������ ��ȣ X.
        */

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt(); // ������ ����
        M = scanner.nextInt(); // ������ ����
        K = scanner.nextInt(); // �Ÿ� ����
        X = scanner.nextInt(); // ��� ������ ��ȣ

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