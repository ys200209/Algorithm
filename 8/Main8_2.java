import java.util.*;

class Main8_2 {
    static int X, count;

    public static void main(String[] args) {
        
        /*
        ���� X�� �־��� �� ���� X�� ����� �� �ִ� ������ ������ ���� 4�����̴�.
        1. X�� 5�� ����������� 5�� ������.
        2. X�� 3���� ����������� 3���� ������.
        3. X�� 2�� ����������� 2�� ������.
        4. X���� 1�� ����.
        */

        Scanner sc = new Scanner(System.in);
        X=sc.nextInt();
        TopDown(X);

        System.out.println("result = " + count);

    }

    // ���ȣ��(TopDown ���)
    public static void TopDown(int num) {
        System.out.println("num = " + num);
        if(num == 1) {
            return;
        }

        if(num%5 == 0) {
            num /= 5;
            count += 1;
            TopDown(num);
        } else if(num%3 == 0) {
            num /= 3;
            count+=1;
            TopDown(num);
        } else if(num%2==0) {
            num/=2;
            count+=1;
            TopDown(num);
        } else {
            num-=1;
            count+=1;
            TopDown(num);
        }

        return;
    }

}
