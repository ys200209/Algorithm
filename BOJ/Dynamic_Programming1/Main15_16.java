import java.util.*;

public class Main15_16 {
    static int N, K, W, result=0;
    static int[][] items, d;

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        K = scanner.nextInt();

        items = new int[N+1][2];
        d = new int[N+1][K+1];

        for(int i=1; i<=N; i++) {
            items[i][0] = scanner.nextInt();
            items[i][1] = scanner.nextInt();
        }

        for(int i=1; i<=N; i++) {
            
            for(int j=1; j<=K; j++) {
                if (j >= items[i][0]) {
                    d[i][j] = Math.max(d[i-1][j], items[i][1] + d[i-1][j-(items[i][0])]);
                } else {
                    d[i][j] = d[i-1][j];
                }
            }
        }

        /*for(int i=0; i<=N; i++) {
            System.out.println(Arrays.toString(d[i]));
        }*/

        for (int i=1; i<=K; i++) {
            result = Math.max(result, d[N][i]);
        }
        
        System.out.println(result);

    }

}