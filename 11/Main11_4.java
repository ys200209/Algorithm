import java.util.*;

class Main11_4 {
    static int N, coin, total, result;
    static int[] list;

    public static void main(String[] args) {

        /*
            N���� ������ ������ ���� ��, N���� ������ �̿��Ͽ� ���� �� ���� ���� ���� �ݾ� �� �ּڰ��� ���ϴ�
            ���α׷��� �ۼ��϶�.
            ex)
            N = 5�̰�, �� ������ 3��, 2��, 1��, 1��, 9���̶�� �����ϸ� ���� �� ���� �ݾ� �� �ּڰ��� 8���̴�.
            16:20 -> (30��)
        */

        Scanner scanner = new Scanner(System.in);

        total = 0;
        N = scanner.nextInt();
        list = new int[N];

        for(int i=0; i<N; i++) {
            list[i] = scanner.nextInt();
        }

        Arrays.sort(list);

        for(int i=0; i<N; i++) {
            coin = list[i];
            if (coin - total > 1) {
                result = total + 1;
                break;
            } else {
                total += coin;
            }
        }

        System.out.println(result);

    }
    
}
