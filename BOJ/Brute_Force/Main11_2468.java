import java.util.*;
import java.io.*;

public class Main11_2468 {
    static int N, MAX=0, result=1;
    static int[][] map;
    static boolean[][] temp;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int j=0;
            while(st.hasMoreTokens()) {
                map[i][j] = Integer.parseInt(st.nextToken());
                MAX = Math.max(MAX, map[i][j]);
                j++;
            }
        }

        for(int k=0; k<MAX; k++) {
            int count=0;
            temp = new boolean[N][N];
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if (map[i][j] <= k) temp[i][j] = true;
                }
            }

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if (!temp[i][j]) {
                        DFS(i, j);
                        count++;
                    }
                }
            }

            result = Math.max(result, count);
        }

        System.out.println(result);

    }

    public static void DFS(int row, int column) {
        if (row < 0 || row >= N || column < 0 || column >= N) return;

        if (temp[row][column]) return;

        temp[row][column] = true;
        DFS(row-1, column);
        DFS(row+1, column);
        DFS(row, column-1);
        DFS(row, column+1);

    }

}