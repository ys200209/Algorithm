import java.util.*;

import jdk.jshell.execution.FailOverExecutionControlProvider;

class Main11_1 {
    static int N, index1, index2, fail_Value, count = 0;
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
        // sc.nextLine();
    
        for(int i=0; i<N; i++) {
            list[i] = sc.nextInt();
        }

        Arrays.sort(list);

        System.out.println("list : " + Arrays.toString(list));
        System.out.println("index1 = "+index1+", index2 = "+index2+", fail_Value = "+fail_Value+", count = " + count);
        while(index1 < list.length && index2 < list.length) {
            index2 = index1 + list[index1] + fail_Value;
            System.out.println("index2 = " + index2);
            if(list[index1] == list[index2-1]) {
                count++;
                System.out.println("index1 = " + index1);
                index1 += list[index1];
                fail_Value=0;
            } else {
                fail_Value++;
            }

            
        }

        System.out.println("result = " + count);

    }
    
}
