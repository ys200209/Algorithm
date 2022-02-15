import java.io.*;
import java.util.*;

public class Main26_3 {
    static int N, S, sum=0, result=(int)1e9;
    static int[] A;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        A = new int[N+1];

        int i=0;
        st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreElements()) {
            A[i] = Integer.parseInt(st.nextToken());
            sum += A[i];
            i++;
        }

        if (sum < S) {
            System.out.println("0");
            return;
        }

        int start = 0;
        int end = 0;
        sum = 0;

        while(start <= N && end <= N) {
            if (sum >= S) {
                result = Math.min(result, end-start);
                sum -= A[start++];
            } else {
                sum += A[end++];
            }
            System.out.println(start + " ~ " + end);
        }   

        System.out.println(result);

    }

}