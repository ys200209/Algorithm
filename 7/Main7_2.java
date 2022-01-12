import java.util.*;
import java.io.*;

class Main7_2 {
    static int N, M;
    static int[] A, B;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        /* 
            A�� ���� ���忡�� ��ǰ�� N�� �ִ�. �� ��ǰ�� ���� ������ ������ ��ȣ�� �ִ�. ��� �� �մ���
            M�� ������ ��ǰ�� �뷮���� �����ϰڴٸ� �������� ��û�ߴ�. A�� ���Կ� �մ��� ������ ��ǰ�� ��� �ִ���
            Ȯ���ϴ� ���α׷��� �ۼ��϶�.
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
        int i = 0;
        while(st.hasMoreTokens()) {
            A[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        Arrays.sort(A);

        M = Integer.parseInt(br.readLine());
        B = new int[M];

        st = new StringTokenizer(br.readLine(), " ");
        i = 0;
        while(st.hasMoreTokens()) {
            B[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        for(i=0; i<M; i++) {
            if (binarySearch(B[i], 0, (N-1) / 2, N-1)) sb.append("yes ");
            else sb.append("no ");
        }

        System.out.println(sb);
    }

    public static boolean binarySearch(int target, int front, int mid, int back) {
        if (front > back) return false;

        if (A[mid] == target) return true;
        else if (A[mid] > target) {
            back = mid-1;
            mid = (front + back) / 2;
            return binarySearch(target, front, mid, back);
        } else {
            front = mid+1;
            mid = (front + back) / 2;
            return binarySearch(target, front, mid, back);
        }

    }


}