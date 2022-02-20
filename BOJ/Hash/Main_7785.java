import java.util.*;
import java.io.*;

public class Main_7785 {
    static int N;
    static Map<String, String> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            map.put(st.nextToken(), st.nextToken());
        }

        ArrayList<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (s1, s2) -> { return s2.compareTo(s1); });
        for(String name : list) {
            if (map.get(name).equals("enter")) sb.append(name + "\n");
        }

        System.out.println(sb);

    }
}
