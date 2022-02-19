import java.util.*;
import java.io.*;

public class Main_1620 {
    static int N, M;
    static Map<Integer, String> map1 = new HashMap<>();
    static Map<String, Integer> map2 = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=1; i<=N; i++) {
            String name = br.readLine();
            map1.put(i, name);
            map2.put(name, i);
        }

        for(int i=1; i<=M; i++) {
            String quiz = br.readLine();
            boolean isInt = quiz.charAt(0) - '0' < 10 ? true : false;

            if (isInt) {
                sb.append(map1.get(Integer.parseInt(quiz)) + "\n");
            } else {
                sb.append(map2.get(quiz) + "\n");
            }
        }
        System.out.println(sb);
    }
}