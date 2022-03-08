import java.util.*;
import java.io.*;

public class Main20_1074 {
    static int N, R, C, count=0;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = (int)Math.pow(2, Integer.parseInt(st.nextToken()));
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        Divide(0, 0, N);

        System.out.println(count);
    }

    public static void Divide(int row, int column, int size) {
        if (row == R && column == C) return;

        size /= 2;

        if (row+size > R && column+size > C) Divide(row, column, size);
        else if (row+size > R && column + (size*2) > C) {
            count += size*size;
            Divide(row, column+size, size);
        }
        else if (row+(size*2) > R && column + size > C) {
            count += (size+size)*size;
            Divide(row+size, column, size);
        }
        else {
            count += ((size+size)*size + (size*size));
            Divide(row+size, column+size, size);
        }
    }
}