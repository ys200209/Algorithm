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

        MAX = A[A.length-1];

        binarySearch(M, 0, MAX);

        System.out.println(result);



    }

    public static void binarySearch(int target, int front, int back) {
        if (front > back) return;

        int mid = (front + back) / 2;
        slice = 0;
        for(int j=0; j<N; j++) {
            slice += A[j] - mid < 0 ? 0 : A[j] - mid;
        }

        if (target > slice) {
            binarySearch(target, front, mid-1);
        } else {
            result = mid;
            binarySearch(target, mid+1, back);
        }

    }

}