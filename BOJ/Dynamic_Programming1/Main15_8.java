import java.util.*;
import java.io.*;

public class Main15_8 {
    static int N;
    static int[] d;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        d = new int[N+1];

        TopDown(N);

        System.out.println(Arrays.toString(d));

        System.out.println(d[N]);

    }

    public static int TopDown(int index) {
        if (index == 1) return 0;

        if (d[index] == 0) {

            d[index] = TopDown(index-1)+1;
            
            if (index % 3 == 0) {
                d[index] = Math.min(d[index], TopDown(index/3)+1); // Math.min(d[index], );
            }
            if (index % 2 == 0) {
                d[index] = Math.min(d[index], TopDown(index/2)+1); //Math.min(d[index], );
            }

        }

        return d[index];
    }

}