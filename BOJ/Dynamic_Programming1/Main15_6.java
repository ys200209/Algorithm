import java.util.*;

public class Main15_6 {
    public static int N, result;
    public static int[][] map, d;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        map = new int[N][N];
        d = new int[N+1][N+1];

        for(int i=0; i<N; i++) {
            for(int j=0; j<=i; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        d[0][0] = map[0][0];
        
        for(int i=1; i<N; i++) {
            for(int j=0; j<=i; j++) {
                if (j == 0) {
                    d[i][j] = d[i-1][j] + map[i][j];
                } else if (j == i) {
                    d[i][j] = d[i-1][j-1] + map[i][j];
                } else {
                    d[i][j] = Math.max(d[i-1][j-1]+map[i][j], d[i-1][j]+map[i][j]);
                }
            }
        }
        
        result = d[N-1][0];
        for(int i=1; i<N; i++) {
            result = Math.max(result, d[N-1][i]);
        }

        System.out.println(result);
        
    }
    
}
