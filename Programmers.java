
import java.util.*;

public class Programmers {
    static long[] factArr = new long[21];

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(3, 5))); // [3,1,2]
        System.out.println(Arrays.toString(solution(3, 6))); // [3,2,1]
    }

    public static int[] solution(int n, long k) {
        int[] answer = new int[n];

        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++) list.add(i);

        int count = 0;
        
        factorial();

//        System.out.println(Arrays.toString(factArr));
        
        for(int i=0; i<n; i++) {
            if (count == k) {
                answer[i] = list.get(list.size()-1);
                list.remove(list.size()-1);
                continue;
            }

            int listIndex = 0;
            for(int j=0; j<list.size(); j++) {
                listIndex = j;

                long factNum = factArr[n - (i + 1)];

                if (count + factNum < k) count += factArr[n-(i+1)];
                else if (count + factNum == k) {
                    count += factArr[n-(i+1)];
                    break;
                } else break; // count + factNum > k
            }

            answer[i] = list.get(listIndex);
            list.remove(listIndex);
//            System.out.println("answer[i] = " + answer[i]);
        }

        /*
            4 1 2 3
            4 1 3 2
            4 2 1 3
            4 2 3 1
            4 3 1 2
            4 3 2 1
            
         */

        return answer;
    }

    private static void factorial() {
        factArr[1] = 1;
        for(int i=2; i<=20; i++) {
            factArr[i] = factArr[i-1] * i;
        }
    }
}
