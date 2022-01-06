import java.util.*;

class Main12_11 {
    static int N, K, move, time=0, result=0, now_x, now_y;
    static int[][] map;
    static Queue<Snake> queue = new LinkedList<>();

    public static void main(String[] args) {

        /*
            - �Ｚ���� SW �����׽�Ʈ

            'Dummy'��� ���� ������ �ִ�.�� ���ӿ��� ���� ���ͼ� ��� �ٴϴµ� ����� ������ �� ���̰� �þ�ϴ�.
            ���� �̸����� ��� �ٴϴٰ� �� �Ǵ� �ڱ� �ڽ��� ���� �ε����� ������ �����ϴ�.
            ������ NxN ���簢 ���� ������ ����ǰ� ��� ĭ���� ����� ������ �ֽ��ϴ�. ������ �����¿� ������
            ���� �ֽ��ϴ�. ������ ������ �� ���� �� �� �� ������ ��ġ�ϰ� ���� ���̴� 1�Դϴ�.
            ���� ó���� �������� ���մϴ�.

            - �̵� ��Ģ
            1. ���� �����̸� �÷� �Ӹ��� ����ĭ�� ��ġ��Ų��.
            2. ���� �̵��� ĭ�� ����� �ִٸ�, �� ĭ�� �ִ� ����� �������� ������ �������� �ʽ��ϴ�.
            3. ���� ����� ���ٸ�, �����̸� �ٿ��� ������ ��ġ�� ĭ�� ����ݴϴ�.

            ����� ��ġ�� ���� �̵� ��ΰ� �־��� �� �� ������ �� �ʿ� �������� ����ϼ���.
            ('L'�� ����, 'D'�� �������̴�)
        */

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        K = scanner.nextInt();

        map = new int[N+1][N+1];

        for(int i=0; i<K; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            map[x][y] = 1;
        }

        map[1][1] = 2;
        now_x = 1;
        now_y = 1;
        queue.offer(new Snake(now_x, now_y));

        move = scanner.nextInt();

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int turn_index = 0;

        int front=0;
        String turn="";
        for(int i=0; i<move; i++) {
            front = scanner.nextInt();
            turn = scanner.next();

            // System.out.println("front = " + front + ", turn = " + turn + ", turn_index = " + turn_index);

            for(int j=0; j<front - result; j++) {
                result += 1;

                int nx = now_x + dx[turn_index];
                int ny = now_y + dy[turn_index];

                if (nx <= 0 || nx > N || ny <= 0 || ny > N) {
                    System.out.println("result = " + result);
                    return;
                }

                if (map[nx][ny] == 0) {
                    queue.offer(new Snake(nx, ny));
                    Snake snake = queue.poll();
                    int poll_x = snake.getX();
                    int poll_y = snake.getY();
                    map[nx][ny] = 2;
                    map[poll_x][poll_y] = 0;
                } else if (map[nx][ny] == 1) {
                    queue.offer(new Snake(nx, ny));
                    map[nx][ny] = 2;
                } else {
                    System.out.println("result = " + result);
                    return;
                }
                now_x = nx;
                now_y = ny;

            }
                
            if (turn.equals("D")) turn_index = turn_index+1 >= 4 ? 0 : turn_index + 1;
            else turn_index = turn_index-1 < 0 ? 4 : turn_index - 1;

        }

        while(true) {
            int nx = now_x + dx[turn_index];
            int ny = now_y + dy[turn_index];

            if (nx <= 0 || nx > N || ny <= 0 || ny > N) {
                System.out.println("result = " + result);
                return;
            }

            if (map[nx][ny] == 0) {
                queue.offer(new Snake(nx, ny));
                Snake snake = queue.poll();
                int poll_x = snake.getX();
                int poll_y = snake.getY();
                map[nx][ny] = 2;
                map[poll_x][poll_y] = 0;
            } else if (map[nx][ny] == 1) {
                queue.offer(new Snake(nx, ny));
                map[nx][ny] = 2;
            } else {
                System.out.println("result = " + result);
                return;
            }
            
            now_x = nx;
            now_y = ny;


        }

            

        /*for(int i=0; i<=N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }

        System.out.println("result = " + result);*/

    }

}

class Snake {
    
    private int x;
    private int y;

    public Snake(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

}