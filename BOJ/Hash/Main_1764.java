import java.io.*;
import java.util.*;

public class Main_1764 {
    static int N, M, count=0;
    static Set<String> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            set.add(br.readLine());
        }

        for(int i=0; i<M; i++) {
            String name = br.readLine();
            if (!set.add(name)) {
                count++;
                list.add(name);
            }
        }

        Collections.sort(list);

        for(String name : list) {
            sb.append(name + "\n");
        }

        System.out.println(count + "\n" + sb);

    }

}