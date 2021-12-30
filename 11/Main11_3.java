import java.util.*;

class Main11_3 {
    static int answer = (int)1e9;
    static String S, str;

    public static void main(String[] args) {

        /*
            0�� 1�θ� �̷���� ���ڿ� S�� �ִ�. �� ���ڿ� S�� �ִ� ��� ���ڸ� ���� ���� ������� �� ��,
            ���ӵ� �ϳ� �̻��� ���ڸ� ��� ��� ������ ���̴�. ������ ���� 1�� 0����, 0�� 1�� �ٲٴ� ���� �ǹ��Ѵ�.
            ex) s = 0001100���� 0�� 1�� ���������� 1111100 ���� �ѹ�, 1111111�� �ι� �������� �ȴ�.
            �׷��� ó������ 0000000���� �ѹ����� ������ ���� �ִ�.
            �ּ� Ƚ���� ����Ͻÿ�.

        */

        Scanner scanner = new Scanner(System.in);

        S = scanner.nextLine();

        zeroToOne();
        oneToZero();

        System.out.println(answer);

    }

    public static void zeroToOne() {
        int result = 0;
        for(int i=1; i<S.length(); i++) {
            if (S.charAt(i-1) == S.charAt(i)) continue;
            else if (S.charAt(i-1)-'0' == 0 && S.charAt(i)-'0' == 1) {
                result += 1;
            }
        }

        if (S.charAt(S.length()-1) == 0) result += 1; 

        answer = Math.min(answer, result);
    }

    public static void oneToZero() {
        int result = 0;
        for(int i=1; i<S.length(); i++) {
            if (S.charAt(i-1) == S.charAt(i)) continue;
            else if ((S.charAt(i-1)-'0' == 1) && S.charAt(i)-'0' == 0) {
                result += 1;
            }
        }

        if (S.charAt(S.length()-1) == 1) result += 1; 

        answer = Math.min(answer, result);
    }

}
