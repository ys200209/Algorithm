import java.util.*;

class Main12_11 {
    static int N, K, row, column, L, time=1, pos_index=0, vector_index=0;
    static int[][] map, pos;
    static String[][] vector;
    static String vec, second;
    static Queue<Snake> snake;
    static Snake last_Snake;

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

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt(); // N : 보드의 크기
        K = scanner.nextInt(); // K : 사과의 개수
        // apple_Location = new int[K][2]; // 사과의 좌표
        map = new int[N+1][N+1];
        pos = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
        snake = new LinkedList<>();
        last_Snake = new Snake(1, 1);
        snake.offer(last_Snake);
        
        for(int i=0; i<=N; i++) { // 맵을 로딩한다.
            for(int j=0; j<=N; j++) {
                map[i][j] = 0;
            }
        }
        System.out.println(map.length);
        System.out.println(map[0].length);

        for(int i=0; i<K; i++) { // 사과의 위치를 맵에 기록한다.
            row = scanner.nextInt();
            column = scanner.nextInt();
            map[row][column] = 1;
        }

        
        L = scanner.nextInt();
        vector = new String[L][2];
        for(int i=0; i<L; i++) {
            second = scanner.next();
            vec = scanner.next();
            vector[i][0] = second;
            vector[i][1] = vec;
        }

        /*for(int i=0; i<vector.length; i++) {
            System.out.println("vector[i][0] = " + vector[i][0]);
            for(int j=time; j<Integer.parseInt(vector[i][0]); j++) {
                System.out.println("현재 위치1 : [" + last_Snake.getX() + ", " + last_Snake.getY() + "]");
                if ( last_Snake.getX()+pos[pos_index][1] > N || last_Snake.getX()+pos[pos_index][1] < 1 || 
                last_Snake.getY()+pos[pos_index][0] > N || last_Snake.getY()+pos[pos_index][0] < 1 ) {
                    System.out.println("break. 1");
                    System.out.println(time+1);
                    return; // 뱀의 동선이 맵 밖으로 움직였을때 중지.
                }
                if ( map[(last_Snake.getX()+pos[pos_index][1])][(last_Snake.getY()+pos[pos_index][0])] == 2 ) { 
                    System.out.println("map[" + (last_Snake.getX()+pos[pos_index][1]) + ", " + (last_Snake.getY()+pos[pos_index][0]) + "] == 2");
                    System.out.println("break. 2");
                    System.out.println(time+1);
                    return; // 뱀이 자기 몸에 부딪히면 중지.
                }
            
                if ( map[last_Snake.getX()+pos[pos_index][1]][last_Snake.getY()+pos[pos_index][0]] == 0 ) {
                    // 일반 땅을 밟았다면 뱀을 움직인다.
                    System.out.println("move 1");
                    last_Snake = new Snake(last_Snake.getX()+pos[pos_index][1], last_Snake.getY()+pos[pos_index][0]);
                    snake.offer(last_Snake);
                    Snake tail = snake.poll();
                    map[last_Snake.getX()][last_Snake.getY()] = 2;
                    map[tail.getX()][tail.getY()] = 0;

                    time++;
                } else if ( map[last_Snake.getX()+pos[pos_index][1]][last_Snake.getY()+pos[pos_index][0]] == 1 ) {
                    // 사과를 먹었다면 뱀의 머리를 늘린다.
                    System.out.println("move 2");
                    last_Snake = new Snake(last_Snake.getX()+pos[pos_index][1], last_Snake.getY()+pos[pos_index][0]);
                    snake.offer(last_Snake);
                    map[last_Snake.getX()][last_Snake.getY()] = 2;
                    time++;
                }

            }

            System.out.println("-rotate-");
            for(int k=0; k<=N; k++) {
                System.out.println(Arrays.toString(map[k]));
            }

            if (vector[i][1].equals("D")) {
                pos_index ++;
            } else {
                pos_index --;
            }
            
            if (pos_index > 3) {
                pos_index = 0;
            } else if (pos_index < 0) {
                pos_index = 3;
            }
        }*/

        while(true) {
            System.out.println("현재 위치1 : [" + last_Snake.getX() + ", " + last_Snake.getY() + "]");
                if ( last_Snake.getX()+pos[pos_index][1] > N || last_Snake.getX()+pos[pos_index][1] < 1 || 
                last_Snake.getY()+pos[pos_index][0] > N || last_Snake.getY()+pos[pos_index][0] < 1 ) {
                    System.out.println("break. 1");
                    System.out.println(time+1);
                    break; // 뱀의 동선이 맵 밖으로 움직였을때 중지.
                }
                if ( map[(last_Snake.getX()+pos[pos_index][1])][(last_Snake.getY()+pos[pos_index][0])] == 2 ) { 
                    System.out.println("map[" + (last_Snake.getX()+pos[pos_index][1]) + ", " + (last_Snake.getY()+pos[pos_index][0]) + "] == 2");
                    /*if (last_Snake.getX()+pos[pos_index][1] != snake.peek().getX() ||
                    last_Snake.getY()+pos[pos_index][0] != snake.peek().getY()) {
                        System.out.println("break. 2");
                        System.out.println(time+1);
                        return; // 뱀이 자기 몸에 부딪히면 중지.
                        // 뱀이 움직임에 따라 꼬리도 움직일 경우에는 그대로 진행. (잘못됨)
                    }*/
                    System.out.println("break. 2");
                    System.out.println(time+1);
                    break; // 뱀이 자기 몸에 부딪히면 중지.
                }
            
                if ( map[last_Snake.getX()+pos[pos_index][1]][last_Snake.getY()+pos[pos_index][0]] == 0 ) {
                    // 일반 땅을 밟았다면 뱀을 움직인다.
                    System.out.println("move 1");
                    last_Snake = new Snake(last_Snake.getX()+pos[pos_index][1], last_Snake.getY()+pos[pos_index][0]);
                    snake.offer(last_Snake);
                    Snake tail = snake.poll();
                    map[last_Snake.getX()][last_Snake.getY()] = 2;
                    map[tail.getX()][tail.getY()] = 0;

                    time++;
                } else if ( map[last_Snake.getX()+pos[pos_index][1]][last_Snake.getY()+pos[pos_index][0]] == 1 ) {
                    // 사과를 먹었다면 뱀의 머리를 늘린다.
                    System.out.println("move 2");
                    last_Snake = new Snake(last_Snake.getX()+pos[pos_index][1], last_Snake.getY()+pos[pos_index][0]);
                    snake.offer(last_Snake);
                    map[last_Snake.getX()][last_Snake.getY()] = 2;
                    time++;
                }

        }
        for(int i=0; i<=N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }

        System.out.println(time);

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
        return x;
    }

    public int getY() {
        return y;
    }
}





























































/*
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        map = new int[N][N];
        queue = new LinkedList<>();
        map[0][0] = 2;
        queue.offer(new int[][]{{0,0}});
        pos = new int[]{0,0};
        dx_dy = new int[][]{{0,1},{1,0},{0,-1},{-1,0}}; // 
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
            if(!move(queue.peek(), L_pos[i][0], L_pos[i][1])) {
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
        if(vector >= 4) {
            vector = 0;
        } else if (vector < 0) {
            vector = 3;
        }

        System.out.println(" : " + x);

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

            if (map[queue.peek()[0][0]+dx][queue.peek()[0][1]+dy] == 1) { // 
                snake_size++;
                result++;
                map[queue.peek()[0][0]+dx][queue.peek()[0][1]+dy] = 2;
                queue.offer(new int[][]{{queue.peek()[0][0]+dx,queue.peek()[0][1]+dy}});
            } else if (map[queue.peek()[0][0]+dx][queue.peek()[0][1]+dy] == 2) { // 
                return false;
            } else { // 
                result++;
                map[queue.peek()[0][0]+dx][queue.peek()[0][1]+dy] = 2;
                queue.offer(new int[][]{{queue.peek()[0][0]+dx,queue.peek()[0][1]+dy}});
                int[][] pop = queue.poll();
                map[pop[0][0]][pop[0][1]] = 0;
            }
        }
        if(y.equals("D")) vector++;
        else vector--;

        if(x.equals(L_pos[L-1][0])) { // 
            dx = dx_dy[vector][0];
            dy = dx_dy[vector][1];
            while(true) {
                if(queue.peek()[0][0]+dx < 0 || queue.peek()[0][0]+dx >= N ||
                queue.peek()[0][1]+dy < 0 || queue.peek()[0][1]+dy >= N) { // 
                    break;
                }
                if (map[queue.peek()[0][0]+dx][queue.peek()[0][1]+dy] == 1) { // Apple
                    snake_size++;
                    result++;
                    map[queue.peek()[0][0]+dx][queue.peek()[0][1]+dy] = 2;
                    queue.offer(new int[][]{{queue.peek()[0][0]+dx,queue.peek()[0][1]+dy}});
                } else if (map[queue.peek()[0][0]+dx][queue.peek()[0][1]+dy] == 2) { //
                    result++;
                    return false;
                } else { //
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
*/