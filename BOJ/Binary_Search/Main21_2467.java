import java.util.*;
import java.io.*;

public class Main21_2467 {
    static int gap = 2000000001;
    static int N, center, resultA, resultB, front, back;
    static int[] A;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int i=0;
        while(st.hasMoreTokens()) {
            A[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        /*binarySearch(0, N-1);

        System.out.println("center : " + center + ", gap : " + gap);



        if (A[center] > 0) {
            front = center-1;
            back = center;
        } else {
            front = center;
            back = center+1;
        }*/

        front = 0;
        back = N-1;
        while(front < back) {
            if (Math.abs(A[front] + A[back]) < Math.abs(gap)) {
                gap = A[front] + A[back];
                resultA = A[front];
                resultB = A[back];

                if (gap == 0) break;
            }

            if (Math.abs(A[front+1] + A[back]) < Math.abs(A[front] + A[back-1])) front++;
            else back--;
        }

        System.out.println(resultA + "\n" + resultB);
    }

    public static void binarySearch(int start, int end) {
        if (start >= end) {
            if (Math.abs(A[start]) < gap) {
                gap = Math.abs(A[start]);
                center = start;
            }
            return;
        }

        int mid = (start + end) / 2;
        binarySearch(start, mid);
        binarySearch(mid+1, end);
    }

}
