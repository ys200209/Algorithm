import java.util.*;

class Main11_1 {
    static int N, index1, index2, result = 0;
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

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        list = new int[N];

        for(int i=0; i<N; i++) {
            list[i] = sc.nextInt();
        }
        Arrays.sort(list);

        index2 = index1 + list[index1] - 1;
        while(true) {
            if (index2 >= list.length) {
                break;
            }
            if (index2-index1+1 == list[index2]) {
                result++;
                if(index2 != list.length-1) { // �׷��� ���� ���� ������ �� ���Ҵٸ� index�� �ѱ�� ����.
                    index1 = index2+1;
                    index2 = index1 + list[index1] - 1;
                } else { // �׷��� �����µ� ������ �ο����� ��� index�� ���� �������� �ѱ� �� ���� ��.
                    break;
                }
            } else {
                index2++;
            }
        }
        System.out.println("result = " + result);
    }
    
}
