package BOJ.Implementation;

import java.io.*;
import java.util.*;

public class Main2_1924 {
    static String[] day = new String[]{"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
    static List<Integer> day30 = new ArrayList<>(Arrays.asList(4, 6, 9, 11));
    static int N = 0;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        for(int i=1; i<X; i++) {
            if (i == 2) N += 28;
            else if (day30.contains(i))  N += 30;
            else N += 31;
        }

        N += (Y-1);

        System.out.println(day[N%7]);

    }

}
