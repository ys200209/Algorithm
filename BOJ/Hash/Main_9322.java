import java.util.*;
import java.io.*;

public class Main_9322 {
    static int T, N;
    static Map<String, PublicKey> keyMap;
    static Map<Integer, String> resultMap;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            N = Integer.parseInt(br.readLine());
            keyMap = new HashMap<>();
            resultMap = new HashMap<>();

            int i=0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()) {
                keyMap.put(st.nextToken(), new PublicKey(i, -1));
                i++;
            }

            i=0;
            st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()) {
                String word = st.nextToken();
                PublicKey publicKey = keyMap.get(word);
                publicKey.to = i;
                keyMap.put(word, publicKey);
                i++;
            }

            ArrayList<Map.Entry<String, PublicKey>> list = new ArrayList<>(keyMap.entrySet());
            Collections.sort(list, (entry1, entry2) -> {
                return entry1.getValue().to - entry2.getValue().to;
            });

            i = 0;
            st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()) {
                String word = st.nextToken();
                resultMap.put(list.get(i).getValue().from, word);
                i++;
            }
            
            for(i=0; i<N; i++) {
                sb.append(resultMap.get(i) + " ");
            }
            sb.append("\n");

        }

        System.out.println("------------------------");
        System.out.println(sb);

    }
    
}

class PublicKey {

    int from;
    int to;

    public PublicKey(int from, int to) {
        this.from = from;
        this.to = to;
    }

}