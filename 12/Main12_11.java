import java.util.*;

class Main12_11 {
    static int N, K, move, time=0, result=0, now_x, now_y;
    static int[][] map;
    static Queue<Snake> queue = new LinkedList<>();

    public static void main(String[] args) {

        /*
            - 삼성전자 SW 역량테스트

            'Dummy'라는 도스 게임이 있다.이 게임에는 뱀이 나와서 기어 다니는데 사과를 먹으면 뱀 길이가 늘어납니다.
            뱀이 이리저리 기어 다니다가 벽 또는 자기 자신의 몸과 부딪히면 게임이 끝납니다.
            게임은 NxN 정사각 보드 위에서 진행되고 몇몇 칸에는 사과가 놓여져 있습니다. 보드의 상하좌우 끝에는
            벽이 있습니다. 게임을 시작할 때 뱀은 맨 위 맨 좌측에 위치하고 뱀의 길이는 1입니다.
            뱀은 처음에 오른쪽을 향합니다.

            - 이동 규칙
            1. 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
            2. 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않습니다.
            3. 만약 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워줍니다.

            사과의 위치와 뱀의 이동 경로가 주어질 때 이 게임이 몇 초에 끝나는지 계산하세요.
            ('L'은 왼쪽, 'D'는 오른쪽이다)
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