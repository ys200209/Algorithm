import java.util.*;

public class Main2_3 {
    static Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) {

        // System.out.println(solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
        // 50
        // System.out.println(solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
        // 21
        System.out.println(solution(0, new String[]{"A", "B", "C", "D", "B", "C", "D"}));
        // 23
    
    }

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;

        for(int i=0; i<cities.length; i++) {
            if (queue.contains(cities[i].toUpperCase())) { // cache hit
                answer += 1;
                int size = queue.size();
                for(int j=0; j<size; j++) {
                    String city = queue.poll();
                    if (!city.equals(cities[i].toUpperCase())) queue.offer(city);
                }
                queue.offer(cities[i].toUpperCase());
            } else { // cache miss
                if (queue.size() >= cacheSize) queue.poll();

                if (queue.size() < cacheSize) queue.offer(cities[i].toUpperCase());

                answer += 5;
                
            }
        }

        return answer;
    }
    
}

class City implements Comparable<City> {

    private int rank;

    public City(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public int compareTo(City c1) {
        return this.getRank() - c1.getRank();
    }

}