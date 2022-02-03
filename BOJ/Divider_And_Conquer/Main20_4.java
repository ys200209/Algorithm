import java.util.*;
import java.io.*;

public class Main20_4 {
    static int A, B, C, result;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        result = A;
        for(int i=0; i<B; i++) {
            result = (result * A) % C;
        }

        System.out.println(result);
    }
}