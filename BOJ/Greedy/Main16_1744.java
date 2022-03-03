import java.util.*;
import java.io.*;

public class Main16_1744 {
    static long result=0;
    static int N;
    static boolean isZero;
    static Queue<Integer> minusQueue = new PriorityQueue<>();
    static Queue<Integer> plusQueue = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num < 0) minusQueue.offer(num);
            else if (num == 0) isZero = true;
            else plusQueue.offer(num);
        }
        
        while(minusQueue.size() > 1) {
            result += (minusQueue.poll() * minusQueue.poll());
        }
        if (!minusQueue.isEmpty()) { // 음수의 갯수가 홀수일때 result에 더하면 손해기 때문에
            if (!isZero) result += minusQueue.poll(); // 0이 존재하면 0을 곱해서 상쇄시킴 (해당 조건문은 0이 없을때.)
        }

        while(plusQueue.size() > 1) {
            int num1 = plusQueue.poll();
            int num2 = plusQueue.poll();
            if (num1 + num2 >= num1 * num2) {
                result += num1;
                plusQueue.offer(num2);
            } else {
                result += (num1 * num2);
            }
        }
        if (!plusQueue.isEmpty()) result += plusQueue.poll();
        
        System.out.println(result);
        
    }
}