import java.util.*;

class Main_Month_Challenge1_2 {
    static ArrayList<Integer> list = new ArrayList<>();
    
    public static void main(String[] args) {

        // System.out.println(solution(45)); // 7
        System.out.println(solution(125)); // 229

    }

    public static int solution(int n) {
        double answer = 0;

        while(n > 0) {
            list.add(n % 3);
            n /= 3;
        }

        for(int i=list.size()-1; i>=0; i--) {
            answer += (list.get(i) * Math.pow(3, (list.size() - i - 1)));
        }

        return (int)answer;
    }

}