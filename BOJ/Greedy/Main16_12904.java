import java.util.*;
import java.io.*;

public class Main16_12904 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            for(int j=1; j<=N-i-1; j++) {
                sb.append(" ");
            }

            for(int j=0; j<=i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}