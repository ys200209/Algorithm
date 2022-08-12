import java.util.*;
import java.io.*;

public class Main16_13305 {
    // static int N, result=0, nowDistance=0, nowCost=(int)1e9, minCost=(int)1e9;
    // static int[] distance;
    // static int[] cost;
    
    // public static void main(String[] args) throws IOException {

    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     StringTokenizer st;

    //     N = Integer.parseInt(br.readLine());
    //     distance = new int[N-1];
    //     cost = new int[N];

    //     for(int i=0; i<2; i++) {
    //         st = new StringTokenizer(br.readLine(), " ");
    //         int j=0;
    //         while(st.hasMoreTokens()) {
    //             if (i == 0) nowDistance += distance[j] = Integer.parseInt(st.nextToken());
    //             else minCost = Math.min(cost[j] = Integer.parseInt(st.nextToken()), minCost);
    //             j++;
    //         }
    //     }

    //     for(int i=0; i<N-1; i++) {
    //         if (nowCost > cost[i]) nowCost = cost[i];

    //         if (nowCost == minCost) {
    //             result += (nowCost * nowDistance);
    //             break;
    //         }

    //         result += (distance[i] * nowCost);
    //     }

    //     System.out.println(result);
    // }

    static long result=0, minCost=Long.MAX_VALUE; 
    static long[] distance;
    static long[] cost;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        distance = new long[N-1];
        cost = new long[N];

        for(int i=0; i<2; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j=0;
            while(st.hasMoreTokens()) {
                if (i == 0) distance[j] = Long.parseLong(st.nextToken());
                else cost[j] = Long.parseLong(st.nextToken());
                j++;
            }
        }

        for(int i=0; i<N-1; i++) {
            if (minCost > cost[i]) minCost = cost[i];

            result += (distance[i] * minCost);
        }
        System.out.println(result);
    }

}
