import java.util.*;
import java.io.*;

public class Main15_8 {
    static int N;
    static Integer[] d;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        d = new Integer[N+1];
        d[1] = 0;

        TopDown(N);

        System.out.println(Arrays.toString(d));

        System.out.println(d[N]);

    }

    public static int TopDown(int index) {
        if (index == 1) return 0;

        if (d[index] == null) {
            
            if (index % 6 == 0) {
                d[index] = Math.min(TopDown(index-1), Math.min(TopDown(index/3), TopDown(index/2))) + 1;
            } else if (index % 3 == 0) {
                d[index] = Math.min(TopDown(index/3), TopDown(index-1)) + 1;
            } else if (index % 2 == 0) {
                d[index] = Math.min(TopDown(index/2), TopDown(index-1)) + 1;
            } else {
                d[index] = TopDown(index-1)+1;
            }

        }

        return d[index];
    }

}