import java.util.*;

class Main11_4 {
    static int N, result;
    static int[] list;

    public static void main(String[] args) {

        /*
            N���� ������ ������ ���� ��, N���� ������ �̿��Ͽ� ���� �� ���� ���� ���� �ݾ� �� �ּڰ��� ���ϴ�
            ���α׷��� �ۼ��϶�.
            ex)
            N = 5�̰�, �� ������ 3��, 2��, 1��, 1��, 9���̶�� �����ϸ� ���� �� ���� �ݾ� �� �ּڰ��� 8���̴�.
            16:20 -> (30��)
        */

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        list = new int[N];

        for(int i=0; i<N; i++) {
            list[i] = sc.nextInt();
        }

        Arrays.sort(list);

        for(int i=1; i<N; i++) {

        }

    }
    
}
