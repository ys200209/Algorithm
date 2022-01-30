import java.util.*;

public class Main16_16953 {
    static long A, B, result=0;
    static Queue<Number> pq = new PriorityQueue<>();
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        A = scanner.nextInt();
        B = scanner.nextInt();

        pq.offer(new Number(A, 1));

        while(!pq.isEmpty()) {
            Number number = pq.poll();

            long x = number.getNum()*2;
            long y = Long.parseLong(Long.toString(number.getNum())+1);

            if (x == B || y == B) {
                result = number.getCount();
                break;
            }

            if (x < B) pq.offer(new Number(x, number.getCount()+1));
            if (y < B) pq.offer(new Number(y, number.getCount()+1));
        }

        if (result == 0) System.out.println("-1");
        else System.out.println(result+1);


    }
}

class Number implements Comparable<Number> {

    private long num;
    private int count;

    public Number(long num, int count) {
        this.num = num;
        this.count = count;
    }

    public long getNum() {
        return num;
    }

    public int getCount() {
        return count;
    }

    @Override
    public int compareTo(Number n1) {
        if (this.getNum() < n1.getNum()) {
            return -1;
        }
        return 1;
    }

}