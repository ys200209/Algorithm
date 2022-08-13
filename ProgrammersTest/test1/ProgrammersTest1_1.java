import java.util.*;

class ProgrammersTest1_1 {
    // static Queue<String> pq = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) {

        System.out.println(solution("100", "2345")); // -1
        System.out.println(solution("100", "203045")); // 0
        System.out.println(solution("5525", "1255")); // 552

    }
    
    public static String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        Queue<String> pq = new PriorityQueue<>(Collections.reverseOrder());

        int[] arr = new int[10];

        for(String c : X.split("")) {
            arr[Integer.parseInt(c)] += 1;
        }

        for(String c : Y.split("")) {
            int index = Integer.parseInt(c);
            
            if (arr[index] > 0) {
                pq.offer(c);
                arr[index] -= 1;
            }
        }

        if (pq.isEmpty()) {
            return "-1";
        } else {
            while(!pq.isEmpty()) {
                sb.append(pq.poll());

                if (sb.length() == 1 && sb.toString().equals("0")) return "0";
            }
        }

        return sb.toString();
    }
    
}