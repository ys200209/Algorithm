import java.util.*;

class Main4_4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        int[] dx = new int[]{-1, 0, 1, 0}; 
        int[] dy = new int[]{0, 1, 0, -1}; // 차례대로 북, 동, 남, 서
        int count = 0;

        // 1. 현재 방향을 기준으로 왼쪽(반시계) 방향부터 갈 곳을 정한다.
        // 2. 바로 왼쪽 방향에 가보지 않은 칸이 존재한다면, 왼쪽 방향으로 회전후 전진한다. 가봤다면 회전만 한다.
        // 3. 네 방향 모두 가봤거나 바다로 되어있다면, 바라보는 방향을 유지한채 뒤로 한칸 가고 만약 뒤쪽 방향이 바다라면 멈춘다.

        int A = sc.nextInt();
        int B = sc.nextInt();
        int d = sc.nextInt();
        sc.nextLine();
        String[][] map = new String[N][M];

        for(int i=0; i<N; i++) {
            map[i] = sc.nextLine().split(" ");
        }
        long startTime = System.currentTimeMillis();

        while(true) {


            break;
        }
    }

}
