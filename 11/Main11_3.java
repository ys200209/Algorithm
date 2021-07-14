import java.util.*;

class Main11_3 {
    static String s;
    static int[] list;
    static int count0, count1 = 0;
    
    public static void main(String[] args) {

        /*
            0�� 1�θ� �̷���� ���ڿ� S�� �ִ�. �� ���ڿ� S�� �ִ� ��� ���ڸ� ���� ���� ������� �� ��,
            ���ӵ� �ϳ� �̻��� ���ڸ� ��� ��� ������ ���̴�. ������ ���� 1�� 0����, 0�� 1�� �ٲٴ� ���� �ǹ��Ѵ�.
            ex) s = 0001100���� 0�� 1�� ���������� 1111100 ���� �ѹ�, 1111111�� �ι� �������� �ȴ�.
            �׷��� ó������ 0000000���� �ѹ����� ������ ���� �ִ�.
            �ּ� Ƚ���� ����Ͻÿ�.

            16:05 -> 16:15
        */

        Scanner sc = new Scanner(System.in);

        s = sc.next();
        list = new int[s.length()];

        for(int i=0; i<list.length; i++) {
            list[i] = s.charAt(i) - '0';
        }
        
        if(list[0] == 0) {
            count1++;
        } else {
            count0++;
        }

        for(int i=0; i<list.length-1; i++) {
            if(list[i]==0 && list[i+1]==1) {
                count0++;
            } else if(list[i]==1 && list[i+1]==0) {
                count1++;
            }
        }
        System.out.println("count0 = " + count0 + ", count1 = " + count1);
        System.out.println("result = " + Math.min(count0, count1));

    }

}
