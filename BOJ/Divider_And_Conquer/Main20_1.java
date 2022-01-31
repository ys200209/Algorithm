import java.util.*;
import java.io.*;

public class Main20_1 {
    static int N, white=0, blue=0;
    static int[][] paper;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Scanner와 BufferedRedaer의 차이 확인하기

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

        Divide(0, 0, N);

        System.out.println(white);
        System.out.println(blue);


    }
    
    public static void Divide(int row, int column, int size) {
        if (checkColor(row, column, size)) {
            if (paper[row][column] == 0) white++;
            else blue++;
            
            return;
        }

        size /= 2;
        Divide(row, column, size);
        Divide(row, column+size, size);
        Divide(row+size, column, size);
        Divide(row+size, column+size, size);
    }

    public static boolean checkColor(int row, int column, int size) {
        int color = paper[row][column];

        for(int i=row; i<row+size; i++) {
            for(int j=column; j<column+size; j++) {
                if (paper[i][j] != color) return false;
            }
        }

        return true;
    }
}
