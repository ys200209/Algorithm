import java.util.*;
import java.io.*;

public class Main15_2 {
    public static int a, b, c;
    public static Integer[][][] d = new Integer[21][21][21];

    public static void main(String[] args) throws IOException {

        // 백준 온라인 저지 Dynamic_Programming(15)의 2번
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            c = scanner.nextInt();

            if (a == -1 && b == -1 && c == -1) return;
    
            System.out.println("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c));
        }
    }

    public static int w(int a, int b, int c) {

        if (a <= 0 || b <= 0 || c <= 0) return 1;

        else if (a > 20 || b > 20 || c > 20) return w(20, 20, 20);

        else if (a < b && b < c)  {
            
            return 
                (d[a][b][c-1] = d[a][b][c-1] != null ? d[a][b][c-1] : w(a, b, c-1)) + 
                (d[a][b-1][c-1] = d[a][b-1][c-1] != null ? d[a][b-1][c-1] : w(a, b-1, c-1)) - 
                (d[a][b-1][c] = d[a][b-1][c] != null ? d[a][b-1][c] : w(a, b-1, c));
        }
        else {
            return 
                (d[a-1][b][c] = d[a-1][b][c] != null ? d[a-1][b][c] : w(a-1, b, c)) + 
                (d[a-1][b-1][c] = d[a-1][b-1][c] != null ? d[a-1][b-1][c] : w(a-1, b-1, c)) + 
                (d[a-1][b][c-1] = d[a-1][b][c-1] != null ? d[a-1][b][c-1] : w(a-1, b, c-1)) - 
                (d[a-1][b-1][c-1] = d[a-1][b-1][c-1] != null ? d[a-1][b-1][c-1] : w(a-1, b-1, c-1));
        }
    }
}