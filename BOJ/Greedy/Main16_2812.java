import java.util.*;
import java.io.*;

public class Main16_2812 {
    static int N, K;
    static String[] number;
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        number = br.readLine().split("");
        
        int index=0;
        while(index < number.length) {
            if (stack.isEmpty() || K == 0) {
                stack.push(Integer.parseInt(number[index]));
                index++;
            } else {
                if (stack.peek() >= Integer.parseInt(number[index])) {
                    stack.push(Integer.parseInt(number[index]));
                    index++;
                } else {
                    stack.pop();
                    K--;
                    continue;
                }
            }
        }

        if (K > 0) {
            for(int i=0; i<K; i++) {
                stack.pop();
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.reverse());

    }

}