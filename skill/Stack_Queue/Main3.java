package Stack_Queue;

import java.util.*;

public class Main3 {
    public static Queue<Integer> readyQueue = new LinkedList<>();
    public static Queue<Truck> truckQueue = new LinkedList<>();

    public static void main(String[] args) {

        System.out.println(solution(2, 10, new int[]{7,4,5,6})); // 8
        System.out.println(solution(100, 100, new int[]{10})); // 101 
        System.out.println(solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10})); // 110
        System.out.println(solution(10, 10, new int[]{1,1,1,1,1,1,1,1,1,1})); // 20
        System.out.println(solution(5, 5, new int[]{1,1,1,1,1})); // 10

    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;
        int size;
        readyQueue = new LinkedList<>();
        truckQueue = new LinkedList<>();

        for(int i=0; i<truck_weights.length; i++) {
            readyQueue.offer(truck_weights[i]);
        }

        do {
            sum = 0;
            answer++;
            size = truckQueue.size();

            // System.out.println(truckQueue.size());

            for(int i=0; i<size; i++) {
                Truck truck = truckQueue.poll();

                // System.out.println("truck.getCount() = " + (truck.getCount()+1));

                if (truck.getCount()+1 != bridge_length) { // 트럭이 다리를 아직 완전히 지나지 않았다면
                    truckQueue.offer(new Truck(truck.getTruckWeight(), truck.getCount()+1)); // count + 1
                    sum += truck.getTruckWeight(); // 다리의 무게를 측정하기 위함.
                } else { // 지났다면 그냥 트럭을 빼버린다. (큐에 안넣음)
                    // sum -= truck.getTruckWeight();
                }
                
            }

            // System.out.println("answer = " + answer + ", sum = " + sum + ", truckQueue.size() = " + truckQueue.size() + ", readyQueue.size() = " + readyQueue.size());
            
            if (!readyQueue.isEmpty() && sum+readyQueue.peek() <= weight) { 
                // 현재 다리의 무게와 새로 온 트럭의 무게합이 최대 무게보다 적다면
                // System.out.println("offer!");
                truckQueue.offer(new Truck(readyQueue.poll(), 0));
            }
            

            // System.out.println(" truckQueue.size() = " + truckQueue.size());


        } while(!truckQueue.isEmpty());


        return answer;
    }
    
}

class Truck {

    private int truckWeight;
    private int count;

    public Truck(int truckWeight, int count) {
        this.truckWeight = truckWeight;
        this.count = count;
    }

    public int getTruckWeight() {
        return truckWeight;
    }

    public int getCount() {
        return count;
    }

}