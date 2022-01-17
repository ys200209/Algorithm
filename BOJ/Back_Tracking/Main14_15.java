import java.util.*;

public class Main14_15 {
    static int N;
    static int[][] map;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        map = new int[N][N];

        DFS(0, 0, 0);

    }

    public static void DFS(int x, int y, int count) {
        if (count == N) {
            /*System.out.println("---------------");
            for(int i=0; i<N; i++) {
                System.out.println(Arrays.toString(map[i]));
            }*/
            return;
        }

        for(int i=x; i<N; i++) {
            for(int j=y; j<N; j++) {
                
                if (map[i][j] == 0) {
                    System.out.println("(" + i + ", " + j + ")");
                    map[i][j] = 1;
                    count += 1;
                    DFS(i, j, count);
                    count -= 1;
                    map[i][j] = 0;
                }
            }
        }


    }

}
