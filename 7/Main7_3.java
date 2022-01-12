import java.util.*;
import java.io.*;

class Main7_3 {
    static int N, M, MIN, MAX, slice, result=0;
    static int[] A;


    public static void main(String[] args) throws IOException {

        /*
            A�� ������ ��ϰ� ������ A�� ������ ���� ���̰� �������� �ʴ�. ��ſ� �� ���� �ȿ� ���� ����
            �� ���̴� ���ܱ�� �߶� �����ش�.
            ���ܱ⿡ ����(H)�� �����ϸ� �������� ���� �� ���� �����Ѵ�. ���̰� H���� �� ���� H ���� �κ��� �߸� ���̰�,
            ���� ���� �߸��� �ʴ´�.
            ���� ���̰� 19, 14, 10, 17cm�� ���� ������ �ְ� ���ܱ� ���̸� 15cm�� �����ϸ� �߸� ���� ���̴� ���ʴ��
            4, 0, 0, 2cm�̴�. �մ��� 6cm��ŭ�� ���̸� ��������.
            �մ��� ���� �� ��û�� �� ���̰� M�� �� ��� M��ŭ�� ���� ��� ���� ���ܱ⿡ ������ �� �ִ�
            ������ �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�
            ex)
            N = 4, M = 6 (1<= N <=1,000,000, 1<= M <=2,000,000,000)
            19 15 10 17
            -> 15
        */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        int i=0;
        while(st.hasMoreTokens()) {
            A[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        Arrays.sort(A);

        MIN = A[0];
        MAX = A[A.length-1];

        result = binarySearch(M, MIN, MAX);

        System.out.println("result = " + result);


    }

    public static int binarySearch(int target, int front, int back) {
        int mid = (front+back) / 2;

        if (front > back) return -1;
        
        slice = 0;
        System.out.println("mid : " + mid);
        for(int i=0; i<N; i++) {
            slice += A[i] - mid > 0 ? A[i] - mid : 0; 
        }
        System.out.println("slice : " + slice);

        if (slice < M) {
            return binarySearch(target, front, mid-1);
        } else if (slice > M) {
            result = slice;
            return binarySearch(target, mid+1, back);
        }
        
        else return mid;
    }


}