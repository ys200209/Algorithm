import java.util.*;

class Main12_11 {
    static int N, K, L, snake_size=1, x, y, dx, dy, vector, time_stamp=0, result=1;
    static int[][] map;
    static int[][] K_pos; // 사과
    static String[][] L_pos; // 뱀
    static String str;
    static int[][] dx_dy;
    static int[] pos;
    static Queue<int[][]> queue;

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
        */

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        map = new int[N][N];
        queue = new LinkedList<>();
        map[0][0] = 2;
        queue.offer(new int[][]{{0,0}});
        pos = new int[]{0,0};
        dx_dy = new int[][]{{0,1},{1,0},{0,-1},{-1,0}}; // 동,남,서,북
        vector = 0;
        // K_pos = new int[K][2];

        for(int i=0; i<K; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            map[x][y] = 1;
        }
        L = sc.nextInt();
        L_pos = new String[L][2];

        for(int i=0; i<L; i++) {
            L_pos[i][0] = sc.next();
            L_pos[i][1] = sc.next();
        }

        for(int i=0; i<N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }

        for(int i=0; i<L; i++) {
            System.out.println("i = " + i);
            if(!move(queue.peek(), L_pos[i][0], L_pos[i][1])) { // 해당값을 정상적으로 움직였을 때.
                break;
            }
            for(int j=0; j<N; j++) {
                System.out.println(Arrays.toString(map[j]));
            }
            //System.out.println("result = " + result);
        }

        System.out.println("result = " + result);
    }

    public static boolean move(int[][] position, String x, String y) {
        if(vector >= 4) { // 방향 전환
            vector = 0;
        } else if (vector < 0) {
            vector = 3;
        }

        System.out.println("반복 : " + x);

        for(int i=0; i<Integer.parseInt(x)-time_stamp; i++) {
            dx = dx_dy[vector][0];
            dy = dx_dy[vector][1];
            
            System.out.println("queue.peek() = [" + queue.peek()[0][0]+"]["+queue.peek()[0][1]+"], queue.size() = " + queue.size());
            if(queue.peek()[0][0]+dx < 0 || queue.peek()[0][0]+dx >= N ||
                queue.peek()[0][1]+dy < 0 || queue.peek()[0][1]+dy >= N) {
                    System.out.println("IndexOutOfBounsException. dx : " + dx + ", dy : " + dy);
                    return false;
            }
            System.out.println("map[queue.peek()[0][0]+dx][queue.peek()[0][1]+dy] = " 
                                        + map[queue.peek()[0][0]+dx][queue.peek()[0][1]+dy]);

            if (map[queue.peek()[0][0]+dx][queue.peek()[0][1]+dy] == 1) { // Apple 발견했다면.
                snake_size++;
                result++;
                map[queue.peek()[0][0]+dx][queue.peek()[0][1]+dy] = 2;
                queue.offer(new int[][]{{queue.peek()[0][0]+dx,queue.peek()[0][1]+dy}});
            } else if (map[queue.peek()[0][0]+dx][queue.peek()[0][1]+dy] == 2) { // 자신과 부딪혔다면.
                return false;
            } else { // 그냥 이동했다면
                result++;
                map[queue.peek()[0][0]+dx][queue.peek()[0][1]+dy] = 2;
                queue.offer(new int[][]{{queue.peek()[0][0]+dx,queue.peek()[0][1]+dy}});
                int[][] pop = queue.poll();
                map[pop[0][0]][pop[0][1]] = 0;
            }
        }
        if(y.equals("D")) vector++;
        else vector--;

        if(x.equals(L_pos[L-1][0])) { // 마지막 인덱스까지 도착했는데도 종료되지 않았을 때.
            dx = dx_dy[vector][0];
            dy = dx_dy[vector][1];
            while(true) {
                if(queue.peek()[0][0]+dx < 0 || queue.peek()[0][0]+dx >= N ||
                queue.peek()[0][1]+dy < 0 || queue.peek()[0][1]+dy >= N) { // 부딫혔다면
                    break;
                }
                if (map[queue.peek()[0][0]+dx][queue.peek()[0][1]+dy] == 1) { // Apple 발견했다면.
                    snake_size++;
                    result++;
                    map[queue.peek()[0][0]+dx][queue.peek()[0][1]+dy] = 2;
                    queue.offer(new int[][]{{queue.peek()[0][0]+dx,queue.peek()[0][1]+dy}});
                } else if (map[queue.peek()[0][0]+dx][queue.peek()[0][1]+dy] == 2) { // 자신과 부딪혔다면.
                    result++;
                    return false;
                } else { // 그냥 이동했다면
                    result++;
                    map[queue.peek()[0][0]+dx][queue.peek()[0][1]+dy] = 2;
                    queue.offer(new int[][]{{queue.peek()[0][0]+dx,queue.peek()[0][1]+dy}});
                    int[][] pop = queue.poll();
                    map[pop[0][0]][pop[0][1]] = 0;
                }
            }
        }
        
        time_stamp = Integer.parseInt(x);
        return true;
    }
    
}
