import java.util.*;

public class Main4 {
    public static int total;
    

    public static void main(String[] args) {

        System.out.println(solution(new int[]{70, 50, 80, 50}, 100)); // 3
        System.out.println(solution(new int[]{70, 80, 50}, 100)); // 3
        System.out.println(solution(new int[]{1, 2, 3, 3, 4, 5}, 6)); // 3

    }

    public static int solution(int[] people, int limit) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<people.length; i++) {
            list.add(people[i]);
        }

        Collections.sort(list);

        int front = 0;
        int back = list.size()-1;

        while(true) {
            if (front < back) total = list.get(front) + list.get(back);
            else if (front == back) total = list.get(front);
            else return answer;
            
            if (total > limit) back -= 1;
            else {
                front += 1;
                back -= 1;
            }
            
            answer++;

        }

    }
    
}
