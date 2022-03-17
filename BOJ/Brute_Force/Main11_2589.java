import java.util.*;
import java.io.*;

public class Main11_2589 {
    static int N, M;
    static String[][] map;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new String[N][M];

        for(int i=0; i<N; i++) {
            map[i] = br.readLine().split("");
        }
        
        


    }

}
