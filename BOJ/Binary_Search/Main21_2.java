import java.util.*;
import java.io.*;

public class Main21_2 {
    static int MIN, MAX, N, M, count=0;
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

            binarySearch(B[i], 0, N/2, N-1);

            sb.append(count+" ");
            count = 0;
        }

        System.out.println(sb);
        
    }

    public static void binarySearch(int target, int front, int mid, int back) {
        if (front == mid || back == mid) {
            if (!visited[front] && A[front] == target) {
                visited[front] = true;
                count += 1;
            } else if (!visited[back] && A[back] == target) {
                visited[back] = true;
                count += 1;
            }
            return;
        }
        

        if (mid < 0 || mid >= N || visited[mid] ) return;

        if (A[mid] < target) {
            front = mid;
            mid = (front + back) / 2;
            binarySearch(target, front, mid, back);
        } else if (A[mid] > target) {
            back = mid;
            mid = (front + back) / 2;
            binarySearch(target, front, mid, back);
        } else {
            count += 1;
            visited[mid] = true;
            binarySearch(target, front, mid-1, back);
            binarySearch(target, front, mid+1, back);
            visited[mid] = false;
            visited[front] = false;
            visited[back] = false;
        }
    }

}