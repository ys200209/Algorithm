package BOJ.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11_1038 {
    static int N, count=-1;
    static long X=0, MAX=9876543210L;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        while(count < N) {
            count++;
            if (X > MAX) {
                System.out.println("-1");
                return;
            }

            isDecrease(X);
            if (count == N) break;

            X++;
//            System.out.println(count);
        }
        System.out.println(X);
    }

    private static boolean isDecrease(long num) {
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
            return false;
        }
        return true;
    }

}