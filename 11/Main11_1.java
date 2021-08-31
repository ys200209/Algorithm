import java.util.*;

class Main11_1 {
    static int N, count, index, value, fail;
    static int[] list;

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

        N = scanner.nextInt();
        list = new int[N];

        for(int i=0; i<N; i++) {
            list[i] = scanner.nextInt();
        }

        Arrays.sort(list);

        System.out.println("list = " + Arrays.toString(list));

        index = 0;
        fail = 0;

        while(true) {
            if (index >= N) break;
            value = list[index] + fail;
            if (index+value-1 >= N) break;
            
            if( list[index+value-1] <= value) {
                count++;
                index += value; // [1, 2, 2, 2, 3]
                fail = 0;
            } else {
                fail++;
            }
            
        }

        System.out.println(count);

    }
    
}
