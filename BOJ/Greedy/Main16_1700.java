import java.util.*;
import java.io.*;

public class Main16_1700 {
    static int N, K, count=0;
    static Map<Integer, Integer> countMap = new HashMap<>();
    static Map<Integer, Integer> map = new HashMap<>(); // list
    static Queue<Integer> queue = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());

            queue.offer(num);
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        while(N > 0) {
            int num = queue.poll();

            if (!map.containsKey(num)) N--;

            countMap.put(num, countMap.get(num) - 1);
            map.put(num, countMap.get(num));
        }

        while(!queue.isEmpty()) {
            int num = queue.poll();

            if (map.containsKey(num)) {
                countMap.put(num, countMap.get(num) - 1);
                map.put(num, countMap.get(num));
                continue;
            }
            
            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list, (entry1, entry2) -> {
                return entry1.getValue() - entry2.getValue();
            });
            
            for(Map.Entry<Integer, Integer> entry : list) {
                System.out.println("remove : " + entry.getKey());
                map.remove(entry.getKey());
                countMap.put(num, countMap.get(num) - 1);
                map.put(num, countMap.get(num));
                break;
            }
            count++;
        }
        System.out.println(count);
    }
}