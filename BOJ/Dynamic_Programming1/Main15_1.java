import java.util.*;
import java.io.*;

class Main15_1 {
    static int T, num;
    static int[][] d;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException  {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        d = new int[41][2];

        d[0][0] = 1;
        d[0][1] = 0;
        d[1][0] = 0;
        d[1][1] = 1;

        for(int i=0; i<T; i++) {
            num = Integer.parseInt(br.readLine());

            for(int j=2; j<=num; j++) {
                d[j][0] = d[j-2][0] + d[j-1][0];
                d[j][1] = d[j-2][1] + d[j-1][1];
            }
            sb.append(d[num][0] + " " + d[num][1] + "\n");
        }

        System.out.println(sb);
    }
}