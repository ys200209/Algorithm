import java.util.*;
import java.io.*;

public class Main16_12904 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) {
            sb.append(i + "\n");
        }

        System.out.println(sb);
    }
}