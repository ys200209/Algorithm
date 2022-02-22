import java.util.*;
import java.io.*;

public class Main_20291 {
    static int N;
    static Map<String, Integer> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            String ext = br.readLine().split("\\.")[1];
            map.put(ext, map.getOrDefault(ext, 0) + 1);
        }

        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (entry1, entry2) -> {
            return entry1.getKey().compareTo(entry2.getKey());
        });

        for(Map.Entry<String, Integer> entry : list) {
            sb.append(entry.getKey() + " " + entry.getValue() + "\n");
        }

        System.out.println(sb);

    }

}