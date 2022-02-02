import java.util.*;
import java.io.*;

public class Main11_15686 {
    static int N, M, now, result=(int)1e9;
    static int[][] city;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        city = new int[N][N];
        visited = new boolean[N][N];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j=0;
            while(st.hasMoreTokens()) {
                city[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

        DFS(0);
        
        System.out.println(result);
    }
    
    public static void DFS(int count) {
        if (count == M) {
            int dis=0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if (city[i][j] == 1) {
                        now = (int) 1e9;
                        Street(i, j, 0);
                        dis += now;
                    }
                }
            }
            result = Math.min(result, dis);
            return;
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if (city[i][j] == 2) {
                    city[i][j] = 3;
                    DFS(count+1);
                    city[i][j] = 2;
                }
            }
        }
    }

    public static void Street(int row, int column, int distance) { // 치킨 거리 계산
        if (row < 0 || row >= N || column < 0 || column >= N) return;
        
        if (city[row][column] == 3) {
            now = Math.min(now, distance);
            return;
        }

        if (!visited[row][column]) {
            visited[row][column] = true;
            Street(row-1, column, distance+1);
            Street(row+1, column, distance+1);
            Street(row, column-1, distance+1);
            Street(row, column+1, distance+1);
            visited[row][column] = false;
        }
    }
}