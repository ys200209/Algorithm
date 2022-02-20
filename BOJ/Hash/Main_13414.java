import java.util.*;
import java.io.*;

public class Main_13414 {
    static int K, L;
    static Map<String, Integer> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        K = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        for(int i=1; i<=L; i++) {
            map.put(br.readLine(), i);
        }

        int count = 0;
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (entry1, entry2) -> {
            return (entry1.getValue() - entry2.getValue());
        });
        
        for(Map.Entry<String, Integer> entry : list) {
            if (count == K) break;
            sb.append(entry.getKey() + "\n");
            count++;
        }
        System.out.println("------------------");
        System.out.println(sb);

    }

}