import java.util.*;

public class Main15_5 {
    public static int N, result;
    public static int[][] cost, d;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        cost = new int[N][N];
        d = new int[1001][3];

        for(int i=0; i<N; i++) {
            for(int j=0; j<3; j++) {
                cost[i][j] = scanner.nextInt();
            }
        }

        d[0][0] = cost[0][0];
        d[0][1] = cost[0][1];
        d[0][2] = cost[0][2];

        int index_a, index_b;
        for(int i=1; i<N; i++) {
            for(int j=0; j<3; j++) {
                index_a = j+1 >= 3 ? j+1-3 : j+1;
                index_b = j+2 >= 3 ? j+2-3 : j+2;
                d[i][j] = Math.min(d[i-1][index_a] + cost[i][j], d[i-1][index_b] + cost[i][j]);
            }
        }

        result = d[N-1][0];
        for(int i=0; i<3; i++) {
            if (result > d[N-1][i]) result = d[N-1][i];
        }
        
        System.out.println(result);

    }
    
}
