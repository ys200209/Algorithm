import java.io.*;
import java.util.*;

class Main23_7 {
    static int N, M, H;
    static int[][] box;
 
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        int j=0;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            box[i][j] = Integer.parseInt(st.nextToken());
            j++;
        }

        

    }

}