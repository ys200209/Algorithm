import java.util.*;
class Main12_12 {
    static int N, K, L, snake_size=1, x, y, dx, dy, vector, time_stamp=0, result=1;
    static int[][] map;
    static String[][] L_pos; // 뱀
    static int[][] dx_dy;
    static Queue<int[][]> queue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        map = new int[N][N];
        queue = new LinkedList<>();
        map[0][0] = 2;
        queue.offer(new int[][]{{0,0}});
        dx_dy = new int[][]{{0,1},{1,0},{0,-1},{-1,0}}; // 동,남,서,북
        vector = 0;

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

        for(int i=0; i<L; i++) {
            if(!move(queue.peek(), L_pos[i][0], L_pos[i][1])) { 
                break;
            }
        }
        System.out.println(result);
    }

    public static boolean move(int[][] position, String x, String y) {
        if(vector >= 4) { // 방향 전환
            vector = 0;
        } else if (vector < 0) {
            vector = 3;
        }

        for(int i=0; i<Integer.parseInt(x)-time_stamp; i++) {
            dx = dx_dy[vector][0];
            dy = dx_dy[vector][1];
            
            if(queue.peek()[0][0]+dx < 0 || queue.peek()[0][0]+dx >= N ||
                queue.peek()[0][1]+dy < 0 || queue.peek()[0][1]+dy >= N) {
                    return false;
            }

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
                    break;
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
