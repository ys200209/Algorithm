import java.util.*;

public class Main11_6 {

    public static void main(String[] args) {

        System.out.println(solution(new int[]{3, 1, 2}, 5)); // 1
        System.out.println(solution(new int[]{1, 1, 1}, 4)); // -1
        System.out.println(solution(new int[]{2, 2, 2, 15, 2}, 13)); // 4
        System.out.println(solution(new int[]{5, 4, 3, 3, 2}, 12)); // 3
        System.out.println(solution(new int[]{10, 10, 11, 11, 12}, 53)); // 5

    }

    public static int solution(int[] food_times, long k) {
        Queue<Food> queue = new PriorityQueue<>();

        int answer = 0;
        long total = 0;

        for(int i=1; i<=food_times.length; i++) {
            queue.offer(new Food(i, food_times[i-1]));
            total += food_times[i-1];
        }

        if (total <= k) return -1;

        long size = queue.size();
        long minus = 0;

        while(!queue.isEmpty()) {
            // System.out.println("k = " + k);
            if (queue.peek().getTime() == minus) {
                size -= 1;
                queue.poll();
                continue;
            }
            if (size * (queue.peek().getTime() - minus) <= k) {
                k -= size * (queue.peek().getTime() - minus);
                size -= 1;
                minus = queue.poll().getTime();
            } else break;
        }
        // System.out.println("k = " + k);
        ArrayList<Food> arrayList = new ArrayList<>();
        while(!queue.isEmpty()) {
            arrayList.add(queue.poll());
        }

        Collections.sort(arrayList, (f1, f2) -> f1.getFoodNum() - f2.getFoodNum());

        
        k %= arrayList.size();
        
        answer = arrayList.get((int)k).getFoodNum();

        return answer;
    }
    
}

class Food implements Comparable<Food> {
    private int foodNum;
    private int time;

    public Food(int foodNum, int time) {
        this.foodNum = foodNum;
        this.time = time;
    }

    public int getFoodNum() {
        return this.foodNum;
    }

    public int getTime() {
        return this.time;
    }

    @Override
    public int compareTo(Food f1) {
        return this.time - f1.time;
    }

}
