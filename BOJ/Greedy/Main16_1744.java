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
        if (!minusQueue.isEmpty()) { // ������ ������ Ȧ���϶� result�� ���ϸ� ���ر� ������
            if (!isZero) result += minusQueue.poll(); // 0�� �����ϸ� 0�� ���ؼ� ����Ŵ (�ش� ���ǹ��� 0�� ������.)
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