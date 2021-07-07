import java.util.*;

class Main {
    // 2018년도 카카오 블라인드 코딩테스트 3번 문제
    public static void main(String[] args) {
        int result = solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"});
        System.out.println("result = " + result);

        result = solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"});
        System.out.println("result = " + result);

        result = solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"});
        System.out.println("result = " + result);

        result = solution(1, new String[]{"Seoul", "Jeju", "Jeju", "Seoul", "Seoul", "Seoul", "Jeju"});
        System.out.println("result = " + result);
    }

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> queue = new LinkedList<>();
        
        for (int i=0; i<cacheSize; i++) {
            if(queue.contains(cities[i].toLowerCase())) {
                queue.offer(cities[i].toLowerCase());
                answer++;
            } else {
                queue.offer(cities[i].toLowerCase());
                answer += 5;
            } 
        }

        for(int i=cacheSize; i<cities.length; i++) {
            //System.out.println("queue = " + queue + ", cities[i] = " + cities[i] + ", - " + answer);
            
            if(queue.contains(cities[i].toLowerCase())) {
                System.out.println("1. queue = " + queue);
                queue.remove(cities[i].toLowerCase());
                queue.offer(cities[i].toLowerCase());
                System.out.println("2. queue = " + queue);
                answer++;
            } else {
                queue.poll();
                queue.offer(cities[i].toLowerCase());
                answer += 5;
            }
        }
        return answer;
    }

}