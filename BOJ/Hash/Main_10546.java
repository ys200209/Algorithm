import java.util.*;
import java.io.*;

public class Main_10546 {
    static int N;
    static Map<String, Integer> map = new HashMap<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        for(int i=0; i<N-1; i++) {
            String name = br.readLine();
            if (map.get(name) == 1) map.remove(name);
            else map.put(name, map.get(name)-1);
        }

        for(String name : map.keySet()) {
            System.out.println(name);
        }

    }

}