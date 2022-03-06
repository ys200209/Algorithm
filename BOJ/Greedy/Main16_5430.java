import java.util.*;
import java.io.*;

public class Main16_5430 {
    static int T, N;
    static String P;
    static Deque<String> deque;
    static StringBuilder sb = new StringBuilder();
    static boolean isReverse = false;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            deque = new ArrayDeque<>();
            P = br.readLine();
            N = Integer.parseInt(br.readLine());
            String X = br.readLine();
            String[] str = X.substring(1, X.length()-1).split(",");
            
            for(String num : str) {
                deque.add(num);
            }

            AC(P, deque);

        }
        System.out.println(sb);
    }

    public static void AC(String command, Deque<String> dq) {
        isReverse = false;
        for(int i=0; i<P.length(); i++) {
            if (P.charAt(i) - 'R' == 0) {
                isReverse = !isReverse;
            } else {
                if (isReverse) {
                    if (dq.peekLast() == null || dq.pollLast().equals("")) {
                        sb.append("error\n");
                        return;
                    }
                } else {
                    if (dq.peekFirst() == null || dq.pollFirst().equals("")) {
                        sb.append("error\n");
                        return;
                    }
                }
            }
        }
        makeString();
    }

    public static void makeString() {
        sb.append('[');
        if (deque.size() > 0) {
            if (isReverse) {
                sb.append(deque.pollLast());
                while(!deque.isEmpty()) {
                    sb.append(',').append(deque.pollLast());
                }
            } else {
                sb.append(deque.pollFirst());
                while(!deque.isEmpty()) {
                    sb.append(',').append(deque.pollFirst());
                }
            }
        }
        sb.append(']').append('\n');
    }
}