import java.util.*;

class Main8_2 {
    static int X, count;

    public static void main(String[] args) {
        
        /*
        정수 X가 주어질 때 정수 X에 사용할 수 있는 연산은 다음과 같이 4가지이다.
        1. X가 5로 나누어떨어지면 5로 나눈다.
        2. X가 3으로 나누어떨어지면 3으로 나눈다.
        3. X가 2로 나누어떨어지면 2로 나눈다.
        4. X에서 1을 뺀다.
        */

        Scanner sc = new Scanner(System.in);
        X=sc.nextInt();
        TopDown(X);

        System.out.println("result = " + count);

    }

    // 재귀호출(TopDown 방식)
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
