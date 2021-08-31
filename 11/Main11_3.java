import java.util.*;

class Main11_3 {
    static int zero, one, count;
    static String[] S;
    static String point;

    public static void main(String[] args) {

        /*
            0�� 1�θ� �̷���� ���ڿ� S�� �ִ�. �� ���ڿ� S�� �ִ� ��� ���ڸ� ���� ���� ������� �� ��,
            ���ӵ� �ϳ� �̻��� ���ڸ� ��� ��� ������ ���̴�. ������ ���� 1�� 0����, 0�� 1�� �ٲٴ� ���� �ǹ��Ѵ�.
            ex) s = 0001100���� 0�� 1�� ���������� 1111100 ���� �ѹ�, 1111111�� �ι� �������� �ȴ�.
            �׷��� ó������ 0000000���� �ѹ����� ������ ���� �ִ�.
            �ּ� Ƚ���� ����Ͻÿ�.

            16:05 -> 16:15 (20��)
        */

        Scanner scanner = new Scanner(System.in);

        S = scanner.next().split("");
        count = 0;
        point = S[0]; // "0" Or "1"

        for(int i=1; i<S.length; i++) {
            if ( point.equals("0") && S[i].equals("1") ) {
                point = "1";
                zero++;
            } else if (point.equals("1") && S[i].equals("0")) {
                point = "0";
                one++;
            }
        }

        System.out.println( zero >= one ? one : zero );
    }

}
