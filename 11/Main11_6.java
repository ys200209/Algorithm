import java.util.*;

class Main11_6 {

    public static void main(String[] args) {

        /*
            평소에 식욕이 왕성한 무지는 자신의 재능을 뽐내기 위해 먹방 라이브 방송을 하기로 했다. 평범한 먹방과는 차별성을
            두기 위해 독특한 방식으로 먹방을 하기로 하였다.
            
            회전판에 먹어야 할 N개의 음식이 있으며 각 음식에는 1부터 N까지의 번호가 붙어있다. 각 음식을 섭취하는데 일정
            시간이 소요되며 다음과 같은 방법으로 음식을 섭취한다.

            1. 무지는 1번 음식부터 먹기 시작하며, 회전판은 번호가 증가하는 순서대로 음식을 무지 앞으로 가져다 놓습니다.
            2. 마지막 번호의 음식을 섭취한 후에는 회전판에 의해 다시 1번 음식이 무지 앞으로 옵니다.
            3. 무지는 음식 하나를 1초 동안 섭취한 후 남은 음식은 그대로 두고, 다음 음식을 섭취합니다.
            4. 회전판이 다음 음식을 무지 앞으로 가져오는 데 걸리는 시간은 없다고 가정한다.

            무지가 먹방을 시작한 지 K초 후에 네트워크 장애로 인해 방송이 잠시 중단되었다. 다시 방송을 이어갈 때,
            몇 번 음식부터 섭취해야 하는지를 알고자 한다. 

            각 음식을 모두 먹는 데 필요한 시간이 담겨있는 배열 food_times, 네트워크 장애가 발생한 시간 K초가
            매개변수로 주어질 때 몇번 음식부터 다시 섭취하면 되는지 return 하도록 solution 함수를 완성하세요.
            (만약 더 섭취해야 할 음식이 없다면 -1을 반환하면 됩니다.)
        */

        System.out.println(solution(new int[]{3, 1, 2}, 5));
        System.out.println(solution(new int[]{1, 1, 1, 1}, 4));
        System.out.println(solution(new int[]{7, 5, 4, 8, 3}, 20));
        System.out.println(solution(new int[]{7, 5, 4, 8, 3}, 300));
        System.out.println(solution(new int[]{2, 2, 2, 15, 2}, 12));
    }
    
    public static int solution(int[] food_times, long k) {
        long size = food_times.length;
        long total = 0;
        long extract = 0; 
        int result = -1;
        PriorityQueue<Food> pq = new PriorityQueue<>();

        for(int i=0; i<food_times.length; i++) {
            pq.offer(new Food(food_times[i], i+1));
            total += food_times[i];
        }

        if (total <= k) {
            return -1;
        }

        while( size * (pq.peek().getTime() - extract) <= k ) {
            k -= size * (pq.peek().getTime() - extract);
            extract = pq.peek().getTime();
            pq.poll();
            size -= 1;
        }

        ArrayList<Food> arrayList = new ArrayList<>();
        while( !pq.isEmpty() ) {
            arrayList.add(pq.poll());
        }

        Collections.sort(arrayList, new Comparator<Food>(){
            @Override
            public int compare(Food o1, Food o2) {
                return Integer.compare(o1.getNumber(), o2.getNumber());
            }
        });
        
        while( result == -1 ) {
            for(int i=0; i<arrayList.size(); i++) {
                if (k == 0 && arrayList.get(i).getTime() != 0) {
                    result = arrayList.get(i).getNumber();
                    break;
                }
    
                if (arrayList.get(i).getTime() != 0) {
                    k -= 1;
                }
            }
        }

        return result;
    }
    
}

class Food implements Comparable<Food>{
    private int time;
    private int index;

    public Food(int time, int index) {
        this.time = time;
        this.index = index;
    }

    public int getTime() {
        return this.time;
    }

    public int getNumber() {
        return this.index;
    }

    @Override
    public int compareTo(Food o) {
        return Integer.compare(this.time, o.time);
    }
}