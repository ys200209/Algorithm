package BOJ.Brute_Force;

import java.io.*;
import java.util.*;

public class Main11_1436 {
    static int N, count=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        /*front();

        System.out.println("frontIndex : " + frontIndex + ", backIndex : " + backIndex);
        System.out.println("frontNumber : " + frontNumber + ", backNumber : " + backNumber);*/

        long index = 666;
        while(true) {
            while(!String.valueOf(index).contains("666")) {
                index++;
            }
            count++;
            if (count == N) {
                System.out.println(index);
                return;
            }
            index++;
        }
    }

    /*public static void front() {
        if (count >= N) return;

        System.out.println("FRONT");
        long nextBackNumber = Long.parseLong(D + (backIndex+1));

        while(nextBackNumber > Long.parseLong((frontIndex+1) + D)) {
            if (count >= N) {
                frontNumber = Long.parseLong(frontIndex + D);
                return;
            }

            frontIndex++;
            count++;
        }

        frontNumber = Long.parseLong(frontIndex + D);
        back();
    }

    public static void back() {
        if (count >= N) return;

        System.out.println("BACK");
        long nextFrontNumber = Long.parseLong((frontIndex+1) + D);

        while(nextFrontNumber >= Long.parseLong(D + (backIndex+1))) {
            if (count >= N) {
                backNumber = Long.parseLong(D + backIndex);
                return;
            }

            backIndex++;
            count++;
        }

        backNumber = Long.parseLong(D + backIndex);
        front();
    }*/

}