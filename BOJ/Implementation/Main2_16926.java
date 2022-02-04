import java.util.*;
import java.io.*;

public class Main2_16926 {
    static int N, M, R;
    static int[][] key, temp;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        key = new int[N][M];
        temp = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j=0;
            while(st.hasMoreTokens()) {
                key[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

        System.out.println("-------Before-------");
        for(int i=0; i<N; i++) {
            System.out.println(Arrays.toString(key[i]));
        }

        temp = rotateKey(key);
        System.out.println("-------After-------");
        for(int i=0; i<N; i++) {
            System.out.println(Arrays.toString(temp[i]));
        }

    }

    public static int[][] rotateKey(int[][] before) {
        int[][] after = new int[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                System.out.println("(" + i + ", " + j + ") = " + 
                        "(" + (i+((j+1)/M)) +", " + (j+1-((i+1)/M)) + ")");
                after[i][j] = before[i+1-((j+1)/M)][j+1-((i+1)/M)]; // (0, 0) = (0, 1), (0, 2) = (0, 3), (0, 3) = (1, 3)
            }
        }

        return after;
    }
}
