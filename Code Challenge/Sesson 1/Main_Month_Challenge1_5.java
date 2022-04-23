import java.util.*;

class Main_Month_Challenge1_5 {
    
    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution("110010101001"))); // [3,8]

    }

    public static int[] solution(String s) {
        int[] answer = new int[2];
        int remove=0, count=0;

        while(!s.equals("1")) {
            int before = s.length();

            s = s.replaceAll("0", "");

            int after = s.length();

            remove += (before - after);
            
            s = Convert(after);

            count++;
        }

        answer[0] = count;
        answer[1] = remove;
        return answer;
    }

    public static String Convert(int n) {
        StringBuilder str = new StringBuilder();

        while(n > 1) {
            str.append(n % 2);
            n /= 2;
        }
        str.append(n);

        return str.reverse().toString();
    }

}