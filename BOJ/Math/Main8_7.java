import java.io.*;
import java.util.*;

public class Main8_7 {
    static String[] A, B;
    static int[] result;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        A = st.nextToken().split("");
        B = st.nextToken().split("");
        result = new int[Math.max(A.length, B.length) + 1];

        int c = 0;
        int i;
        for(i=1; i<=Math.min(A.length, B.length); i++) {
            int num = Integer.parseInt(A[A.length-i]) + Integer.parseInt(B[B.length-i]) + c;
            result[result.length-i] = num % 10;
            c = num / 10;
            System.out.println("num : " + num);
        }
        System.out.println("c : " + c + ", i : " + i);

        int j;
        if (A.length > B.length) {
            for(j=i; j<=A.length; j++) {
                int num = Integer.parseInt(A[A.length-j]) + c;
                System.out.println("(1) num : " + num + ", c : " + c);
                result[result.length-j] = num % 10;
                c = num / 10;
            }

        } else {
            for(j=i; j<=B.length; j++) {
                int num = Integer.parseInt(B[B.length-j]) + c;
                result[result.length-j] = num % 10;
                c = num / 10;
            }
            // result[result.length-j] = c + Integer.parseInt(B[0]);
        }

        result[0] = c;
        
        String str = "";

        if (result[0] != 0) str += result[0];

        for(i=1; i<result.length; i++) {
            str += result[i];
        }

        System.out.println(str);

    }
}