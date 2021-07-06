import java.util.*;

class Main5_1 {
    static int N, M, result;
    static int[][] list;
    static String str;
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

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        list = new int[N][M];

        //System.out.println("N = " + N + ", M = " + M);
        for(int i=0; i<N; i++) {
            str = sc.nextLine();
            for(int j=0; j<M; j++) {
                list[i][j] = str.charAt(j) - '0';
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(DFS(i, j)) {
                    result++;
                }
            }
        }
        System.out.println("result = " + result);
    }

    public static boolean DFS(int x, int y) {
        if(x<0 || x>=N || y<0 || y>=M) {
            return false;
        }

        if(list[x][y] == 0) {
            list[x][y] = 1;
            DFS(x-1, y);
            DFS(x+1, y);
            DFS(x, y-1);
            DFS(x, y+1);
            return true;
        }

        return false;
    }

}