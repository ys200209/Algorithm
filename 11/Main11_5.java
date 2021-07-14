import java.util.*;

class Main11_5 {
    static int N, M, result = 0;
    static int[] list;
    
    public static void main(String[] args) {

        /*
            A, B �� ����� ������ ġ�� �ֽ��ϴ�. �� ����� ���� ���԰� �ٸ� �������� ������ �Ѵ�.
            �������� �� N���� �ְ� �� ���������� ���԰� ���� �ְ�, ���� ��ȣ�� 1������ ������� �ο��ȴ�.
            ���� ������ ���� ���� �� ���� �� �ִ�.
            16:33 -> 16:38(30��)
        */

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        list = new int[N];

        for(int i=0; i<N; i++) {
            list[i] = sc.nextInt();
        }

        for(int i=0; i<N-1; i++) {
            for(int j=i+1; j<N; j++) {
                if(list[i] != list[j]) {
                    result++;
                }
            }
        }

        System.out.println("result = " + result);

    }

}
