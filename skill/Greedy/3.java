package Greedy;
import java.util.*;

class Main3 {
    public static boolean[] visited;
    public static String[] str;
    public static String result;

    public static void main(String[] args) {

        /*
            어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
            예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 
            이 중 가장 큰 숫자는 94 입니다.
            문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. 
            number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 
            solution 함수를 완성하세요
        */

        //System.out.println(solution("1924", 2)); // "94"
        //System.out.println(solution("1231234", 3)); // "3234"
        System.out.println(solution("4177252841", 4)); // "775841"

    }

    public static String solution(String number, int k) {
        int answer=0;
        str = number.split("");
        
        result = "";

        for(int i=0; i<str.length; i++) {
            visited = new boolean[str.length];
            answer = Math.max(answer, DFS(i, 1, k));
            result = "";

        }

        System.out.println("answer = " + answer);
        return Integer.toString(answer);
    }

    public static int DFS(int i, int count, int k) {
        System.out.println("DFS!");
        if (count > str.length - k) {
            System.out.println("count : " + count + ", str.length : " + str.length);
            System.out.println("result : " + result);
            System.out.println("return 1");
            return Integer.parseInt(result);
        }

        if (i < 0 || i >= str.length) {
            System.out.println("return 2");
            return Integer.parseInt(result);
        }

        if (visited[i] == false) {
            visited[i] = true;
            result += str[i];
            DFS(i++, count++, k);
            DFS(i--, count++, k);
        }

        return -1;

    }
    
}

    

