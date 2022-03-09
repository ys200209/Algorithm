import java.util.*;
import java.io.*;

public class Main_22252 {
    static long result=0;
    static int Q;
    static Map<String, Queue<Integer>> map = new HashMap<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Q = Integer.parseInt(br.readLine());

        for(int q=0; q<Q; q++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int num = Integer.parseInt(st.nextToken());
            if (num == 1) {
                String name = st.nextToken();
                if (map.get(name) == null) map.put(name, new PriorityQueue<>(Collections.reverseOrder()));

                int size = Integer.parseInt(st.nextToken());
                for(int i=0; i<size; i++) {
                    map.get(name).offer(Integer.parseInt(st.nextToken()));
                }

            } else { 
                String name = st.nextToken();
                if (map.get(name) == null) continue;

                int size = Integer.parseInt(st.nextToken());
                if (map.get(name).size() < size) size = map.get(name).size();

                for(int i=0; i<size; i++) {
                    result += map.get(name).poll();
                }

                if (map.get(name).isEmpty()) map.remove(name);
            }
        }

        for(String s : map.keySet()) {
            System.out.print(s + " : ");
            while(!map.get(s).isEmpty()) {
                System.out.print(map.get(s).poll() + " ");
            }
            System.out.println();
        }

        System.out.println(result);

    }

}