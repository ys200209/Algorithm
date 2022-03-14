import java.util.*;
import java.io.*;

public class Main15_13 {
    static int N;
    static Map<Integer, Integer> map = new HashMap<>();
    static int[] dp;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N];

        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            map.put(A, B);
        }

        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (entry1, entry2) -> {
            return entry1.getKey() - entry2.getKey();
        });

        for(int i=0; i<list.size(); i++) {
            dp[i] = 1;

            for(int j=0; j<i; j++) {
                if (list.get(i).getValue() > list.get(j).getValue()) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            /*System.out.println("i : " + i );
            System.out.println(Arrays.toString(dp));*/
        }

        int max = 0;
		for(int i = 0; i < N; i++) {
			max = Math.max(max, dp[i]);
		}

        System.out.println(N - max);





        

    }

}
