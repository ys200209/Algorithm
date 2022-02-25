import java.util.*;
import java.io.*;

public class Main_4158 {
    static int N, M, count;
    static int[] A;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) { // Hash로도 풀어보고 이진탐색으로도 풀어보자
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            count = 0;

            if (N==0 && M==0) break;
            
            A = new int[N];
            for(int i=0; i<N; i++) {
                A[i] = Integer.parseInt(br.readLine());
            }

            for(int i=0; i<M; i++) {
                binarySearch(Integer.parseInt(br.readLine()), 0, N-1);
            }
            sb.append(count + "\n");
        }

        System.out.println(sb);

    }
    
    public static void binarySearch(int target, int start, int end) {
        if (start > end) return;

        int mid = (start + end) / 2;

        if (A[mid] == target) {
            count++;
            return;
        } else if (A[mid] > target) {
            binarySearch(target, start, mid-1);
        } else {
            binarySearch(target, mid+1, end);
        }

    }

}