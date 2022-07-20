import java.util.*;
import java.io.*;

public class Main14_10610 {
    static String[] N;
    static Stack<String> stack = new Stack<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.readLine().split("");

        Arrays.sort(N, (s1, s2) -> {
            return s2.compareTo(s1);
        });

        for(int i=N.length-1; i>N.length-4; i--) {
            if (i < 0) break;
            stack.push(N[i]);
        }
        
        String strNum = "";
        while(!stack.isEmpty()) {
            strNum += stack.pop();
        }
        
        int intNum = Integer.parseInt(strNum);

        if (intNum % 30 == 0) {
            StringBuilder sb = new StringBuilder();

            for(int i=0; i<N.length; i++) {
                sb.append(N[i]);
            }
            System.out.println(sb);
        }
        else System.out.println("-1");
    }
}
