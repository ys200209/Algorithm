import java.util.*;
import java.io.*;

public class Main7_17413 {
    static StringBuilder sb = new StringBuilder();
    static Stack<String> stack = new Stack<>();
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] S = br.readLine().split("");

        boolean isReverse = true;
        for(int i=0; i<S.length; i++) {
            if (S[i].equals("<")) {
                getString();
                isReverse = false;
                sb.append(S[i]);
                continue;
            } else if (S[i].equals(">")) {
                isReverse = true;
                sb.append(S[i]);
                continue;
            } else if (S[i].equals(" ")) {
                getString();
                sb.append(S[i]);
                continue;
            }

            if (isReverse) stack.push(S[i]);
            else sb.append(S[i]);

            
        }

        getString();

        System.out.println(sb);
    }

    public static void getString() {
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
    }

}