import java.util.*;
import java.io.*;

public class Main15_14 {
    static String[] A, B;
    static int[][] d;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        A = br.readLine().split("");
        B = br.readLine().split("");

        d = new int[A.length+1][B.length+1];

        for(int i=1; i<=A.length; i++) {
            for(int j=1; j<=B.length; j++) {
                if (A[i-1].equals(B[j-1])) {
                    d[i][j] = d[i-1][j-1] + 1;
                } else {
                    d[i][j] = Math.max(d[i-1][j], d[i][j-1]);
                }
            }
        }

        /*for(int i=1; i<=A.length; i++) {
            System.out.println(Arrays.toString(d[i]));
        }*/

        System.out.println(d[A.length][B.length]);


    }

}