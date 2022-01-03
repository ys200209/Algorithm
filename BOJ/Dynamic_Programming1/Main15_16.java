import java.util.*;

public class Main15_16 {
    public static int N, K, W, V, result=0;
    public static int[][] item, d;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();

        item = new int[N+1][2];
        d = new int[N+1][2];

        for(int i=1; i<=N; i++) {
            item[i][0] = scanner.nextInt();
            item[i][1] = scanner.nextInt();
        }

        d[1][0] = item[1][0];
        d[1][1] = item[1][1];
        
        for(int i=1; i<=N; i++) {
            for(int j=i+1; j<=N; j++) {
                if (d[j-1][0] + item[j][0] <= K && d[j][1] < d[j-1][1] + item[j][1]) {
                    d[j][0] = d[j-1][0] + item[j][0];
                    d[j][1] = d[j-1][1] + item[j][1];
                } else if (d[j-1][0] + item[j][0] > K && d[j][1] < item[j][1]) {
                    d[j][0] = item[j][0];
                    d[j][1] = item[j][1];
                }

                result = Math.max(result, d[j][1]);
            }
        }

        for(int i=0; i<=N; i++) {
           System.out.println("d : " + Arrays.toString(d[i])); 
        }
        
        System.out.println(result);

    }
    
}