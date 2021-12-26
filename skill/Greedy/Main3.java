package Greedy;
import java.util.*;

class Main3 {
    public static boolean[] visited;
    public static String[] str;
    public static String result;

    public static void main(String[] args) {

        /*
            � ���ڿ��� k���� ���� �������� �� ���� �� �ִ� ���� ū ���ڸ� ���Ϸ� �մϴ�.
            ���� ���, ���� 1924���� �� �� ���� �����ϸ� [19, 12, 14, 92, 94, 24] �� ���� �� �ֽ��ϴ�. 
            �� �� ���� ū ���ڴ� 94 �Դϴ�.
            ���ڿ� �������� ���� number�� ������ ���� ���� k�� solution �Լ��� �Ű������� �־����ϴ�. 
            number���� k ���� ���� �������� �� ���� �� �ִ� �� �� ���� ū ���ڸ� ���ڿ� ���·� return �ϵ��� 
            solution �Լ��� �ϼ��ϼ���
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

    

