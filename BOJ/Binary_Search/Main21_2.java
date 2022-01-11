import java.util.*;
import java.io.*;

public class Main21_2 {
    static int MIN, MAX, N, M, high, low;
    static int[] A, B;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int i = 0;
        while(st.hasMoreTokens()) {
            A[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        M = Integer.parseInt(br.readLine());
        B = new int[M];

        st = new StringTokenizer(br.readLine(), " ");
        i = 0;
        while(st.hasMoreTokens()) {
            B[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        Arrays.sort(A);
        MIN = A[0];
        MAX = A[N-1];

        for(i=0; i<M; i++) {
            if (B[i] < MIN || B[i] > MAX) {
                sb.append("0 ");
                continue;
            }

            low = 0;
            high = 0;

            binarySearch(B[i], 0, (N-1)/2, N-1);

            System.out.println(B[i] + " : " + low + " ~ " + high);

            sb.append((high-low+1)+" ");
        }

        System.out.println(sb);
        
    }

    public static void binarySearch(int target, int front, int mid, int back) {
        System.out.println("target : " + target + ", front : " + front + ", mid : " + mid + ", back : " + back);
        
        if (mid <= front || mid >= back) {
            return;
        }

        if (A[mid] == target) {
            if (A[front] == target) low = front;
            else {
                low = mid;
                binarySearch(target, front, (front+mid)/2, mid);
            }
            
            if (A[back] == target) high = back;
            else {
                high = mid+1;
                binarySearch(target, mid, (mid+back)/2, back);
            }
            
            return;
        }

        

        if (A[mid] < target) {
            front = mid;
            mid = (front + back) / 2;
            binarySearch(target, front, mid, back);
        } else if (A[mid] > target) {
            back = mid;
            mid = (front + back) / 2;
            binarySearch(target, front, mid, back);
        }

    }

}