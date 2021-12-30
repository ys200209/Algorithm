import java.util.*;

class Main11_1 {
    public static int N, result=0;
    public static int[] list;
    public static boolean[] visited;

    public static void main(String[] args) {
        /*
            ���谡�� N�� �ִ�. N���� ���谡�� ������� '������'�� �����ߴµ�, '������'�� ���� ���谡�� ���� ������ ����
            ���� ��Ȳ���� ����� ��ó�� �ɷ��� ��������. �������� �����ϰ� �����ϰ��� 
            �������� X�� ���谡�� �ݵ�� X�� �̻����� ������ �׷쿡 �����ؾ� �Ѵٰ� �����ߴ�. 
            N���� ���谡�� ���� ������ �־����� ��, �ִ� �� ���� �׷��� ���� �� �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
            ex)
            N = 5�� ��
            �������� 2 3 1 2 2��� �ִ� 2���� �׷��� ���� �� �ִ�.
        */

        Scanner scanner = new Scanner(System.in);
/*

5
2 3 1 2 2

*/
        N = scanner.nextInt();
        list = new int[N];
        visited = new boolean[N];

        for(int i=0; i<N; i++) {
            list[i] = scanner.nextInt();
        }

        Arrays.sort(list);

        int number = 0;
        int index = 0;

        // System.out.println(Arrays.toString(list));

        for(int i=0; i<N; i++) {
            number = list[index];
            if (list[index + number - 1] <= number) {
                index += number;
                result += 1;
            }
        }

        System.out.println(result);

    


    }
    
}
