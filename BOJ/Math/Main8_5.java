import java.io.*;
import java.util.*;

public class Main8_5 {
    static int T, H, W, N;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            int num1 = N % H == 0 ? N / H : N / H + 1;
            int num2 = N % H == 0 ? H : N % H;

            if (num1 < 10) sb.append(num2 + "0" + num1 + "\n");
            else sb.append(num2 + "" + num1 + "\n");

        }

        System.out.println(sb);

    }
}