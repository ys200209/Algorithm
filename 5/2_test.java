import java.util.*;

class Main5_2 {
    static int N, M, count;
    static int[][] map;

    public static void main(String[] args) {

        /* 
        A는 N X M 크기의 직사각형 형태의 미로에 갇혀 있다. 미로에는 여러 마리의 괴물이 있어 이를 피해
        탈출해야 한다. A의 위치는 (1, 1)이고 미로의 출구는 (N, M)의 위치에 존재하며 한번에 한 칸씩 이동할 수 있다.
        이때 괴물이 있는 부분은 0으로, 괴물이 없는 부분은 1로 표시되어 있다. 미로는 반드시 탈출할 수 있는 형태이며
        A가 탈출하기 위해 움직여야 하는 최소 칸의 개수를 구하시오. (시작 칸과 마지막 칸을 모두 포함해서 계산한다)

        ex) 
        5 6 (N, M)
        101010
        111111
        000001
        111111
        111111
        */

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        String str;
        map = new int[N][M];
        for(int i=0; i<N; i++) {
            str = sc.nextLine();
            for(int j=0; j<M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        DFS(1, 1, 1);

        for(int i=0; i<N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }

        System.out.println("result = " + map[N-1][M-1]);

    }

    public static void DFS(int x, int y, int count) {
        if (x<0 || x>=N || y<0 || y>=M) {
            return;
        }

        if (map[x][y] == 1) {
            map[x][y] = count;
            DFS(x-1, y, count+1);
            DFS(x+1, y, count+1);
            DFS(x, y-1,count+1);
            DFS(x, y+1, count+1);
            
            return ;
        }

        return;
    }

}
