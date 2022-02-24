import java.util.*;
import java.io.*;

public class Main_1354 {
    static long N;
    static int P, Q, X, Y;
    static Map<Long, Long> A = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Long.parseLong(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        System.out.println(INF(N));

    }

    public static long INF(long i) {
        if (i <= 0) return 1;

        if (A.get(i) != null) return A.get(i);

        A.put(i, INF((i/P)-X) + INF((i/Q)-Y));
        return A.get(i);
    }
    
}
