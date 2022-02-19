import java.util.*;
import java.io.*;

public class Main_11652 {
    static long result;
    static int N;
    static Map<Long, Integer> map = new HashMap<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            long num = Long.parseLong(br.readLine());

            map.put(num, map.getOrDefault(num, 0) + 1);

            if (map.get(result) == null) {
                result = num;
                continue;
            }
            
            if (map.get(result) == map.get(num) && result > num) {
                result = num; 
                continue;
            }
            
            if (map.get(result) < map.get(num)) result = num;
        }

        for(long num : map.keySet()) {
            System.out.println(num + " : " + map.get(num));
        }

        System.out.println(result);
    }
}