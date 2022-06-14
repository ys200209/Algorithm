import java.util.*;
import java.io.*;

public class Main_6359 {
    static int T, N;
    static StringBuilder sb = new StringBuilder();
    static boolean[] list;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            N = Integer.parseInt(br.readLine());
            list = new boolean[N+1];

            if (N < 1) {
                sb.append("0\n");
                continue;
            }

            Arrays.fill(list, true);
            for(int i=2; i<=N; i++) {
                for(int j=i; j<=N; j+=i) {
                    list[j] = !list[j]; 
                }
            }

            sb.append(checkExit() + "\n");
        }

        System.out.println(sb);
    }

    public static int checkExit() {
        int count = 0;

        for(int i=1; i<=N; i++) {
            if (list[i]) count++;
        }

        return count;
    }

}