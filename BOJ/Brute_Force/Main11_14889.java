import java.io.*;
import java.util.*;

public class Main11_14889 {
    static int N, result = (int) 1e9;
    static int a, b;
    static int[][] map;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int j=0;
            while(st.hasMoreTokens()) {
                map[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

        for(int i=0; i<N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }

        for(int i=0; i<N; i++) {
            for(int j=i+1; j<N; j++) {
                result = Math.min(result, map[i][j] + map[j][i]);
            }
        }

        System.out.println("result = " + result);

    }

}