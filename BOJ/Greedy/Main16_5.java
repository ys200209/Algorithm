import java.util.*;
import java.io.*;

class Main16_5 {
    public static int N;
    public static int[] cities, price;
    public static boolean[] visited;
    public static long sum = 0, price_sum=0, result = (long)1e18;

    public static void main(String[] args) throws IOException {

        // 백준 온라인 저지 Greedy(16)의 5번
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        /*N = Integer.parseInt(br.readLine());

        cities = new int[N];
        visited = new boolean[N];
        price = new int[N-1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N-1; i++) {
            price[i] = Integer.parseInt(st.nextToken());
            price_sum += price[i];
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            cities[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0);


        System.out.println(result);*/

        br.readLine();

        String[] dis = br.readLine().split(" ");
        String[] amounts = br.readLine().split(" ");

        long min = Long.parseLong(amounts[0]), tot = 0;
        
        for (int i = 0; i < dis.length; i++) {
            long d = Long.parseLong(dis[i]);
            long a = Long.parseLong(amounts[i]);

            if(a < min) min = a;

            tot += (min * d);
        }

        System.out.println(tot);
    
    }

    public static void DFS(int count) {
        
        if (count == N-1 || price_sum == 0) {
            if (result > sum) 
            result = sum;
            return;
        }

        for(int i=0; i<cities.length-1; i++) {
            if (!visited[i]) {
                for(int k=price[count]; k<=price_sum; k++) {
                    if (k != price[count] && k != price_sum) return;
                    sum += cities[count] * k;
                    price_sum -= k;
                    visited[count] = true;  
                    count += 1;
                    DFS(count);
                    count -= 1;
                    visited[count] = false;
                    price_sum += k;
                    sum -= cities[count] * k;
                }       
            }
        }
    }

}