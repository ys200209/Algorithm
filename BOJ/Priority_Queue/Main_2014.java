package BOJ.Priority_Queue;

import java.util.*;
import java.io.*;

public class Main_2014 {
    static long num=1;
    static int K, N;
    static int[] A;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        A = new int[K];

        st = new StringTokenizer(br.readLine(), " ");
        int i=0;
        while(st.hasMoreTokens()) {
            A[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        DFS();

    }

    public static void DFS() {
        for(int i=0; i<K; i++) {
            
        }
    }

}
