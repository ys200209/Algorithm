import java.util.*;
import java.io.*;

public class Main_ICPC_2 {
    static int N, index=0, MAX=0;
    static int[][] score;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        score = new int[N+1][4];
        check = new boolean[N+1];

        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int X = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            score[X][0] = A;
            score[X][1] = B;
            score[X][2] = C;
            score[X][3] = D;

        }

        for(int i=0; i<4; i++) {
            index=200001;
            MAX=0;
            for(int j=1; j<=N; j++) {
                if (!check[j] && MAX < score[j][i]) {
                    MAX = score[j][i];
                    index = j;
                } else if (!check[j] && MAX == score[j][i]) {
                    index = Math.min(index, j);
                }
            }
            check[index] = true;
            sb.append(index + " ");
        }

        System.out.println(sb);

    }

}