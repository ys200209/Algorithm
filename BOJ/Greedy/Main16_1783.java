import java.util.*;
import java.io.*;

public class Main16_1783 {
    static int N, M, right_position=0, result=1;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if (N == 2) result = (M+1)/2 > 4 ? 4 : (M+1)/2;
        else if (N > 2) {
            if (M < 6) result = M > 4 ? 4 : M;
            else result = (M-6) + 4;
        }

        System.out.println(result);
    }

}
