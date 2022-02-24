import java.util.*;
import java.io.*;

public class Main_17264 {
    static int N, P, W, L, G, score=0;
    static Map<String, String> player = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());

        for(int i=0; i<P; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            player.put(st.nextToken(), st.nextToken());
        }

        String result = "I AM IRONMAN!!";
        for(int i=0; i<N; i++) {
            String play = br.readLine();

            if (player.get(play) == null || player.get(play).equals("L")) {
                score -= L;
            } else {
                score += W;
            }

            if (score < 0) score=0;

            if (score >= G) {
                result = "I AM NOT IRONMAN!!";
            }
        }

        System.out.println(result);

    }

}