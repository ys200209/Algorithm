import java.util.*;
import java.io.*;

public class Main_1351 {
    static long N, P, Q;
    static Map<Long, Long> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        System.out.println(INF(N));
    }

    public static long INF(long i) {
        if (i == 0) return 1;

        if (map.get(i) != null) return map.get(i);

        map.put(i, INF(i/P) + INF(i/Q));
        return map.get(i);
    }

}