import java.util.*;
import java.io.*;

public class Main11_1436 {
    
    
    public static void main(String[] args) throws IOException {

        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        
        Map<String, Integer> map = new HashMap<>();
        map.put("AZZ", 5);
        map.put("BBA", 3);
        map.put("CAZ", 1);

        for(String s : map.keySet()) {
            // System.out.println(s + " : " + map.get(s));
        }

        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (entry1, entry2) -> {
            return entry1.getValue() - entry2.getValue();
        });

        for(Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }

}
