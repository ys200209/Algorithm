import java.util.*;
import java.io.*;

public class Main16_12904 {
    static int N, X;
    static int[] list;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        list = new int[N+1];

        st = new StringTokenizer(br.readLine(), " ");
        int i=1;
        while(st.hasMoreTokens()) {
            list[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        binarySearch(1, N);

        System.out.println(sb);
    }

    public static void binarySearch(int start, int end) {
        if (start >= end) return;

        int mid = (start + end) / 2;

        binarySearch(start, mid);

        if (list[mid] < X) sb.append(list[mid] + " ");
        
        binarySearch(mid+1, end);

        
    }

}