import java.util.*;

class ProgrammersTest3_3 {
    static List<Observer> list = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println(solution(10, new int[][]{{3, 4}, {5, 8}}, new int[][]{{2, 5}, {4, 3}}));

    }
    
    public static int solution(int distance, int[][] scope, int[][] times) {
        int answer = 0;

        // boolean[] warn = new boolean[distance+1];
        List<Integer> warn = new ArrayList<>();
        int now = 1;

        for(int i=0; i<scope.length; i++) {
            list.add(new Observer(scope[i][0], scope[i][1], times[i][0], times[i][1]));

            int[] arr = Arrays.sort(scope[i]);

            int observe =  times[i][0];
            int rest = times[i][1];

            int from = 0;
            int to = 0;

            if (arr[0] / (observe + rest) > 0) {
                from = arr[0] % (observe + rest);
                to = arr[1] % (observe + rest) == 0 ? scope[i][1] : scope[i][1] % (observe + rest);
            } else {
                from = scope[i][0];
                to = scope[i][1];
            }

            if (from >= observe) {
                list.add(new Observer(scope[i][0], scope[i][1], times[i][0], times[i][1]));
            }

        }

        while(true) {
            for(int i=0; i<list.size(); i++) {
                
            }

        }

        return answer;
    }
    
}

class Observer {

    int from;
    int to;
    int observe;
    int rest;

    public Observer(int from, int to, int observe, int rest) {
        this.from = from;
        this.to = to;
        this.observe = observe;
        this.rest = rest;
    }
}