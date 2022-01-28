import java.util.*;
import java.io.*;

public class Main11_2309 {
    static int sum=0;
    static int[] A;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        A = new int[9];
        for(int i=0; i<9; i++) {
            A[i] = Integer.parseInt(br.readLine());
            sum += A[i];
        }

        Arrays.sort(A);
        sum -= 100;

        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if (i == j) continue;

                if (A[i] + A[j] == sum) {
                    for(int k=0; k<9; k++) {
                        if (k != i && k != j) {
                            sb.append(A[k] + "\n");
                        }
                    }
                    System.out.println(sb);
                    return;
                }
            }
        }
    }   
}