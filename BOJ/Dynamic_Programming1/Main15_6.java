import java.util.*;

public class Main15_6 {
    public static int N, result=0;
    public static int[][] map, d;
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        map = new int[N+1][N+1];
        d = new int[N+1][N+1];

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=i; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        d[1][1] = map[1][1];

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=i; j++) {
                if (j == 1) {
                    d[i][j] = d[i-1][j] + map[i][j];
                } else if (j == i) {
                    d[i][j] = d[i-1][j-1] + map[i][j];
                } else {
                    d[i][j] = Math.max(d[i-1][j-1], d[i-1][j]) + map[i][j];
                }
            }
        }

        for(int i=1; i<=N; i++) {
            result = Math.max(result, d[N][i]);
        }

        System.out.println(result);

    }

}