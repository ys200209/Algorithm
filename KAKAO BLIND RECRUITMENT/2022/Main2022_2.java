import java.util.*;

public class Main2022_2 {
    static boolean[] visited;

    public static void main(String[] args) {

        // K진수에서 소수 개수 구하기 (Level : 2)
        System.out.println(solution(437674, 3)); // 3 (211020101011)
        // System.out.println(solution(110011, 10)); // 2
        // System.out.println(solution(32, 2)); // 0
        // System.out.println(solution(1, 3)); // 0
        
    }

    public static int solution(int n, int k) {
        int answer = 0;

        String reverse = "";
        String str = "";

        while(n > 0) {
            reverse += (n % k);
            n /= k;
        }

        for(int i=reverse.length()-1; i>=0; i--) {
            str += reverse.substring(i, i+1);
        }

        ArrayList<Long> number = new ArrayList<>();
        for(String s : str.split("0")) {
            if (!"".equals(s.trim()) && Long.parseLong(s) != 1) {
                number.add(Long.parseLong(s));
            }
        }
        Collections.sort(number);

        if (number.isEmpty()) { 
            return 0;    
        }
        
        for(long num : number) {
            boolean ans = true;
            for(int i=2; i<Math.sqrt(num); i++) {
                if (num % i == 0) {
                    ans = false;
                    break;
                }
            }
            if (ans) answer++;
        }

        return answer;
    }
    
}