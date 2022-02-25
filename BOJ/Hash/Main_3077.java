import java.util.*;
import java.io.*;

public class Main_3077 {
    static int N, count=0;
    static Map<String, Integer> answer, A;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {

        answer = new HashMap<>();
        A = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int i=0;
        while(st.hasMoreTokens()) {
            answer.put(st.nextToken(), i);
            i++;
        }

        st = new StringTokenizer(br.readLine(), " ");
        i=0;
        while(st.hasMoreTokens()) {
            A.put(st.nextToken(), i);
            i++;
        }

        for(String s1 : answer.keySet()) {
            
            for(String s2 : A.keySet()) {
                if (set.contains(s2) || s1.equals(s2)) continue;

                if (Math.abs(answer.get(s2) - answer.get(s1)) == Math.abs(A.get(s2) - A.get(s1))) {
                    System.out.println(s1 + " - " + s2);
                    count++;
                }
            }
            set.add(s1);
        }

        System.out.println(count + "/" + (N*(N-1)/2));

    }

}