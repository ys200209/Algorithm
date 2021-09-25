import java.util.*;

class Main5_1 {
    public static int N, M, result;
    public static String[][] frame;

    public static void main(String[] args) {

        /*
            N X M 크기의 얼음 틀이 있다. 구멍이 뚫려있는 부분은 0, 칸막이가 존재하는 부분은 1로 표시된다.
            구멍이 뚫려 있는 부분끼리 상, 하, 좌, 우로 붙어 있는 경우 서로 연결되어 있는 것으로 간주한다.
            이때 얼음 틀의 모양이 주어졌을 때 생성되는 총 아이스크림의 개수를 구하는 프로그램을 작성하시오.
            ex) 4 X 5 얼음 틀 예시에서는 아이스크림이 총 3개 생성된다. (1 <= N,M <= 1,000 )
            00110
            00011
            11111
            00000
        */

        // 1. 배열의 크기 : 입력받는 것과 1000 중에서 1 택.

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        frame = new String[N][M];

        for(int i=0; i<N; i++) {
            frame[i] = scanner.next().split("");
        }

        for(int i=0; i<N; i++) {
            System.out.println(Arrays.toString(frame[i]));
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(DFS(i, j)) {
                    result += 1;
                }
            }
        }
        System.out.println(result);
    }

    public static boolean DFS(int x, int y) {
        if (x >= N || x < 0 || y >= M || y < 0) {
            return false;
        }

        if(frame[x][y].equals("1")) {
            return false;
        }

        if (frame[x][y].equals("0")) {
            frame[x][y] = "1";
            DFS(x-1, y);
            DFS(x+1, y);
            DFS(x, y-1);
            DFS(x, y+1);
            return true;
        }
        return false;
    }
}