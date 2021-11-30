import java.util.*;

public class Main1 {
    public static Queue<Item> queue = new LinkedList<>();
    public static Stack<Item> stack = new Stack<>();
    public static String command;
    public static int price, count, queue_sum=0, stack_sum=0;

    public static void main(String[] args) {

        System.out.println(solution(new String[]{"P 300 6", "P 500 3", "S 1000 4", "P 600 2", "S 1200 1"})); // [1500, 2400]

    }

    public static int[] solution(String[] record) {
        int[] answer = new int[2];

        for(int i=0; i<record.length; i++) {
            command = record[i].split(" ")[0];
            price = Integer.parseInt(record[i].split(" ")[1]);
            count = Integer.parseInt(record[i].split(" ")[2]);

            if (command.equals("P")) {
                for(int k=0; k<count; k++) {
                    queue.offer(new Item(price, count));
                    stack.push(new Item(price, count));
                }
                

            } else { // "S"
                for(int j=0; j<count; j++) {
                    queue_sum += queue.poll().getPrice();
                    stack_sum += stack.pop().getPrice();
                }
            }
        }
        answer[0] = queue_sum;
        answer[1] = stack_sum;

        return answer;
    }
}

class Item {
    public int price;
    public int count;

    public Item(int price, int count) {
        this.price = price;
        this.count = count;
    }

    public int getPrice() {
        return this.price;
    }

    public int getCount() {
        return this.count;
    }
}