import java.util.*;

class Main11_4 {
    static int N, coin, total, result;
    static int[] list;

    public static void main(String[] args) {

        /*
            N개의 동전을 가지고 있을 때, N개의 동전을 이용하여 만들 수 없는 양의 정수 금액 중 최솟값을 구하는
            프로그램을 작성하라.
            ex)
            N = 5이고, 각 동전이 3원, 2원, 1원, 1원, 9원이라고 가정하면 만들 수 없는 금액 중 최솟값은 8원이다.
            16:20 -> (30분)
        */

        Scanner scanner = new Scanner(System.in);

        total = 0;
        N = scanner.nextInt();
        list = new int[N];

        for(int i=0; i<N; i++) {
            list[i] = scanner.nextInt();
        }

        Arrays.sort(list);

        for(int i=0; i<N; i++) {
            coin = list[i];
            if (coin - total > 1) {
                result = total + 1;
                break;
            } else {
                total += coin;
            }
        }

        System.out.println(result);

    }
    
}
