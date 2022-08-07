import java.util.*;
import java.io.*;

public class Main16_1946 {
    static int T, N;
    static Map<Integer, Integer> map = new HashMap<>();
    static ArrayList<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            N = Integer.parseInt(br.readLine());

            for(int i=1; i<=N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int score1 = Integer.parseInt(st.nextToken());
                int score2 = Integer.parseInt(st.nextToken());
                map.put(score1, score2);
            }

            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list, (entry1, entry2) -> {
                return entry1.getKey() - entry2.getKey();
            });
            
            int min = list.get(0).getValue();
            int count = 0;
            for(Map.Entry<Integer, Integer> entry : list) {
                if (entry.getKey() == 1) continue; // 첫 키값은 비교하지 않음

                if (min > entry.getValue()) min = entry.getValue();
                else count++;
            }
            sb.append((N - count) + "\n");
        }
        
        System.out.println(sb);
    }
}