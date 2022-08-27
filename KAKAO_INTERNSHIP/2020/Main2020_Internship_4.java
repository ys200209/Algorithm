import java.util.*;

class Main2020_Internship_4 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Integer[][] costs;
    static Queue<Car> queue = new LinkedList<>();
    static int N, result=(int)1e9;

    public static void main(String[] args) {

        // System.out.println(solution(new int[][]{{0,0,0},{0,0,0},{0,0,0}})); // 900
        // System.out.println(solution(new int[][]{{0,0,0,0},{0,1,1,0},{0,1,1,1}, {0,0,0,0}})); // 
        System.out.println(solution(new int[][]{{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}})); // 3200
        // System.out.println(solution(new int[][]{{0,0}})); // 100
        // System.out.println(solution(new int[][]{{0,1}, {1,0}})); // 0

        for(int i=0; i<costs.length; i++) {
            System.out.println(Arrays.toString(costs[i]));
        }

    }

    public static int solution(int[][] board) {
        N = board.length;
        costs = new Integer[N][N];

        return BFS(board);
    }

    public static int BFS(int[][] board) {
        int result = (int)1e9;

        queue.offer(new Car(0, 0, 0, -1));
        costs[0][0] = 0;

        while(!queue.isEmpty()) {
            Car car = queue.poll();
            int x = car.x;
            int y = car.y;

            if (x == N-1 && y == N-1) {
                result = Math.min(result, car.cost);
                continue;
            }
            
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) continue;

                if (board[nx][ny] == 1) continue;

                if (car.vector == -1) { // 처음 출발이라면 무조건 직진뿐임.
                    queue.offer(new Car(nx, ny, car.cost + 100, i));
                    costs[nx][ny] = car.cost + 100;
                } else { // 처음 출발이 아니라서 이전에 진행했던 방향이 존재한 경우
                    moveCar(nx, ny, car, i);
                }
            }
        }
        return result;
    }

    public static void moveCar(int nx, int ny, Car car, int vector) {
        if (costs[nx][ny] == null) {
            if (car.vector == vector) {
                costs[nx][ny] = car.cost + 100;
                queue.offer(new Car(nx, ny, car.cost + 100, vector));
            } else {
                costs[nx][ny] = car.cost + 500 + 100;
                queue.offer(new Car(nx, ny, car.cost + 500 + 100, vector));
            }
        } else {
            int cost;
            if (car.vector == vector) {
                cost = car.cost + 100;
                if (costs[nx][ny] < cost) return;
            } else {
                cost = car.cost + 500 + 100;
                if (costs[nx][ny] < cost) return;
            }

            costs[nx][ny] = cost;
            queue.offer(new Car(nx, ny, cost, vector));
        }
    }

    /*public static boolean checkCost(int x, int y, int c) {
        if (costs[x][y] < c) return true; // 현재 위치를 이미 저렴한 가격으로 지나간적 있다면

        // if (x == N-1 && y == N-1) { // 마지막에 도착했다면
        //     result = Math.min(result, c);
        //     return true;
        // }

        return false;
    }*/

}

class Car {

    int x;
    int y;
    int cost;
    int vector;

    public Car(int x, int y, int cost, int vector) {
        this.x = x;
        this.y = y;
        this.cost = cost;
        this.vector = vector;
    }
}