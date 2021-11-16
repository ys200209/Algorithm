import java.util.*;

class Main8_2 {
    public static int[] d = new int[30001];

    public static void main(String[] args) {
        
        /*
        정수 X가 주어질 때 정수 X에 사용할 수 있는 연산은 다음과 같이 4가지이다.
        1. X가 5로 나누어떨어지면 5로 나눈다.
        2. X가 3으로 나누어떨어지면 3으로 나눈다.
        3. X가 2로 나누어떨어지면 2로 나눈다.
        4. X에서 1을 뺀다.
        */

        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        // 다이나믹 프로그래밍(Dynamic Programming) 진행(보텀업)
        for (int i = 2; i <= x; i++) {
            // 현재의 수에서 1을 빼는 경우
            d[i] = d[i - 1] + 1;
            // 현재의 수가 2로 나누어 떨어지는 경우
            if (i % 2 == 0)
                d[i] = Math.min(d[i], d[i / 2] + 1);
            // 현재의 수가 3으로 나누어 떨어지는 경우
            if (i % 3 == 0)
                d[i] = Math.min(d[i], d[i / 3] + 1);
            // 현재의 수가 5로 나누어 떨어지는 경우
            if (i % 5 == 0)
                d[i] = Math.min(d[i], d[i / 5] + 1);
            System.out.println("i = "+i+", d["+i+"] = "+d[i]);
        }

        System.out.println(d[x]);   
        
    }

}
