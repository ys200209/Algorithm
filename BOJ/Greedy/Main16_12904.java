import java.util.*;
import java.io.*;

public class Main16_12904 {
    // static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = N;
        int count=0;

        while(true) {
            count++;

            if (result < 10) {
                result = result * 10 + result;
            } else {
                int A = result % 10;
                int B = ((result/10) + (result%10)) % 10;
                result = A * 10 + B;
            }

            if (result == N) break;
        }
        System.out.println(count);
    }
}