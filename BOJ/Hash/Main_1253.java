import java.util.*;
import java.io.*;

public class Main_1253 {
    static int N, result=0;
    static int[] number;
    static Set<Integer> set = new HashSet<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        number = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int i=0;
        while(st.hasMoreTokens()) {
            number[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        Arrays.sort(number);

        if (N >= 2) {
            set.add(number[0] + number[1]);
        }

        for(i=2; i<N; i++) {
            for(int j=0; j<i; j++) {
                set.add(number[i] + number[j]);
            }
            if (!set.add(number[i])) result++;
        }

        System.out.println(result);

    }

}