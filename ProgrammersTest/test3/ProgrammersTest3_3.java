import java.util.*;

class ProgrammersTest3_3 {

    public static void main(String[] args) {

        // System.out.println(solution(10, new int[][]{{3, 4}, {5, 8}}, 
        // new int[][]{{2, 5}, {4, 3}})); // 8

        System.out.println(solution(12, new int[][]{{7, 8}, {4, 6}, {11, 10}}, 
        new int[][]{{2, 2}, {2, 4}, {3, 3}})); // 12
        
    }
    
    public static int solution(int distance, int[][] scope, int[][] times) {
        int answer = (int)1e9;

        for(int i=0; i<scope.length; i++) {
            int[] arr = scope[i];
            int[] time = times[i];
            Arrays.sort(arr);
            Arrays.sort(time);
            int work = time[0];
            int rest = time[1];
            int gap = work + rest;

            int div = arr[0] / gap;
            int from = div == 0 ? arr[0] : arr[0] - (gap * div);
            int to = div == 0 ? arr[1] : arr[1] - (gap * div);
            
            if (from <= work) {
                int start = Math.max(arr[0], (div*gap)+1);
                answer = Math.min(answer, start);
                continue;
            }

            // [4, 13]
            // [2, 3]
            // 6

            if (to / gap > 0 && to % gap <= work/* && to % gap != 0 */) {
                int start = gap+1;
                while(start >= from) {
                    start += gap;
                }
                
                if (start > to) continue;

                answer = Math.min(answer, start);
                System.out.println("2 : start : " + start);
                continue;
            }
            // System.out.println("from : " + from + ", to : " + to + ", (" + work + " ~ " + rest + ")");
        }

        // System.out.println(Arrays.toString(observe));

        return answer == (int)1e9 ? 0 : answer;
    }
    
}

class Observer {

    int from;
    int to;
    int work;
    int rest;

    public Observer(int from, int to, int work, int rest) {
        this.from = from;
        this.to = to;
        this.work = work;
        this.rest = rest;
    }

}