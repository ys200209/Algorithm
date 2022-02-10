import java.io.*;
import java.util.*;

public class Main8_8 {
    static int T, X, Y;
    static int[] dp;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());

            int dif = Y - X;
            dp = new int[dif+1];
            
            int j=0;
            int count = 0;
            int now = 0;
            while(now <= dif / 2) {
                if (now + (j+1) <= dif / 2) j++;
                count++;
                now += j;
                
            }
            count += (dif % 2);
            System.out.println("count : " + count + ", j : " + j + ", now : " + now + ", dif : " + dif);

        }

    }
}
