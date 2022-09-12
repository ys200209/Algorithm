package BOJ.Back_Tracking;

import java.util.*;
import java.io.*;

public class Main14_1062 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        double MAX = Math.sqrt((Math.pow(W, 2) + Math.pow(H, 2)));

        for(int i=0; i<N; i++) {
            int len = Integer.parseInt(br.readLine());

            sb.append(len > MAX ? "NE\n" : "DA\n");
        }
        System.out.println(sb);
    }
}