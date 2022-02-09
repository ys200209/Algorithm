import java.util.*;
import java.io.*;

public class Main8_1 {
    static int A, B, C;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        if (B >= C) {
            System.out.println("-1");
            return;
        }

        System.out.println(A / (C - B) + 1);

    }
}