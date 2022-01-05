import java.util.*;

public class Main15_5 {
    static int N, result=(int)1e9;
    static int[][] cost, d;
    

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        cost = new int[N+1][3];
        d = new int[N+1][3];

        for(int i=1; i<=N; i++) {
            cost[i][0] = scanner.nextInt();
            cost[i][1] = scanner.nextInt();
            cost[i][2] = scanner.nextInt();
        }

        TopDown(N);

        for(int i=0; i<3; i++) {
            result = Math.min(result, d[N][i]);
        }

        System.out.println(result);
        
    }

    public static int[] TopDown(int index) {
        if (index == 0) return d[0];

        for(int i=0; i<3; i++) {
            if (i == 0) {
                d[index][0] = d[index][0] == 0 ? Math.min(TopDown(index-1)[1] + cost[index][0], 
                        TopDown(index-1)[2] + cost[index][0]) : d[index][0];
                        
            } else if (i == 1) {
                d[index][1] = d[index][1] == 0 ? Math.min(TopDown(index-1)[0] + cost[index][1], 
                        TopDown(index-1)[2] + cost[index][1]) : d[index][1];
            } else {
                d[index][2] = d[index][2] == 0 ? Math.min(TopDown(index-1)[0] + cost[index][2],
                        TopDown(index-1)[1] + cost[index][2]) : d[index][2];
            }
        }

        return d[index];
    }

}