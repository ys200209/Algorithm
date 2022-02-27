import java.util.*;
import java.io.*;

public class Main16_2720 {
    static int T, C;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            C = Integer.parseInt(br.readLine());

            int Quarter = C / 25;
            C %= 25;
            int Dime = C / 10;
            C %= 10;
            int Nickel = C / 5;
            C %= 5;
            int Penny = C;

            sb.append(Quarter + " " + Dime + " " + Nickel + " " + Penny + "\n");
        }
        System.out.println(sb);
    }
}