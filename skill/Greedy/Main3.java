import java.util.*;

class Main3 {

    public static void main(String[] args) {

        /*
            � ���ڿ��� k���� ���� �������� �� ���� �� �ִ� ���� ū ���ڸ� ���Ϸ� �մϴ�. 
            ���� ���, ���� 1924���� �� �� ���� �����ϸ� [19, 12, 14, 92, 94, 24] �� ���� �� �ֽ��ϴ�. 
            �� �� ���� ū ���ڴ� 94 �Դϴ�. 
            ���ڿ� �������� ���� number�� ������ ���� ���� k�� solution �Լ��� �Ű������� �־����ϴ�. 
            number���� k ���� ���� �������� �� ���� �� �ִ� �� �� ���� ū ���ڸ� ���ڿ� ���·� return �ϵ��� 
            solution �Լ��� �ϼ��ϼ���. 
        */

        System.out.println(solution("1924", 2)); // "94"
        System.out.println(solution("1231234", 3)); // "3234"
        System.out.println(solution("4177252841", 4)); // "775841"
        System.out.println(solution("100050", 3)); // "150"

    }

    public static String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();

        int index=0;
        int max;
        for(int i=0; i<number.length() - k; i++) {
            max = 0;
            for(int j=index; j<=k + i; j++) {
                if (max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    index = j+1;
                }
            }
            sb.append(Integer.toString(max));
        }

        return sb.toString();
    }

}