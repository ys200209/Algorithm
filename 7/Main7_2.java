import java.util.*;
import java.io.*;

class Main7_2 {
    static int N, M;
    static int[] A, B;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        /* 
            A의 전자 매장에는 부품이 N개 있다. 각 부품은 정수 형태의 고유한 번호가 있다. 어느 날 손님이
            M개 종류의 부품을 대량으로 구매하겠다며 견적서를 요청했다. A의 가게에 손님이 문의한 부품이 모두 있는지
            확인하는 프로그램을 작성하라.
            ex) 
            N = 5
            [8, 3, 7, 9, 2]
            M = 3
            [5, 7, 9]
            -> no yes yes
        */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int i=0;
        while(st.hasMoreTokens()) {
            A[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        M = Integer.parseInt(br.readLine());
        B = new int[M];
        
        st = new StringTokenizer(br.readLine(), " ");

        i=0;
        while(st.hasMoreTokens()) {
            B[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        for(i=0; i<M; i++) {
            if (binarySearch(B[i], 0, N-1)) sb.append("yes ");
            else sb.append("no ");
        }

        System.out.println(sb);
        
    }

    public static boolean binarySearch(int target, int front, int back) {
        if (front > back) return false;

        int mid = (front + back) / 2;

        if (A[mid] > target) {
            return binarySearch(target, front, mid-1);
        } else if (A[mid] < target) {
            return binarySearch(target, mid+1, back);
        } else {
            return true;
        }
    }

}