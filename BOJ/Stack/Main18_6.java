import java.io.*;
import java.util.*;

class Main18_6 {
    static int N, result=-1;
    static Stack<Integer> stack = new Stack<>();
    static Queue<Integer> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()) {
            stack.push(Integer.parseInt(st.nextToken()));
        }

        while(!stack.isEmpty()) {
            int num = stack.pop();

            while(!queue.isEmpty()) {
                int n = queue.poll();
                result = num < n ? n : result;
            }
            queue.offer(num);

            if (num >= result) sb.insert(0, "-1 ");
            else sb.insert(0, result + " ");
        }
        System.out.println(sb);
    }
}