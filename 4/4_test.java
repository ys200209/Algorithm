import java.util.*;

class Main4_4 {
    static Scanner sc;
    static int N;
    static int M;
    static int A;
    static int B;
    static int d;
    static String[][] map;
    static int[] dx;
    static int[] dy;
    static int count = 0;
    static int game_over = 0;

    public static void main(String[] args) {

        sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        // 1. 현재 방향을 기준으로 왼쪽(반시계) 방향부터 갈 곳을 정한다.
        // 2. 바로 왼쪽 방향에 가보지 않은 칸이 존재한다면, 왼쪽 방향으로 회전후 전진한다. 가봤다면 회전만 한다.
        // 3. 네 방향 모두 가봤거나 바다로 되어있다면, 바라보는 방향을 유지한채 뒤로 한칸 가고 만약 뒤쪽 방향이 바다라면 멈춘다.

        A = sc.nextInt();
        B = sc.nextInt();
        d = sc.nextInt();
        sc.nextLine();
        map = new String[N][M];

        dx = new int[]{-1, 0, 1, 0}; 
        dy = new int[]{0, 1, 0, -1}; // 차례대로 북, 동, 남, 서
        count = 0;

        for(int i=0; i<N; i++) {
            map[i] = sc.nextLine().split(" ");
        }
        long startTime = System.currentTimeMillis();
        map[A][B] = "1";
        count++;
        while(true) {
            d = turn_left(d);
            if (game_over > 5) {
                break;
            }
            System.out.println("game_over : " + game_over);
            
        }

        System.out.println("count : " + count);

        for(int i=0; i<map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }

    }

    public static int turn_left(int d) {
        if (game_over == 4) {
            System.out.println("back()");
            back();
        } else {
            System.out.println("go_straight()");
            d -= 1;
            if (d < 0) d = 3;
            go_straight();
        }
        
        return d;
    }

    public static void go_straight() {
        if (Integer.parseInt(map[A+dx[d]][B+dy[d]]) == 0) {
            A += dx[d];
            B += dy[d];
            map[A+dx[d]][B+dy[d]] = "1";
            count++;
            //game_over = 0;
            return;
        }
        game_over++;
    }

    public static void back() {
        if ((d == 0 || d == 1) && Integer.parseInt(map[A+dx[d+2]][B+dy[d+2]]) == 0) {
            A += dx[d+2];
            B += dy[d+2];
            game_over = 0;
        } else if ((d == 2 || d == 3) && Integer.parseInt(map[A+dx[d-2]][B+dy[d-2]]) == 0) {
            A += dx[d-2];
            B += dy[d-2];
            game_over = 0;
        } else {
            game_over++;
        }
    }

}
