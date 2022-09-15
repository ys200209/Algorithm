package BOJ.Brute_Force;

import java.io.*;

public class Main11_1038 {
    static int N, count=0;
    static long X=0, MAX=9876543210L;
    static boolean isMax=false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        while(count < N) {
//            System.out.println();
            count++;
            X++;
            isDecrease(X);
//            System.out.println("count = " + count);
            System.out.println("number : " + X);
            System.out.println("count = " + count);


//            if (count == N) break;

//            System.out.println("number : " + X);

//            System.out.println(count);
        }
//        System.out.println("--------------");
        System.out.println(isMax ? "-1" : X);
    }

    private static void isDecrease(long num) {
        if (X > MAX) {
            isMax = true;
            return;
        }

//        System.out.println("num = " + num);
        long mod = num % 10;
        int maxDivCount = 0;
        int divCount = 0;
        boolean mustNewX = false;
        while(num >= 10) {
            num /= 10;
            divCount++;

            if (num % 10 <= mod) {
                mustNewX = true;
                maxDivCount = Math.max(maxDivCount, divCount);
            }
            mod = num%10;
        }

        if (mustNewX) {
            long newX = (((long)(X / Math.pow(10, maxDivCount))+1) * (long)(Math.pow(10, maxDivCount)));
//            System.out.println("newX = " + newX);
            X = newX;
            isDecrease(X); // 변경한 값이 '감소하는 수' 인지 재귀호출 검증
            // ex) 333 -> (327 : 8321) (328 : 8330) <- ??? 8330은 감소하는 수가 아니다.
        }
    }

}