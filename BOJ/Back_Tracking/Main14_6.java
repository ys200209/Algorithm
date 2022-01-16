import java.util.*;
import java.io.*;

public class Main14_6 {
    static boolean isSearch;
    static int[][] map = new int[10][10];
    static int[][] result = new int[9][9];
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=1; i<=9; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int j=1;
            while(st.hasMoreTokens()) {
                map[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

        for(int i=0; i<=9; i++) {
            // System.out.println(Arrays.toString(map[i]));
        }

        for(int i=1; i<=9; i++) {
            for(int j=1; j<=9; j++) {
                searchSquare(i, j);
            }
            break;
        }
        
        
        DFS(0);
        
        System.out.println("-----------[result]-----------");
        System.out.println(sb);
    }

    public static void DFS(int count) {
        if (count == 9) {
            for(int i=1; i<=9; i++) {
                for(int j=1; j<=9; j++) {
                    if (map[i][j] == 0) return;
                }
            }

            for(int i=1; i<=9; i++) {
                for(int j=1; j<=9; j++) {
                    sb.append(map[i][j] + " ");
                }
                sb.append("\n");
            }
            isSearch = true;
            return;
        }

        for(int i=1; i<=9; i++) {
            for(int j=1; j<=9; j++) {
                if (map[i][j] == 0) {
                    int index = searchRow(i, j); // 행 중에서 안나온 숫자를 서치한다.
                    // boolean[] row = searchRow(i, j); // 행 중에서 안나온 숫자를 서치한다.
                    boolean[] column = searchColumn(i); // 열 중에서 안나온 숫자를 서치한다.
                    boolean[] square = searchSquare(i, j); // 3 x 3 사각형에서 안나온 숫자를 서치한다.

                    if (index == 0) continue;

                    for(int k=1; k<=9; k++) {
                        if (!row[k] && !column[k] && !square[k]) {
                            map[i][j] = k;
                            row[k] = true;
                            column[k] = true;
                            square[k] = true;
                            count += 1;
                            DFS(count);
                            if (isSearch) return;
                            square[k] = false;
                            column[k] = false;
                            row[k] = false;
                            map[i][j] = 0;
                        }
                    }
                    
                }
            }
        }


    }

    public static int searchRow(int r, int c) {
        boolean[] row = new boolean[10];

        for(int i=1; i<=9; i++) {
            row[map[i][c]] = true;
        }

        for(int i=1; i<=9; i++) {
            if (!row[i]) {
                return searchColumn(i, c);
            }
        }
    }

    public static boolean[] searchColumn(int r, int c) {
        boolean[] column = new boolean[10];

        for(int i=1; i<=9; i++) {
            column[map[r][i]] = true;
        }

        for(int i=1; i<=9; i++) {
            if (!column[i]) {
                return searchSquare(r, i);
            }
        }
    }

    public static int searchSquare(int r, int c) {
        int index = 0;
        boolean[] square = new boolean[10];

        for(int i=(r-1)/3*3 + 1; i<=(r-1)/3*3 + 3; i++) {
            for(int j=(c-1)/3*3 + 1; j<=(c-1)/3*3 + 3; j++) {
                square[map[i][j]] = true;
            }
        }

        for(int i=1; i<=9; i++) {
            if (!square[i]) index = i;
        }

        // System.out.println("(" + r + ", " + c + ") = " + Arrays.toString(square));

        return index;
    }
}
