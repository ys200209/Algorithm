import java.util.*;
import java.io.*;

public class Main20_3 {
    static int N, result1=0, result2=0, result3=0;
    static int[][] paper;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int j=0;
            while(st.hasMoreTokens()) {
                paper[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

        /*for(int i=0; i<N; i++) {
            System.out.println(Arrays.toString(paper[i]));
        }*/

        Divide(0, 0, N);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);

    }

    public static void Divide(int row, int column, int size) {
        if (checkEquals(row, column, size)) {

            if (paper[row][column] == -1) result1++;
            else if (paper[row][column] == 0) result2++;
            else result3++;

            return;
        }

        size /= 3;

        Divide(row, column, size);
        Divide(row, column+size, size);
        Divide(row, column+size*2, size);
        Divide(row+size, column, size);
        Divide(row+size, column+size, size);
        Divide(row+size, column+size*2, size);
        Divide(row+size*2, column, size);
        Divide(row+size*2, column+size, size);
        Divide(row+size*2, column+size*2, size);

    }
    
    public static boolean checkEquals(int row, int column, int size) {
        int number = paper[row][column];
        
        for(int i=row; i<row+size; i++) {
            for(int j=column; j<column+size; j++) {
                if (paper[i][j] != number) return false;
            }
        }
        return true;
    }

}