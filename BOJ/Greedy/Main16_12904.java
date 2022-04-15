import java.util.*;
import java.io.*;

public class Main16_12904 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int MIN=(int)1e9, MAX=-(int)1e9;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            MIN = Math.min(MIN, num);
            MAX = Math.max(MAX, num);
        }

        System.out.println(MIN + " " + MAX);
    }
}