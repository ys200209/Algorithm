import java.io.*;
import java.util.*;

public class Main15_11660 {
    static int N, M, x1, y1, x2, y2, result=0;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 
        map = new int[N+1][N+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int j=1;
            while(st.hasMoreTokens()) {
                map[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

        for(int t=0; t<M; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            result = 0;
            for(int i=x1; i<=x2; i++) {
                for(int j=y1; j<=y2; j++) {
                    result += map[i][j];
                }
            }
            sb.append(result + "\n");
        }

        System.out.println(sb);

    }
    
}
