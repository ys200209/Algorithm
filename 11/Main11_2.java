import java.util.*;

class Main11_2 {
    static String s;
    static int[] list;
    static int result;

    public static void main(String[] args) {

        /*
            0-9�θ� �̷���� ���ڿ� S�� �־��� ��, ���ʺ��� ���������� �ϳ��� ��� ���ڸ� Ȯ���ϸ� ���� ���̿�
            'X' Ȥ�� '+'�� �־� ������� �� �ִ� ���� ū ���� ���ϴ� ���α׷��� �ۼ�
            15:48 -> 15:55 (30��)
        */
        
        Scanner sc = new Scanner(System.in);

        s = sc.next();

        list = new int[s.length()];

        for(int i=0; i<list.length; i++) {
            list[i] = s.charAt(i) - '0';
            
        } 

        result = list[0];
        for(int i=1; i<list.length; i++) {
            if(result == 0 || list[i] == 0 || result == 1 || list[i] == 1) {
                result += list[i];
            } else {
                result *= list[i];
            }
        }

        System.out.println("result = " + result);
    }

}
