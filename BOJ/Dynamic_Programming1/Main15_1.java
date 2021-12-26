import java.util.*;
import java.io.*;

class Main15_1 {
    public static Integer[][] d = new Integer[41][2];
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        // 백준 온라인 저지 Dynamic_Programming(15)의 1번
        d[0][0] = 1;
        d[0][1] = 0;
        d[1][0] = 0;
        d[1][1] = 1;

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            int number = Integer.parseInt(br.readLine());
            if (d[number][0] == null) {
                for(int j=2; j<=number; j++) {
                    d[j][0] = d[j-2][0] + d[j-1][0];
                    d[j][1] = d[j-2][1] + d[j-1][1];
                }
            }
            sb.append(d[number][0] + " " + d[number][1] + "\n");
        }
        System.out.println(sb);
    }
    
}
