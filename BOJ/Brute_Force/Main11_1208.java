import java.util.*;
import java.io.*;

public class Main11_1208 {
    static int N, S, num=0;
    static int[] A;
    static boolean[] visited;
    static Map<Integer, Integer> map = new HashMap<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        A = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine(), " ");
        int i=0;
        while(st.hasMoreTokens()) {
            A[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        
        Arrays.sort(A);

        

    }

}
