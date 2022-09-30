
import java.util.*;

public class Programmers {
    static int N;
    static boolean[] prime = new boolean[10000000];
    static boolean[] visited;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        System.out.println(solution("17"));
    }

    public static int solution(String numbers) {
        int answer = 0;
        N = numbers.length();
        visited = new boolean[numbers.length()];

        checkPrime();

        DFS(0, "0", numbers.split(""));

        for (int num : set) {
            if (!prime[num]) answer++;
        }

        return answer;
    }

    private static void checkPrime() {
        prime[0] = true;
        prime[1] = true;
        for(int i=2; i<prime.length; i++) {
            if (prime[i]) continue;
            for(int j=i*2; j<prime.length; j+=i) {
                prime[j] = true;
            }
        }
    }

    private static void DFS(int count, String now, String[] numbers) {
        set.add(Integer.parseInt(now));
        if (count == N) return;

        for(int i=0; i<N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                DFS(count+1, now + numbers[i], numbers);
                visited[i] = false;
            }
        }
    }

}
