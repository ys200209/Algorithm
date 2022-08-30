package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2_2747 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        arr[0] = 0;
        arr[1] = 1;

        fibo(N);

//        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println(arr[N]);
    }

    public static int fibo(int N) {
        if (N <= 1) return arr[N];

        if (arr[N] != 0) return arr[N];
        else return arr[N] = fibo(N-2) + fibo(N-1);
    }

}
